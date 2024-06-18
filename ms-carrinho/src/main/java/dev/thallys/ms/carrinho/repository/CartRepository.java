package dev.thallys.ms.carrinho.repository;

import dev.thallys.ms.carrinho.entity.CartItem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class CartRepository implements PanacheRepository<CartItem> {
    public Optional<CartItem> findByProductIdsAndUserId(Set<Long> productIds, Long userId) {
        List<CartItem> cartItems = find("usercart.id", userId).list();

        return cartItems.stream()
                .filter(cartItem -> cartItem.getProductIds().equals(productIds))
                .findFirst();
    }

}