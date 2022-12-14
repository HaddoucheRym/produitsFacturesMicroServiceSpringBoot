package com.example.facturemicroservice.service;

import com.example.facturemicroservice.dao.FactureDao;
import com.example.facturemicroservice.repository.FactureRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FactureService {
    private final FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }


    public List<FactureDao> findAll() {
        return factureRepository.findAll();
    }


    public FactureDao save(FactureDao entity) {
        return factureRepository.save(entity);
    }


    public FactureDao findById(String id) {
        return factureRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public void deleteById(String id) {
        factureRepository.deleteById(id);
    }

    public  List<FactureDao> saveAll(Iterable<FactureDao> entities) {
        return factureRepository.saveAll(entities);
    }
}
