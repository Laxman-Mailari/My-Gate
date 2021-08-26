package com.mygate.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mygate.models.RequestForApproval;
import com.mygate.repositories.RequestForApprovalRepo;

@Component
public class RequestForApprovalDao {

	@Autowired
	RequestForApprovalRepo approvalRepo;
	
	public void addApproval(RequestForApproval approval) {
		approvalRepo.insert(approval);
	}
	
	public void updateApproval(RequestForApproval approval) {
		approvalRepo.save(approval);
	}
	
	public Optional<RequestForApproval> getApprovalById(String requestId){
		return approvalRepo.findById(requestId);
	}
	
	public List<RequestForApproval> getApprovalByHomeNumber(String homeNumber){
		return approvalRepo.findByHomeNumber(homeNumber);
	}
	
	public List<RequestForApproval> getApprovalByGuardId(String guardId){
		return approvalRepo.findByGuardId(guardId);
	}
	
	public List<RequestForApproval> getAllApproval(){
		return approvalRepo.findAll();
	}
	
	public void deleteApproval(String requestId) {
		approvalRepo.deleteById(requestId);
	}
	
}
