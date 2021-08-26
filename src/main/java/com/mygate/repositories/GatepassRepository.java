package com.mygate.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mygate.models.Gatepass;

@Repository
public interface GatepassRepository extends MongoRepository<Gatepass, String> {

}
