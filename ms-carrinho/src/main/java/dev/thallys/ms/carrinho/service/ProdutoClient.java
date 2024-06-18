package dev.thallys.ms.carrinho.service;

import dev.thallys.ms.carrinho.dto.ProdutoDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "products-api")
@Produces(MediaType.APPLICATION_JSON)
public interface ProdutoClient {

    @GET
    @Path("/products/{id}")
    ProdutoDTO getProdutoById(@PathParam("id") Long id);

}