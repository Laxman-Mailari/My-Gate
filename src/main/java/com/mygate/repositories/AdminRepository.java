package com.mygate.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mygate.models.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String>{

	//derived query
	//custom query
}
