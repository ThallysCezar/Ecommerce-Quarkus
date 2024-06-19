package dev.thallys.ms.checkout.repository;

import dev.thallys.ms.checkout.entity.CheckOut;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CheckOutRepository implements PanacheRepository<CheckOut> {
}
