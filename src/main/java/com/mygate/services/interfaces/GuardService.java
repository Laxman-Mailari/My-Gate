package com.mygate.services.interfaces;

import java.util.List;

import com.mygate.models.Guard;
import com.mygate.models.RequestForApproval;

public interface GuardService {

	Guard getByGuardId(String guardId);
	List<Guard> getAllGuards();
	
	void addGuard(Guard guard);
	Guard updateGuard(Guard guard);
	void deleteGuard(String guardId);
	
	void addApproval(RequestForApproval approval);
	void updateApproval(RequestForApproval approval);
	RequestForApproval getApprovalById(String requestId);
	List<RequestForApproval> getApprovalByHomeNumber(String homeNumber);
	List<RequestForApproval> getApprovalByGuardId(String guardId);
	List<RequestForApproval> getAllApproval();
	void deleteApprovalById(String requestId);
}


