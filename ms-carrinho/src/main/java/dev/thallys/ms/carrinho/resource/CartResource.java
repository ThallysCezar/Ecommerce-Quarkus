package dev.thallys.ms.carrinho.resource;

import dev.thallys.ms.carrinho.dto.CartItemDTO;
import dev.thallys.ms.carrinho.entity.CartItem;
import dev.thallys.ms.carrinho.service.CartService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Path("/carts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {

    @Inject
    CartService cartService;

    @GET
    public Response getAllItems() {
        List<CartItem> cartItems = cartService.getAllItems();
        return Response.ok(cartItems).build();
    }

    @GET
    @Path("/best-selling-product")
    public Map.Entry<Long, Long> getBestSellingProduct() {
        return cartService.getBestSellingProduct();
    }

    @POST
    @Path("/add")
    public Response addItem(CartItemDTO cartItemDTO) {
        CartItem cartItem = cartService.addItem(cartItemDTO.getProductIds(), cartItemDTO.getQuantity(), cartItemDTO.getUsuarioId());
        return Response.created(URI.create("/carts/" + cartItem.getId())).build();
    }

    @PUT
    @Path("/{itemId}")
    public Response updateItem(@PathParam("itemId") Long itemId, CartItemDTO updateDTO) {
        CartItem updatedItem = cartService.updateItem(itemId, updateDTO.getQuantity());
        if (updatedItem == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Item não encontrado").build();
        }
        return Response.noContent().build();
    }

    @DELETE
    @Path("/remove/{id}")
    public Response remoteItem(@PathParam("id") Long itemId) {
        boolean removed = cartService.removeItem(itemId);
        if (!removed) {
            return Response.status(Response.Status.NOT_FOUND).entity("Item não encontrado").build();
        }
        return Response.noContent().build();
    }

}
