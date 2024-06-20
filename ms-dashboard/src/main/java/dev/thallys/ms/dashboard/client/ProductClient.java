package dev.thallys.ms.dashboard.client;

import dev.thallys.ms.dashboard.entity.Product;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Map;

@Path("/products")
@RegisterRestClient(configKey = "product-api")
public interface ProductClient {

    @GET
    @Path("/produtos/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Product getProductById(@PathParam("id") Long id);

}