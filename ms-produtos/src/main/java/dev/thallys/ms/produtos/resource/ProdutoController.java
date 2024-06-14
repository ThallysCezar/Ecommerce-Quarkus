package dev.thallys.ms.produtos.resource;

import dev.thallys.ms.produtos.dto.ProdutoDTO;
import dev.thallys.ms.produtos.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

    @Inject
    ProdutoService produtoService;

    @GET
    @Transactional
    public Response findAll() {
        return produtoService.getAll();
    }

    @GET
    @Path("{id}")
    @Transactional
    public Response findById(@PathParam("id") Long id) {
        return produtoService.getById(id);
    }

    @POST
    @Transactional
    public Response createFruta(ProdutoDTO dto) {
        return produtoService.createProduto(dto);
    }

    @PUT
    @Transactional
    public Response updateFruta(ProdutoDTO dto) {
        return produtoService.updateProduto(dto);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        return produtoService.deleteById(id);
    }
}