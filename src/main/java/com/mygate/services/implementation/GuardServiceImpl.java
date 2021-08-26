package com.mygate.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygate.dao.GuardDao;
import com.mygate.dao.RequestForApprovalDao;
import com.mygate.exceptions.GuardNotFoundException;
import com.mygate.exceptions.RequestForApprovalNotFound;
import com.mygate.models.Guard;
import com.mygate.models.RequestForApproval;
import com.mygate.services.interfaces.GuardService;

@Service
public class GuardServiceImpl implements GuardService{

	@Autowired
	GuardDao guardDao;
	
	@Autowired
	RequestForApprovalDao approvalDao;
	
	@Override
	public Guard getByGuardId(String guardId) {
		Optional<Guard> guard = guardDao.getByGuardId(guardId);
		if(guard.isEmpty()) {
			throw new GuardNotFoundException("[getByGuardID]: Guard not found");
		}
		return guard.get();
	}

	@Override
	public List<Guard> getAllGuards() {
		List<Guard> guards = guardDao.getAllGuards();
		if(guards.isEmpty()) {
			throw new GuardNotFoundException("[getAllGuards]: Guards not found");
		}
		return guards;
	}

	@Override
	public void addGuard(Guard guard) {
		if(isGuardExist(guard.getGuardId())) {
			throw new GuardNotFoundException("[addGuard]: Guard is exist with this id");
		}
		guardDao.addGuard(guard);
		
	}

	@Override
	public Guard updateGuard(Guard guard) {
		if(!isGuardExist(guard.getGuardId())) {
			throw new GuardNotFoundException("[updateGuard]: Guard not Found");
		}
		guardDao.updateGuard(guard);
		return guard;
	}

	@Override
	public void deleteGuard(String guardId) {
		if(!isGuardExist(guardId)) {
			throw new GuardNotFoundException("[deleteGuard]: Guard not Found");
		}
		guardDao.deleteGuard(guardId);
	}
	
	public boolean isGuardExist(String guardId) {
		Optional<Guard> guard = guardDao.getByGuardId(guardId);
		if(guard.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void addApproval(RequestForApproval approval) {
		approvalDao.addApproval(approval);
	}

	@Override
	public void updateApproval(RequestForApproval approval) {
		approvalDao.updateApproval(approval);
	}

	@Override
	public RequestForApproval getApprovalById(String requestId) {
		Optional<RequestForApproval> approval = approvalDao.getApprovalById(requestId);
		if(approval.isEmpty()) {
			throw new RequestForApprovalNotFound("Approval not found");
		}
		return approval.get();
	}

	@Override
	public List<RequestForApproval> getApprovalByHomeNumber(String homeNumber) {
		return approvalDao.getApprovalByHomeNumber(homeNumber);
	}

	@Override
	public List<RequestForApproval> getApprovalByGuardId(String guardId) {
		return approvalDao.getApprovalByGuardId(guardId);
	}

	@Override
	public List<RequestForApproval> getAllApproval() {
		return approvalDao.getAllApproval();
	}

	@Override
	public void deleteApprovalById(String requestId) {
		approvalDao.deleteApproval(requestId);
	}

}
