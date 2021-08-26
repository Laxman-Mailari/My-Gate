package com.mygate.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mygate.models.Guard;
import com.mygate.repositories.GuardRepository;

@Component
public class GuardDao {

	@Autowired
	GuardRepository guardRepository;
	
	public Optional<Guard> getByGuardId(String guardId) {
		return guardRepository.findById(guardId);
	}

	public List<Guard> getAllGuards() {
		return guardRepository.findAll();
	}

	public void addGuard(Guard guard) {
		guardRepository.insert(guard);
	}

	public void updateGuard(Guard guard) {
		guardRepository.save(guard);
	}

	public void deleteGuard(String guardId) {
		guardRepository.deleteById(guardId);
	}
}
