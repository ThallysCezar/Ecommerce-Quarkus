package dev.thallys.ms.checkout.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import java.util.Map;

@RegisterRestClient(configKey = "products-api")
public interface ProductClient {

    @GET
    @Path("/products/availability")
    Map<Long, Boolean> checkProductAvailability(@QueryParam("ids") List<Long> ids);

    @GET
    @Path("/products/prices")
    Map<Long, Double> getProductPrices(@QueryParam("ids") List<Long> ids);

}
