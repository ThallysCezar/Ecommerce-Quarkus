package dev.thallys.ms.config.service;

import dev.thallys.ms.config.client.ConfigClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Map;

@ApplicationScoped
public class ConfigService {

    @Inject
    @RestClient
    ConfigClient configClient;

    @ConfigProperty(name = "microservice.name")
    String microserviceName;

    public void useConfig() {
        Map<String, Object> dbConfig = configClient.getDbConfig();
        System.out.println("DB Config: " + dbConfig);

        Map<String, Object> hibernateConfig = configClient.getHibernateConfig();
        System.out.println("Hibernate Config: " + hibernateConfig);

        Map<String, String> swaggerConfig = getSwagger();
        System.out.println("Swagger Config (" + microserviceName + "): " + swaggerConfig);
    }

    private Map<String, Object> getHibernate() {
        Map<String, Object> hibernateConfig;
        if ("ms-carrinho".equals(microserviceName)) {
            hibernateConfig = configClient.getHibernateConfigMsCarrinho();
        } else if ("ms-checkout".equals(microserviceName)) {
            hibernateConfig = configClient.getHibernateConfigMsCheckout();
        } else if ("ms-produtos".equals(microserviceName)) {
            hibernateConfig = configClient.getHibernateConfigMsProdutos();
        } else if ("".equals(microserviceName)) {
            hibernateConfig = configClient.getHibernateConfig();
        } else {
            throw new IllegalArgumentException("Microservice name not recognized: " + microserviceName);
        }
        return hibernateConfig;
    }

    private Map<String, String> getSwagger() {
        Map<String, String> swaggerConfig;
        if ("ms-carrinho".equals(microserviceName)) {
            swaggerConfig = configClient.getSwaggerConfigMsCarrinho();
        } else if ("ms-checkout".equals(microserviceName)) {
            swaggerConfig = configClient.getSwaggerConfigMsCheckout();
        } else if ("ms-dashboard".equals(microserviceName)) {
            swaggerConfig = configClient.getSwaggerConfigMsDashBoard();
        } else if ("ms-produtos".equals(microserviceName)) {
            swaggerConfig = configClient.getSwaggerConfigMsProdutos();
        } else {
            throw new IllegalArgumentException("Microservice name not recognized: " + microserviceName);
        }
        return swaggerConfig;
    }

}