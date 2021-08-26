package com.mygate.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygate.dao.GatepassDao;
import com.mygate.dao.LessorDao;
import com.mygate.exceptions.GatepassNotFoundException;
import com.mygate.exceptions.LessorNotFoundException;
import com.mygate.models.Gatepass;
import com.mygate.models.Lessor;
import com.mygate.models.Person;
import com.mygate.services.interfaces.LessorService;

@Service
public class LessorServiceImpl implements LessorService{

	@Autowired
	LessorDao lessorDao;
	
	@Autowired
	GatepassDao gatepassDao;
	
	@Override
	public Lessor getByHomeNumber(String homeNumber) throws LessorNotFoundException {
		Optional<Lessor> lessor =  lessorDao.getByHomeNumber(homeNumber);
		if(lessor.isEmpty())
			throw new LessorNotFoundException("Lessor with "+homeNumber+" not Found");
		return lessor.get();
	}

	@Override
	public List<Lessor> getAllLessor() throws LessorNotFoundException {
		List<Lessor> allLessors =  lessorDao.getAllLessor();
		if(allLessors.isEmpty()) {
			throw new LessorNotFoundException("No Lessor found");
		}
		return allLessors;
	}

	@Override
	public List<Person> getFamilyMembers(String homeNumber) {
		if(isLessorExist(homeNumber)) {
//			List<Person> members = lessorDao.getFamilyMembers(homeNumber);
//			if(members.isEmpty()) {
//				throw new LessorNotFoundException("Members not found in the lessor home");
//			}
//			return members;
			Optional<Lessor> lessor =  lessorDao.getByHomeNumber(homeNumber);
			return lessor.get().getFamilyMembers();
		}
		throw new LessorNotFoundException("Lessor Not Found");
	}

	@Override
	public void addLessor(Lessor lessor) {
		if(isLessorExist(lessor.getHomeNumber())) {
			throw new LessorNotFoundException("Lessor is occupied the home.can't add one more lessor");
		}
		lessorDao.addLessor(lessor);
		
	}

	@Override
	public Lessor updateLessor(Lessor lessor) {
		if(!isLessorExist(lessor.getHomeNumber())) {
			throw new LessorNotFoundException("No Lessor is occupied this home.can't update");
		}
		lessorDao.updateLessor(lessor);
		return lessor;
	}

	@Override
	public void deleteLessor(String homeNumber) {
		if(!isLessorExist(homeNumber)) {
			throw new LessorNotFoundException("Lessor not found");
		}
		lessorDao.deleteLessor(homeNumber);
		
	}
	
	public boolean isLessorExist(String homeNum) {
		Optional<Lessor> lessor =  lessorDao.getByHomeNumber(homeNum);
		if(lessor.isEmpty()) {
			return false;
		}
		return true;
	}
	
	@Override
	public void generateGatePass(Gatepass gatepass) {
		gatepassDao.addGatepass(gatepass);
	}
	
	@Override
	public Gatepass getPassById(String passId) {
		Optional<Gatepass> pass = gatepassDao.getPassById(passId);
		if(pass.isPresent()) {
			return pass.get();
		}
		throw new GatepassNotFoundException("Gatepass not found");
	}
	
	@Override
	public void deleteGatePass(String passId) {
		if(!isGatepassExist(passId)) {
			throw new GatepassNotFoundException("Gatepass not found");
		}
		gatepassDao.deleteGatepass(passId);
	}
	
	public boolean isGatepassExist(String passId) {
		Optional<Gatepass> pass = gatepassDao.getPassById(passId);
		if(pass.isEmpty()) {
			return false;
		}
		return true;
	}

}
