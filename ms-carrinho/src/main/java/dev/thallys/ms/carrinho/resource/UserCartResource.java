package dev.thallys.ms.carrinho.resource;

import dev.thallys.ms.carrinho.dto.UserCartDTO;
import dev.thallys.ms.carrinho.entity.UserCart;
import dev.thallys.ms.carrinho.service.UserCartService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Set;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserCartResource {

    @Inject
    UserCartService userCartService;

    @GET
    @Path("/{userId}/exists")
    public boolean userExists(@PathParam("userId") Long userId) {
        return userCartService.userExists(userId);
    }

    @GET
    @Path("/{cartId}/cart/products")
    public Set<Long> getProductIdsInCart(@PathParam("cartId") Long cartId) {
        return userCartService.getProductIdsInCart(cartId);
    }

    @GET
    public Response findAll() {
        List<UserCartDTO> userCartList = userCartService.getAll();
        return Response.ok(userCartList).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        UserCartDTO userCartDTO = userCartService.getById(id);
        if (userCartDTO != null) {
            return Response.ok(userCartDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/active")
    public List<UserCart> getActiveUsers() {
        return userCartService.getActiveUsers();
    }

    @GET
    @Path("/inactive")
    public List<UserCart> getInactiveUsers() {
        return userCartService.getInactiveUsers();
    }

    @POST
    public Response createUserCart(UserCartDTO dto) {
        UserCartDTO createdUserCart = userCartService.createUserCart(dto);
        if (createdUserCart != null) {
            return Response.created(URI.create("/users/" + createdUserCart.getId())).entity(createdUserCart).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUserCart(@PathParam("id") Long id, UserCartDTO dto) {
        dto.setId(id);
        UserCartDTO updatedUserCart = userCartService.updateUserCart(dto);
        if (updatedUserCart != null) {
            return Response.ok(updatedUserCart).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Long id) {
        boolean deleted = userCartService.deleteUserCart(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
