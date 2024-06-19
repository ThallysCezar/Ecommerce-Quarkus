package dev.thallys.ms.checkout.resource;

import dev.thallys.ms.checkout.entity.CheckOut;
import dev.thallys.ms.checkout.entity.StartCheckOutRequest;
import dev.thallys.ms.checkout.service.CheckOutService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/checkout")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CheckOutResource {

    @Inject
    CheckOutService checkOutService;

    @POST
    @Path("/start")
    public Response iniciarCheckout(StartCheckOutRequest request) {
        CheckOut checkout = checkOutService.iniciarCheckout(request.userId);
        return Response.status(Response.Status.CREATED).entity(checkout).build();
    }

    @GET
    @Path("/{id}")
    public CheckOut obterCheckout(@PathParam("id") Long id) {
        return checkOutService.obterCheckoutPorId(id);
    }

    @PUT
    @Path("/{id}/complete")
    public Response finalizarCheckout(@PathParam("id") Long id, double total) {
        CheckOut checkout = checkOutService.finalizarCheckout(id, total);
        return Response.ok(checkout).build();
    }

    @PUT
    @Path("/{id}/cancel")
    public Response cancelarCheckout(@PathParam("id") Long id) {
        checkOutService.cancelarCheckout(id);
        return Response.noContent().build();
    }

}
