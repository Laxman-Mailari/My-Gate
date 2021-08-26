package com.mygate.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mygate.models.Gatepass;
import com.mygate.repositories.GatepassRepository;

@Component
public class GatepassDao {

	@Autowired
	GatepassRepository gatepassRepository;
	
	public void addGatepass(Gatepass gatepass) {
		gatepassRepository.insert(gatepass);
	}
	
	public Optional<Gatepass> getPassById(String passId) {
		return gatepassRepository.findById(passId);
	}
	
	public List<Gatepass> getAllPass(){
		return gatepassRepository.findAll();
	}
	
	public void updateGatepass(Gatepass gatepass) {
		gatepassRepository.save(gatepass);
	}
	
	public void deleteGatepass(String passId) {
		gatepassRepository.deleteById(passId);
	}
}
