package dev.thallys.ms.produtos.resource;

import dev.thallys.ms.produtos.dto.ProdutoDTO;
import dev.thallys.ms.produtos.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

    @Inject
    ProdutoService produtoService;

    @GET
    public Response findAll() {
        List<ProdutoDTO> produtosList = produtoService.getAll();
        return Response.ok(produtosList).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        ProdutoDTO produtoDTO = produtoService.getById(id);
        if (produtoDTO != null) {
            return Response.ok(produtoDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createProduto(ProdutoDTO dto) {
        ProdutoDTO createdProduto = produtoService.createProduto(dto);
        if (createdProduto != null) {
            return Response.created(URI.create("/produtos/" + createdProduto.getId())).entity(createdProduto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduto(@PathParam("id") Long id, ProdutoDTO dto) {
        dto.setId(id);
        ProdutoDTO updatedProduto = produtoService.updateProduto(dto);
        if (updatedProduto != null) {
            return Response.ok(updatedProduto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Long id) {
        boolean deleted = produtoService.deleteById(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/availability")
    public Response checkProductAvailability(@QueryParam("ids") String ids) {
        if (ids == null || ids.trim().isEmpty()) {
            return Response.ok(Collections.emptyMap()).build();
        }

        List<Long> productIds = Arrays.stream(ids.split(","))
                .map(String::trim)
                .map(Long::parseLong)
                .collect(Collectors.toList());

        Map<Long, Boolean> availability = produtoService.checkProductAvailability(productIds);
        return Response.ok(availability).build();
    }

    @GET
    @Path("/prices")
    public Response getProductPrices(@QueryParam("ids") String ids) {
        if (ids == null || ids.trim().isEmpty()) {
            return Response.ok(Collections.emptyMap()).build();
        }

        List<Long> productIds = Arrays.stream(ids.split(","))
                .map(String::trim)
                .map(Long::parseLong)
                .collect(Collectors.toList());

        Map<Long, Double> prices = produtoService.getProductPrices(productIds);
        return Response.ok(prices).build();
    }

}