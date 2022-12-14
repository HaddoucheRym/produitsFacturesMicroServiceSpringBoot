package com.example.facturemicroservice.controller;

import com.example.facturemicroservice.dao.FactureDao;
import com.example.facturemicroservice.service.FactureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factures")
@CrossOrigin
public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @GetMapping("")
    public List<FactureDao> findAll(){
        return this.factureService.findAll();
    }

    @PostMapping("")
    public FactureDao save(@RequestBody FactureDao facture) {
        return this.factureService.save(facture);
    }

    @GetMapping("{id}")
    public FactureDao findById(@PathVariable String id) {
        return this.factureService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        this.factureService.deleteById(id);
    }

    @PostMapping("all")
    public List<FactureDao> saveAll(@RequestBody Iterable<FactureDao> entities) {
        return factureService.saveAll(entities);
    }
}
