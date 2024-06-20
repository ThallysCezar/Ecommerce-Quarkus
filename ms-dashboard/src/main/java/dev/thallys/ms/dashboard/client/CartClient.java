package dev.thallys.ms.dashboard.client;

import dev.thallys.ms.dashboard.entity.Cart;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import java.util.Map;

@Path("/cart")
@RegisterRestClient(configKey = "cart-api")
public interface CartClient {

    @GET
    @Path("/users/active")
    List<Cart> getActiveUsers();

    @GET
    @Path("/users/inactive")
    List<Cart> getInactiveUsers();

    @GET
    @Path("/carts/best-selling-product")
    Map.Entry<Long, Long> getBestSellingProduct();

}