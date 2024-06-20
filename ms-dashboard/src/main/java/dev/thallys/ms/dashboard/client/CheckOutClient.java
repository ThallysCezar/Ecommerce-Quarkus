package dev.thallys.ms.dashboard.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/checkout")
@RegisterRestClient(configKey = "checkout-api")
public interface CheckOutClient {

    @GET
    @Path("/total-sales")
    Void getTotalSales();

}