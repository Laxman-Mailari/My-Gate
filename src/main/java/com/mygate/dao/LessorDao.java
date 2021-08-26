package com.mygate.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mygate.models.Lessor;
import com.mygate.models.Person;
import com.mygate.repositories.LessorRepository;

@Component
public class LessorDao {
	
	@Autowired
	LessorRepository lessorRepository;

	public Optional<Lessor> getByHomeNumber(String homeNumber) {
		return lessorRepository.findById(homeNumber);
	}

	public List<Lessor> getAllLessor() {
		return lessorRepository.findAll();
	}

//	public List<Person> getFamilyMembers(String homeNumber) {
//		return lessorRepository.getFamilyMembers(homeNumber);
//	}

	public void addLessor(Lessor lessor) {
		lessorRepository.insert(lessor);
	}

	public void updateLessor(Lessor lessor) {
		lessorRepository.save(lessor);
	}

	public void deleteLessor(String homeNumber) {
		lessorRepository.deleteById(homeNumber);
	}
	
}
