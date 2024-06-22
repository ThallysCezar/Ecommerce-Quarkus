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
import org.eclipse.microprofile.metrics.MetricUnits;
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
    @Counted(name = "activeUsersCount", description = "Contador de usuarios ativos")
    @Timed(name = "activeUsersRequestTime", description = "Tempo de resposta para obter usuários ativos", unit = MetricUnits.MILLISECONDS)
    public Response getActiveUsers() {
        ActiveUsersDTO activeUsers = dashboardService.getActiveUsers();
        return Response.ok(activeUsers).build();
    }

    @GET
    @Path("/inactive-users")
    @Counted(name = "inactiveUsersCount", description = "Contador de usuarios inativos")
    @Timed(name = "inactiveUsersRequestTime", description = "Tempo de resposta para obter usuários inativos", unit = MetricUnits.MILLISECONDS)
    public Response getInactiveUsers() {
        InactiveUsersDTO inactiveUsers = dashboardService.getInactiveUsers();
        return Response.ok(inactiveUsers).build();
    }

    @GET
    @Path("/best-selling-product")
    @Counted(name = "bestSellingProductRequests", description = "Número de vezes que o produto mais vendido foi solicitado")
    @Timed(name = "bestSellingProductRequestTime", description = "Tempo de resposta para obter o produto mais vendido", unit = MetricUnits.MILLISECONDS)
    public Response getBestSellingProduct() {
        BestSellingProductDTO bestSellingProduct = dashboardService.getBestSellingProduct();
        return Response.ok(bestSellingProduct).build();
    }

    @GET
    @Path("/total-sales")
    @Counted(name = "totalSalesRequests", description = "Número de vezes que o total de vendas foi solicitado")
    @Timed(name = "totalSalesRequestTime", description = "Tempo de resposta para obter o total de vendas", unit = MetricUnits.MILLISECONDS)
    public Response getTotalSales() {
        TotalSalesDTO totalSales = dashboardService.getTotalSales();
        return Response.ok(totalSales).build();
    }

}