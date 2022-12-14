package com.example.agregproduitfacture.service;

import com.example.agregproduitfacture.dto.FactureDtoIn;
import com.example.agregproduitfacture.dto.FactureDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FactureService {
    private WebClient client;


    public FactureService(@Qualifier("webClientFacture") WebClient webc) {
        client = webc;
    }
    public Mono<List<FactureDtoIn>> getAllFactures() {
        return client
                .get()
                .retrieve()
                .bodyToFlux(FactureDtoIn.class)
                .collectList();
    }

    public Mono<FactureDtoIn> getFactureById(String id) {
        return this.client.get().uri("/" + id)
                .retrieve()
                .bodyToMono(FactureDtoIn.class);
    }
}
