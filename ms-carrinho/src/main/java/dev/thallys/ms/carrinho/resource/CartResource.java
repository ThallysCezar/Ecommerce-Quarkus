package dev.thallys.ms.carrinho.resource;

import dev.thallys.ms.carrinho.dto.CartItemDTO;
import dev.thallys.ms.carrinho.entity.CartItem;
import dev.thallys.ms.carrinho.service.CartService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;

@Path("/carts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {

    @Inject
    CartService cartService;

    @GET
    public List<CartItem> getAllItems() {
        return cartService.getAllItems();
    }

    @POST
    @Path("/add")
    public CartItem addItem(@RequestBody CartItemDTO cartItemDTO) {
        return cartService.addItem(cartItemDTO.getProductId(), cartItemDTO.getQuantity());
    }

    @PUT
    @Path("/update/{id}")
    public CartItem updateItem(@PathParam("id") Long itemId, @QueryParam("quantity") int quantity) {
        return cartService.updateItem(itemId, quantity);
    }

    @DELETE
    @Path("/remove/{id}")
    public void remoteItem(@PathParam("id") Long itemId) {
        cartService.removeItem(itemId);
    }

}
