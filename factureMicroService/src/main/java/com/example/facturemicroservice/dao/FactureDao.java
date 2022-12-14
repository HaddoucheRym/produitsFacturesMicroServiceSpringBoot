package com.example.facturemicroservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class FactureDao {

    @Id
    private String id;
//    @DBRef
    private List<String> listProduits;

//    public Double getMontant() {
//        Double montant = 0.0;
//        for ( ProduitDao item: this.listProduits) {
//            montant += item.getPrix();
//        }
//        return montant;
//    }
}
