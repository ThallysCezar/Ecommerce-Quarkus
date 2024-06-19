package dev.thallys.ms.checkout.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "cart-api")
public interface CartItemClient {

    @GET
    @Path("/users/{userId}/exists")
    boolean userExists(@PathParam("userId") Long userId);

    @GET
    @Path("/users/{cartId}/cart/products")
    List<Long> getProductIdsInCart(@PathParam("cartId") Long cartId);

}
