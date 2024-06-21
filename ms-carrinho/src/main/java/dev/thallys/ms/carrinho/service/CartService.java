package dev.thallys.ms.carrinho.service;

import dev.thallys.ms.carrinho.dto.BestSellingProductDTO;
import dev.thallys.ms.carrinho.dto.ProdutoDTO;
import dev.thallys.ms.carrinho.entity.CartItem;
import dev.thallys.ms.carrinho.entity.UserCart;
import dev.thallys.ms.carrinho.repository.CartRepository;
import dev.thallys.ms.carrinho.repository.UserCartRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.*;
import java.util.stream.Collectors;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.list;

@ApplicationScoped
public class CartService {

    @Inject
    CartRepository cartRepository;

    @Inject
    UserCartRepository userRepository;

    @Inject
    @RestClient
    ProdutoClient produtoClient;

    private static final Logger LOGGER = Logger.getLogger(CartService.class);

    public List<CartItem> getAllItems() {
        return cartRepository.listAll();
    }

    public BestSellingProductDTO getBestSellingProduct() {
        List<CartItem> cartItems = cartRepository.listAll();
        Map<Long, Long> productCount = new HashMap<>();

        for (CartItem item : cartItems) {
            Set<Long> productIds = item.getProductIds();
            for (Long productId : productIds) {
                productCount.put(productId, productCount.getOrDefault(productId, 0L) + 1);
            }
        }

        Map.Entry<Long, Long> maxEntry = Collections.max(productCount.entrySet(), Map.Entry.comparingByValue());
        return new BestSellingProductDTO(maxEntry.getKey(), maxEntry.getValue());
    }

    @Transactional
    public CartItem addItem(Set<Long> productIds, int quantity, Long usuarioId) {
        for (Long productId : productIds) {
            ProdutoDTO produto = produtoClient.getProdutoById(productId);
            if (produto == null) {
                throw new IllegalArgumentException("Produto com ID " + productId + " não encontrado");
            }
        }

        UserCart user = userRepository.findById(usuarioId);
        if (user == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        Optional<CartItem> existingItem = cartRepository.findByProductIdsAndUserId(productIds, usuarioId);
        return existingItem.map(cartItem -> updateExistingItem(cartItem, quantity)).orElseGet(() -> createNewItem(productIds, quantity, user));
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

    private CartItem createNewItem(Set<Long> productIds, int quantity, UserCart user) {
        CartItem newItem = new CartItem();
        newItem.setProductIds(productIds);
        newItem.setQuantity(quantity);
        newItem.setUser(user);
        newItem.persist();
        return newItem;
    }

    public Set<Long> getProductIdsInCart(Long cartId) {
        // Ajuste na lógica para pegar todos os IDs dos produtos associados ao carrinho
        return cartRepository.find("cart.id", cartId).stream()
                .flatMap(cartItem -> cartItem.getProductIds().stream())
                .collect(Collectors.toSet());
    }

}