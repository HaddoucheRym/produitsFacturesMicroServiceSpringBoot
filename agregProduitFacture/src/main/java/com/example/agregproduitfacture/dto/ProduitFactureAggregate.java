package com.example.agregproduitfacture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitFactureAggregate {
//    private String factureId;
    private FactureDtoOut facture;
    private List<ProduitDtoIn> produits;

    public Double getMontant() {
        double montant = 0d;
        for (ProduitDtoIn item: this.produits) {
            montant += item.getPrix();
        }
        return montant;
    }

}
