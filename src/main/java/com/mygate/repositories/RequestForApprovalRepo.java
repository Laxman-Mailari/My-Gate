package com.mygate.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mygate.models.RequestForApproval;

@Repository
public interface RequestForApprovalRepo extends MongoRepository<RequestForApproval, String> {

	List<RequestForApproval> findByHomeNumber(String homeNumber);
	List<RequestForApproval> findByGuardId(String guardId);
	
}
