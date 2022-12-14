package com.produitsmicroservice.service;

import com.produitsmicroservice.dao.ProduitDao;
import com.produitsmicroservice.repository.ProduitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }


    public List<ProduitDao> findAll() {
        return produitRepository.findAll();
    }


    public ProduitDao  save(ProduitDao entity) {
        return produitRepository.save(entity);
    }


    public ProduitDao findById(String id) {
        return produitRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public void deleteById(String id) {
        produitRepository.deleteById(id);
    }

    public List<ProduitDao> saveAll(Iterable<ProduitDao> entities) {
        return produitRepository.saveAll(entities);
    }

    public List<ProduitDao> findAllById(String[] ids) {
        return produitRepository.findAllById(List.of(ids));
    }
}
