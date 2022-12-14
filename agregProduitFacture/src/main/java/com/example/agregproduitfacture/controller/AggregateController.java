package com.example.agregproduitfacture.controller;

import com.example.agregproduitfacture.dto.FactureDtoIn;
import com.example.agregproduitfacture.dto.ProduitDtoIn;
import com.example.agregproduitfacture.dto.ProduitFactureAggregate;
import com.example.agregproduitfacture.service.AggregateService;
import com.example.agregproduitfacture.service.FactureService;
import com.example.agregproduitfacture.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("agregate")
public class AggregateController {

    @Autowired
    private AggregateService service;

    @GetMapping("factures/produits")
    public Mono<List<ProduitFactureAggregate>> getFacturesWitProduits() {
        return service.getFacturesWitProduits();
    }

    @GetMapping("factures/{id}/produits")
    public Mono<ProduitFactureAggregate> getFacturewithProduits(@PathVariable String id) {
        return null;
    }


    //    @Autowired
//    private ProduitService produit;
//    @Autowired
//    private FactureService facture;
//
//    @GetMapping("produits")
//
//    public Mono<List<ProduitDtoIn>> getAllProduits() {
//        return produit.getAllProduits();
//    }
//
//    @GetMapping("factures")
//    public Mono<List<FactureDtoIn>> getAllFactures() {
//        return facture.getAllFactures();
//    }
}

