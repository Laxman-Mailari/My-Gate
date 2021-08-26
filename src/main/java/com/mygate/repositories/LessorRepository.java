package com.mygate.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mygate.models.Lessor;
import com.mygate.models.Person;

@Repository
public interface LessorRepository extends MongoRepository<Lessor, String>{

}
