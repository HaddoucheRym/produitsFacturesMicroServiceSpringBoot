package com.produitsmicroservice.controller;

import com.produitsmicroservice.dao.ProduitDao;
import com.produitsmicroservice.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
@CrossOrigin
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("")
    public List<ProduitDao> findAll(){
        return this.produitService.findAll();
    }

    @PostMapping("")
    public ProduitDao save(@RequestBody ProduitDao produit) {
        return this.produitService.save(produit);
    }

    @GetMapping("{id}")
    public ProduitDao findById(@PathVariable String id) {
        return this.produitService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        this.produitService.deleteById(id);
    }

    @PostMapping("all")
    public List<ProduitDao> saveAll(@RequestBody Iterable<ProduitDao> entities) {
        return produitService.saveAll(entities);
    }

    @GetMapping("ids")
    public List<ProduitDao> findAllById(@RequestParam String ids) {
        String[] arr = null;
        arr = ids.split(",");
        return produitService.findAllById(arr);
    }
}
