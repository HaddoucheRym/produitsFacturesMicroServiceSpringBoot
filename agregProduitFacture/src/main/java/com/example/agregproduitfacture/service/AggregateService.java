package com.example.agregproduitfacture.service;

import com.example.agregproduitfacture.dto.FactureDtoIn;
import com.example.agregproduitfacture.dto.FactureDtoOut;
import com.example.agregproduitfacture.dto.ProduitDtoIn;
import com.example.agregproduitfacture.dto.ProduitFactureAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class AggregateService {

    @Autowired
    private ProduitService produitService;

    @Autowired
    private FactureService factureService;

    public Mono<List<ProduitFactureAggregate>> getFacturesWitProduits() {
        //importer les methodes de service
        Mono<List<ProduitDtoIn>> mesProduits = produitService.getAllProduits();
        Mono<List<FactureDtoIn>> mesFactures = factureService.getAllFactures();
        return Mono.zip(mesProduits, mesFactures).map(tuple -> this.fusion(tuple.getT2(),
                tuple.getT1()));
    }

    public List<ProduitFactureAggregate> fusion(List<FactureDtoIn> factures,
                                                List<ProduitDtoIn> produits) {

        List<ProduitFactureAggregate> results = new ArrayList<>();
        for (FactureDtoIn facture: factures) {
            List<ProduitDtoIn> items = new ArrayList<>();
            for (ProduitDtoIn produit: produits) {
                if (facture.getListProduits().contains(produit.getId()));
                items.add(produit);
            }
//            results.add(new ProduitFactureAggregate(facture.getId(), items));
            results.add(new ProduitFactureAggregate(new FactureDtoOut(facture.getId()), items));
        }

        return results;
    }

    public Mono<ProduitFactureAggregate> getFactureById(String id) {
        Mono<FactureDtoIn> facture = this.factureService.getFactureById(id);
        Mono<List<ProduitDtoIn>> produits = facture.flatMap(item -> {
           return this.produitService.getListProduitsByIds(item.getListProduits());

        });
        return facture.zipWith(produits).map(t -> new ProduitFactureAggregate(
                new FactureDtoOut(t.getT1().getId()), t.getT2()));
    }
}
