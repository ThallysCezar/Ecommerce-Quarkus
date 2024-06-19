package dev.thallys.ms.checkout.service;

import dev.thallys.ms.checkout.entity.CheckOut;
import dev.thallys.ms.checkout.repository.CheckOutRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.Map;

@ApplicationScoped
public class CheckOutService {

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
        // Verifica se o usuário existe no ms-carrinho
        if (!cartClient.userExists(userId)) {
            throw new WebApplicationException("User not found", 404);
        }

        // Obtém os IDs dos produtos no carrinho do usuário
        List<Long> productIds = cartClient.getProductIdsInCart(userId);

        // Verifica a disponibilidade dos produtos
        Map<Long, Boolean> availability = productClient.checkProductAvailability(productIds);
        for (Boolean available : availability.values()) {
            if (!available) {
                throw new WebApplicationException("One or more products are unavailable", 400);
            }
        }

        // Obtém os preços dos produtos e calcula o total
        Map<Long, Double> prices = productClient.getProductPrices(productIds);
        Double total = prices.values().stream().mapToDouble(Double::doubleValue).sum();

        CheckOut checkout = new CheckOut();
        checkout.setUserId(userId);
        checkout.setStatus("IN_PROGRESS");
        checkOutRepository.persist(checkout);
        return checkout;
    }

    public CheckOut obterCheckoutPorId(Long id) {
        return checkOutRepository.findById(id);
    }

    @Transactional
    public CheckOut finalizarCheckout(Long id, double total) {
        CheckOut checkout = checkOutRepository.findById(id);
        if (checkout != null) {
            checkout.setStatus("COMPLETED");
            checkout.setTotal(total);
        }
        return checkout;
    }

    @Transactional
    public void cancelarCheckout(Long id) {
        CheckOut checkout = checkOutRepository.findById(id);
        if (checkout != null) {
            checkout.setStatus("CANCELLED");
        }
    }

}
