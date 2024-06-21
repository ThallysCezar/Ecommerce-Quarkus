package dev.thallys.ms.dashboard.service;

import dev.thallys.ms.dashboard.client.CartClient;
import dev.thallys.ms.dashboard.client.CheckOutClient;
import dev.thallys.ms.dashboard.dto.ActiveUsersDTO;
import dev.thallys.ms.dashboard.dto.BestSellingProductDTO;
import dev.thallys.ms.dashboard.dto.InactiveUsersDTO;
import dev.thallys.ms.dashboard.dto.TotalSalesDTO;
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

    public ActiveUsersDTO getActiveUsers() {
        List<Cart> activeUsers = carrinhoClient.getActiveUsers();
        long activeCount = activeUsers.size();
        return new ActiveUsersDTO(activeCount);
    }

    public InactiveUsersDTO getInactiveUsers() {
        List<Cart> inactiveUsers = carrinhoClient.getInactiveUsers();
        long inactiveCount = inactiveUsers.size();
        return new InactiveUsersDTO(inactiveCount);
    }

    public BestSellingProductDTO getBestSellingProduct() {
        return carrinhoClient.getBestSellingProduct();
    }

    public TotalSalesDTO getTotalSales() {
        Double totalSales = checkoutClient.getTotalSales();
        String formattedTotalSales = String.format("R$ %.2f", totalSales);
        return new TotalSalesDTO(formattedTotalSales);
    }

}