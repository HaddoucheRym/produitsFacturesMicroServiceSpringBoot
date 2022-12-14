package com.example.facturemicroservice.repository;

import com.example.facturemicroservice.dao.FactureDao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FactureRepository extends MongoRepository<FactureDao, String> {
}
