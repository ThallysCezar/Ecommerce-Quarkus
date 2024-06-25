package dev.thallys.ms.config.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Map;

@RegisterRestClient(baseUri = "http://localhost:8085/config")
public interface ConfigClient {

    @GET
    @Path("/config/db")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> getDbConfig();

    @GET
    @Path("/config/hibernate")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> getHibernateConfig();

    @GET
    @Path("/config/hibernate/ms-carrinho")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> getHibernateConfigMsCarrinho();

    @GET
    @Path("/config/hibernate/ms-checkout")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> getHibernateConfigMsCheckout();

    @GET
    @Path("/config/hibernate/ms-produtos")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object> getHibernateConfigMsProdutos();

    @GET
    @Path("/config/swagger/ms-carrinho")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, String> getSwaggerConfigMsCarrinho();

    @GET
    @Path("/config/swagger/ms-checkout")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, String> getSwaggerConfigMsCheckout();

    @GET
    @Path("/config/swagger/ms-dashboard")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, String> getSwaggerConfigMsDashBoard();

    @GET
    @Path("/config/swagger/ms-produtos")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, String> getSwaggerConfigMsProdutos();

    @GET
    @Path("/config/services")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, String> getServicesConfig();

}