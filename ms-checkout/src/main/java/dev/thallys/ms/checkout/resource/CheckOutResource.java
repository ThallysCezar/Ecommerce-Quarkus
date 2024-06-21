package dev.thallys.ms.checkout.resource;

import dev.thallys.ms.checkout.entity.CheckOut;
import dev.thallys.ms.checkout.entity.CompletedCheckOutRequest;
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

    @GET
    @Path("/total-sales")
    public Response getTotalSales(){
        Double totalSales = checkOutService.getTotalSales();
        return Response.ok(totalSales).build();
    }

    @POST
    @Path("/start")
    public Response iniciarCheckout(StartCheckOutRequest request) {
        CheckOut updatedCheckout = checkOutService.iniciarCheckout(request.getUserId());
        if (updatedCheckout == null) {
            throw new WebApplicationException("Checkout not found", 404);
        }
        return Response.status(Response.Status.OK).entity(updatedCheckout).build();
    }

    @GET
    @Path("/{id}")
    public CheckOut obterCheckout(@PathParam("id") Long id) {
        return checkOutService.obterCheckoutPorId(id);
    }

    @POST
    @Path("/{id}/complete")
    public Response finalizarCheckout(@PathParam("id") Long id, CompletedCheckOutRequest request) {
        CheckOut checkout = checkOutService.finalizarCheckout(id, request.getTotal(), request.getFormaPagamento());
        return Response.ok(checkout).build();
    }

    @POST
    @Path("/{id}/cancel")
    public Response cancelarCheckout(@PathParam("id") Long id) {
        checkOutService.cancelarCheckout(id);
        return Response.noContent().build();
    }

}
