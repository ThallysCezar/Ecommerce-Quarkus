package dev.thallys.ms.carrinho.repository;

import dev.thallys.ms.carrinho.entity.CartItem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class CartRepository implements PanacheRepository<CartItem> {

    public Optional<CartItem> findByProductId(Long productId) {
        return find("productId", productId).firstResultOptional();
    }

}