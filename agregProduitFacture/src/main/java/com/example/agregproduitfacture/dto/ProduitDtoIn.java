package com.example.agregproduitfacture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDtoIn {

    private String id;
    private String nom;
    private String description;
    private double prix;
}
