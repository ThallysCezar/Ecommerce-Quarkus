package dev.thallys.ms.config.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.HashMap;
import java.util.Map;

@Path("/config")
public class ConfigResource {

    @ConfigProperty(name = "my.custom.config")
    String myConfigProperty;

    // Banco de dados
    @ConfigProperty(name = "db.kind")
    String dbKind;

    @ConfigProperty(name = "db.url")
    String dbUrl;

    @ConfigProperty(name = "db.username")
    String dbUser;

    @ConfigProperty(name = "db.password")
    String dbPassword;

    @ConfigProperty(name = "db.driver")
    String dbDriver;

    @ConfigProperty(name = "db.min-size")
    int dbMinSize;

    @ConfigProperty(name = "db.max-size")
    int dbMaxSize;

    @ConfigProperty(name = "db.acquire-timeout")
    int dbAcquireTimeout;

    @ConfigProperty(name = "db.validation-timeout")
    int dbValidationTimeout;

    // Hibernate
    @ConfigProperty(name = "hibernate.log.format-sql")
    boolean hibernateLogFormatSql;

    @ConfigProperty(name = "hibernate.log.sql")
    boolean hibernateLogSql;

    @ConfigProperty(name = "hibernate.sql-load-script")
    String hibernateSqlLoadScript;

    @ConfigProperty(name = "hibernate.database.generation")
    String hibernateDatabaseGeneration;

    // Swagger ms-carrinho
    @ConfigProperty(name = "swagger.info-title.ms-carrinho")
    String swaggerTitleMsCarrinho;

    @ConfigProperty(name = "swagger.info-version.ms-carrinho")
    String swaggerVersionMsCarrinho;

    @ConfigProperty(name = "swagger.info-description.ms-carrinho")
    String swaggerDescriptionMsCarrinho;

    @ConfigProperty(name = "swagger.info-contact-name.ms-carrinho")
    String swaggerContactNameMsCarrinho;

    @ConfigProperty(name = "swagger.info-contact-url.ms-carrinho")
    String swaggerContactUrlMsCarrinho;

    // Swagger ms-checkout
    @ConfigProperty(name = "swagger.info-title.ms-checkout")
    String swaggerTitleMsCheckout;

    @ConfigProperty(name = "swagger.info-version.ms-checkout")
    String swaggerVersionMsCheckout;

    @ConfigProperty(name = "swagger.info-description.ms-checkout")
    String swaggerDescriptionMsCheckout;

    @ConfigProperty(name = "swagger.info-contact-name.ms-checkout")
    String swaggerContactNameMsCheckout;

    @ConfigProperty(name = "swagger.info-contact-url.ms-checkout")
    String swaggerContactUrlMsCheckout;

    // Swagger ms-dashborad
    @ConfigProperty(name = "swagger.info-title.ms-dashboard")
    String swaggerTitleMsDashBoard;

    @ConfigProperty(name = "swagger.info-version.ms-dashboard")
    String swaggerVersionMsDashBoard;

    @ConfigProperty(name = "swagger.info-description.ms-dashboard")
    String swaggerDescriptionMsDashBoard;

    @ConfigProperty(name = "swagger.info-contact-name.ms-dashboard")
    String swaggerContactNameMsDashBoard;

    @ConfigProperty(name = "swagger.info-contact-url.ms-dashboard")
    String swaggerContactUrlMsDashBoard;

    // Swagger ms-produtos
    @ConfigProperty(name = "swagger.info-title.ms-produtos")
    String swaggerTitleMsProdutos;

    @ConfigProperty(name = "swagger.info-version.ms-produtos")
    String swaggerVersionMsProdutos;

    @ConfigProperty(name = "swagger.info-description.ms-produtos")
    String swaggerDescriptionMsProdutos;

    @ConfigProperty(name = "swagger.info-contact-name.ms-produtos")
    String swaggerContactNameMsProdutos;

    @ConfigProperty(name = "swagger.info-contact-url.ms-produtos")
    String swaggerContactUrlMsProdutos;


    @GET
    @Path("/db")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDbConfig() {
        Map<String, Object> dbConfig = new HashMap<>();
        dbConfig.put("kind", dbKind);
        dbConfig.put("url", dbUrl);
        dbConfig.put("username", dbUser);
        dbConfig.put("password", dbPassword);
        dbConfig.put("driver", dbDriver);
        dbConfig.put("minSize", dbMinSize);
        dbConfig.put("maxSize", dbMaxSize);
        dbConfig.put("acquireTimeout", dbAcquireTimeout);
        dbConfig.put("validationTimeout", dbValidationTimeout);
        return Response.ok(dbConfig).build();
    }

    @GET
    @Path("/hibernate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHibernateConfig() {
        Map<String, Object> hibernateConfig = new HashMap<>();
        hibernateConfig.put("logFormatSql", hibernateLogFormatSql);
        hibernateConfig.put("logSql", hibernateLogSql);
        hibernateConfig.put("sqlLoadScript", hibernateSqlLoadScript);
        hibernateConfig.put("databaseGeneration", hibernateDatabaseGeneration);
        return Response.ok(hibernateConfig).build();
    }

    @GET
    @Path("/swagger/ms-carrinho")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSwaggerConfigMsCarrinho() {
        Map<String, String> swaggerConfig = new HashMap<>();
        swaggerConfig.put("title", swaggerTitleMsCarrinho);
        swaggerConfig.put("version", swaggerVersionMsCarrinho);
        swaggerConfig.put("description", swaggerDescriptionMsCarrinho);
        swaggerConfig.put("contactName", swaggerContactNameMsCarrinho);
        swaggerConfig.put("contactUrl", swaggerContactUrlMsCarrinho);
        return Response.ok(swaggerConfig).build();
    }

    @GET
    @Path("/swagger/ms-checkout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSwaggerConfigMsCheckout() {
        Map<String, String> swaggerConfig = new HashMap<>();
        swaggerConfig.put("title", swaggerTitleMsCheckout);
        swaggerConfig.put("version", swaggerVersionMsCheckout);
        swaggerConfig.put("description", swaggerDescriptionMsCheckout);
        swaggerConfig.put("contactName", swaggerContactNameMsCheckout);
        swaggerConfig.put("contactUrl", swaggerContactUrlMsCheckout);
        return Response.ok(swaggerConfig).build();
    }

    @GET
    @Path("/swagger/ms-dashboard")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSwaggerConfigMsDashBoard() {
        Map<String, String> swaggerConfig = new HashMap<>();
        swaggerConfig.put("title", swaggerTitleMsDashBoard);
        swaggerConfig.put("version", swaggerVersionMsDashBoard);
        swaggerConfig.put("description", swaggerDescriptionMsDashBoard);
        swaggerConfig.put("contactName", swaggerContactNameMsDashBoard);
        swaggerConfig.put("contactUrl", swaggerContactUrlMsDashBoard);
        return Response.ok(swaggerConfig).build();
    }

    @GET
    @Path("/swagger/ms-produtos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSwaggerConfigMsProdutos() {
        Map<String, String> swaggerConfig = new HashMap<>();
        swaggerConfig.put("title", swaggerTitleMsProdutos);
        swaggerConfig.put("version", swaggerVersionMsProdutos);
        swaggerConfig.put("description", swaggerDescriptionMsProdutos);
        swaggerConfig.put("contactName", swaggerContactNameMsProdutos);
        swaggerConfig.put("contactUrl", swaggerContactUrlMsProdutos);
        return Response.ok(swaggerConfig).build();
    }

    @GET
    @Path("/my-property")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMyProperty() {
        return myConfigProperty;
    }

}