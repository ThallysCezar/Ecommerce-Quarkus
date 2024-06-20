package dev.thallys.ms.dashboard.service;

import dev.thallys.ms.dashboard.client.CartClient;
import dev.thallys.ms.dashboard.client.CheckOutClient;
import dev.thallys.ms.dashboard.entity.Cart;
import dev.thallys.ms.dashboard.entity.CheckOut;
import dev.thallys.ms.dashboard.entity.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DashboardService {

    @Inject
    @RestClient
    CartClient carrinhoClient;

    @Inject
    @RestClient
    CheckOutClient checkoutClient;

    public List<Cart> getActiveUsers() {
        return carrinhoClient.getActiveUsers();
    }

    public List<Cart> getInactiveUsers() {
        return carrinhoClient.getInactiveUsers();
    }

    public Map.Entry<Long, Long> getBestSellingProduct() {
        return carrinhoClient.getBestSellingProduct();
    }

    public Double getTotalSales() {
        checkoutClient.getTotalSales();
        // Implementar a lógica para retornar o total de vendas
        return null;
    }

}