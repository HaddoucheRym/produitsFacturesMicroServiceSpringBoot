package com.example.agregproduitfacture.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConf {

    @Value("${environnement.domaineProduit}")
    private String produitUrl;
    @Value("${environnement.domaineFacture}")
    private String facturetUrl;

    @Bean
    public WebClient webClientProduit() {
        return WebClient.builder().
                defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl(produitUrl).build();
    }

    @Bean
    public WebClient webClientFacture() {
        return WebClient.builder().
                defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl(facturetUrl).build();
    }
}
