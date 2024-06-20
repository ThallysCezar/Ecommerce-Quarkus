package dev.thallys.ms.dashboard.resource;

import dev.thallys.ms.dashboard.entity.Cart;
import dev.thallys.ms.dashboard.service.DashboardService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Map;

@Path("/metrics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DashboardResource {

    @Inject
    DashboardService dashboardService;

    @GET
    @Path("/active-users")
    public Response getActiveUsers() {
        List<Cart> activeUsers = dashboardService.getActiveUsers();
        return Response.ok(activeUsers).build();
    }

    @GET
    @Path("/inactive-users")
    public Response getInactiveUsers() {
        List<Cart> inactiveUsers = dashboardService.getInactiveUsers();
        return Response.ok(inactiveUsers).build();
    }

    @GET
    @Path("/best-selling-product")
    public Response getBestSellingProduct() {
        Map.Entry<Long, Long> bestSellingProduct = dashboardService.getBestSellingProduct();
        return Response.ok(bestSellingProduct).build();
    }

    @GET
    @Path("/total-sales")
    public Response getTotalSales() {
        Double totalSales = dashboardService.getTotalSales();
        return Response.ok(totalSales).build();
    }

}