package com.example.agregproduitfacture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactureDtoIn {

    private String id;
    private List<String> listProduits;

}
