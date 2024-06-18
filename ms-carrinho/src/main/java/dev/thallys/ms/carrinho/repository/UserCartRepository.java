package dev.thallys.ms.carrinho.repository;

import dev.thallys.ms.carrinho.entity.UserCart;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserCartRepository implements PanacheRepository<UserCart> {
}