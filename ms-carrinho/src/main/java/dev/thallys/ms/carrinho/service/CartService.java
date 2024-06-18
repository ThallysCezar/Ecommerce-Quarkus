package dev.thallys.ms.carrinho.service;

import dev.thallys.ms.carrinho.dto.ProdutoDTO;
import dev.thallys.ms.carrinho.entity.CartItem;
import dev.thallys.ms.carrinho.repository.CartRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CartService {

    @Inject
    CartRepository cartRepository;

    @Inject
    @RestClient
    ProdutoClient produtoClient;

    private static final Logger LOGGER = Logger.getLogger(CartService.class);

    public List<CartItem> getAllItems() {
        return cartRepository.listAll();
    }

    @Transactional
    public CartItem addItem(Long productId, int quantity) {
        ProdutoDTO produto = produtoClient.getProdutoById(productId);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }

        Optional<CartItem> existingItem = cartRepository.findByProductId(productId);
        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            cartRepository.persist(item);
            return item;
        } else {
            CartItem newItem = new CartItem();
            newItem.setProductId(productId);  // Certifique-se de que o productId está sendo setado aqui
            newItem.setQuantity(quantity);    // Certifique-se de que a quantidade está sendo setada aqui
            cartRepository.persist(newItem);
            return newItem;
        }
    }

    @Transactional
    public CartItem updateItem(Long itemId, int quantity) {
        LOGGER.info("Atualizando item com ID: " + itemId + " para quantidade: " + quantity);

        CartItem item = cartRepository.findById(itemId);
        if (item == null) {
            throw new IllegalArgumentException("Item não encontrado");
        }
        item.setQuantity(quantity);
        cartRepository.persist(item);
        LOGGER.info("Item atualizado: " + item);
        return item;
    }

    @Transactional
    public void removeItem(Long itemId) {
        CartItem item = cartRepository.findById(itemId);
        if (item != null) {
            cartRepository.delete(item);
        }
    }

}