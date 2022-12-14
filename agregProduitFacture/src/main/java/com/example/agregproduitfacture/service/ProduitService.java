package com.example.agregproduitfacture.service;

import com.example.agregproduitfacture.dto.ProduitDtoIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProduitService {

    private WebClient client;

    @Autowired
    ProduitService(@Qualifier("webClientProduit") WebClient webC) {
        client = webC;
    }


    public Mono<List<ProduitDtoIn>> getAllProduits() {
        return client
                .get()
                .retrieve()
                .bodyToFlux(ProduitDtoIn.class)
                .collectList();
    }

    public Mono<List<ProduitDtoIn>> getListProduitsByIds(List<String> ids) {
//        String value = "";
//        for (int i = 0 ; i < ids.size(); i++) {
//            value += ids.get(i);
//            if(ids.size() - 1 > i) value += ",";
//        }
        //<=>
        String value = String.join(",", ids);

         return this.client.get()
                 .uri("/ids?ids=" + value)
                 .retrieve()
                 .bodyToFlux(ProduitDtoIn.class)
                 .collectList();

    }
}
