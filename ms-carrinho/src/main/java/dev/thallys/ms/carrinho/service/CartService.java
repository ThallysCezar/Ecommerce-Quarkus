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
        return existingItem.map(cartItem -> updateExistingItem(cartItem, quantity)).orElseGet(() -> createNewItem(productId, quantity));
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
    public boolean removeItem(Long itemId) {
        CartItem item = cartRepository.findById(itemId);
        if (item != null) {
            cartRepository.delete(item);
            return true;
        }
        return false;
    }

    private CartItem updateExistingItem(CartItem item, int quantity) {
        item.setQuantity(item.getQuantity() + quantity);
        cartRepository.persistAndFlush(item);
        return item;
    }

    private CartItem createNewItem(Long productId, int quantity) {
        CartItem newItem = new CartItem();
        newItem.setProductId(productId);
        newItem.setQuantity(quantity);
        cartRepository.persistAndFlush(newItem);
        return newItem;
    }

}