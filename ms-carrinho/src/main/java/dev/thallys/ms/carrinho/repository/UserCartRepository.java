package dev.thallys.ms.carrinho.repository;

import dev.thallys.ms.carrinho.entity.UserCart;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UserCartRepository implements PanacheRepository<UserCart> {

    public List<UserCart> findActiveUsers() {
        return list("active", true);
    }

    public List<UserCart> findInactiveUsers() {
        return list("active", false);
    }

}