package dev.thallys.ms.carrinho.service;

import dev.thallys.ms.carrinho.dto.ProdutoDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "produto-api")
public interface ProdutoClient {

    @GET
    @Path("/produtos/{id}")
    ProdutoDTO getProdutoById(@PathParam("id") Long id);

}