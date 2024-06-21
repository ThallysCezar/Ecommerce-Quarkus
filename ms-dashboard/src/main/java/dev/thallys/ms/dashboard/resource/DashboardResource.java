package dev.thallys.ms.dashboard.resource;

import dev.thallys.ms.dashboard.dto.ActiveUsersDTO;
import dev.thallys.ms.dashboard.dto.BestSellingProductDTO;
import dev.thallys.ms.dashboard.dto.InactiveUsersDTO;
import dev.thallys.ms.dashboard.dto.TotalSalesDTO;
import dev.thallys.ms.dashboard.service.DashboardService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("/metrics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DashboardResource {

    @Inject
    DashboardService dashboardService;

    @GET
    @Path("/active-users")
    @Counted(name = "Contador de usuario ativos")
    @Timed(
            name = "Quantos usuarios inativos",
            description = "usuarios inativos"
    )
    public Response getActiveUsers() {
        ActiveUsersDTO activeUsers = dashboardService.getActiveUsers();
        return Response.ok(activeUsers).build();
    }

    @GET
    @Path("/inactive-users")
    @Counted(name = "Contador de usuario inativos")
    @Timed(
        name = "Quantos usuarios inativos",
        description = "usuarios inativos"
    )
    public Response getInactiveUsers() {
        InactiveUsersDTO inactiveUsers = dashboardService.getInactiveUsers();
        return Response.ok(inactiveUsers).build();
    }

    @GET
    @Path("/best-selling-product")
    @Counted(name = "Contador de produtos mais vendidos")
    public Response getBestSellingProduct() {
        BestSellingProductDTO bestSellingProduct = dashboardService.getBestSellingProduct();
        return Response.ok(bestSellingProduct).build();
    }

    @GET
    @Path("/total-sales")
    @Counted(name = "Contador de total de vendas")
    public Response getTotalSales() {
        TotalSalesDTO totalSales = dashboardService.getTotalSales();
        return Response.ok(totalSales).build();
    }

}