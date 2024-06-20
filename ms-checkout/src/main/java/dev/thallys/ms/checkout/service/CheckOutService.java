package dev.thallys.ms.checkout.service;

import dev.thallys.ms.checkout.entity.CheckOut;
import dev.thallys.ms.checkout.repository.CheckOutRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.apache.commons.codec.binary.StringUtils;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CheckOutService {

    private static final Logger LOG = Logger.getLogger(CheckOutService.class);

    @Inject
    CheckOutRepository checkOutRepository;

    @Inject
    @RestClient
    CartItemClient cartClient;

    @Inject
    @RestClient
    ProductClient productClient;

    @Transactional
    public CheckOut iniciarCheckout(Long userId) {
        LOG.info("Iniciando checkout para o usuário: " + userId);
        CheckOut existingCheckOut = checkOutRepository.findByUserId(userId);
        if (existingCheckOut != null) {
            LOG.info("Usuário já existente, no ms-checkout, com o id: " + userId);
            if (!cartClient.userExists(userId)) {
                throw new WebApplicationException("User not found", 404);
            }
            existingCheckOut.setStatus("IN_PROGRESS");
            checkOutRepository.persistAndFlush(existingCheckOut);
            return existingCheckOut;
        }

        LOG.info("Usuário não existente, no ms-checkout, com o id: " + userId + ", criando um novo checkout...");
        // Verifica se o usuário existe no ms-carrinho
        if (!cartClient.userExists(userId)) {
            throw new WebApplicationException("User not found", 404);
        }

        List<Long> productIds = cartClient.getProductIdsInCart(userId);

        Map<Long, Boolean> availability = productClient.checkProductAvailability(productIds);
        for (Boolean available : availability.values()) {
            if (!available) {
                throw new WebApplicationException("One or more products are unavailable", 400);
            }
        }

        Map<Long, Double> prices = productClient.getProductPrices(productIds);
        Double total = prices.values().stream().mapToDouble(Double::doubleValue).sum();

        CheckOut newCheckOut = new CheckOut();
        newCheckOut.setUserId(userId);
        newCheckOut.setStatus("IN_PROGRESS");
        newCheckOut.setTotal(total);
        checkOutRepository.persistAndFlush(newCheckOut);
        return newCheckOut;
    }

    public CheckOut obterCheckoutPorId(Long id) {
        return checkOutRepository.findById(id);
    }

    @Transactional
    public CheckOut finalizarCheckout(Long id, double total, String formaPagamento) {
        CheckOut checkout = checkOutRepository.findById(id);
        if (checkout == null) {
            // Caso não encontre o checkout, você pode lançar uma exceção
            throw new WebApplicationException("Checkout not found");
        }

        // Definir a forma de pagamento com base no parâmetro formaPagamento
        if (formaPagamento == null || formaPagamento.isEmpty() || formaPagamento.isBlank()) {
            checkout.setFormaPagamento("PIX");
        } else if (formaPagamento.equalsIgnoreCase("pix")) {
            checkout.setFormaPagamento("PIX");
        } else if (formaPagamento.equalsIgnoreCase("debito")) {
            checkout.setFormaPagamento("DÉBITO");
        } else if (formaPagamento.equalsIgnoreCase("credito")) {
            checkout.setFormaPagamento("CRÉDITO");
        } else if (formaPagamento.equalsIgnoreCase("boleto")) {
            checkout.setFormaPagamento("BOLETO");
        } else {
            // Caso o parâmetro formaPagamento seja inválido, você pode lançar uma exceção
            throw new IllegalArgumentException("Invalid payment method");
        }

        // Atualizar o status, o total e a forma de pagamento do checkout
        checkout.setStatus("COMPLETED");
        checkout.setTotal(total);
        checkOutRepository.persistAndFlush(checkout);

        return checkout;
    }

    @Transactional
    public void cancelarCheckout(Long id) {
        CheckOut checkout = checkOutRepository.findById(id);
        if (checkout != null) {
            checkout.setStatus("CANCELLED");
            checkout.setFormaPagamento("CANCELLED");
        }
    }

}
