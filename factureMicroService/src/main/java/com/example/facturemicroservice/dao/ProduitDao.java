package com.example.facturemicroservice.dao;

import lombok.Data;

@Data
public class ProduitDao {
    private String id;
    private String nom;
    private String description;
    private double prix;
}
