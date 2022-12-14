package com.produitsmicroservice.repository;

import com.produitsmicroservice.dao.ProduitDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends MongoRepository<ProduitDao, String> {
}
