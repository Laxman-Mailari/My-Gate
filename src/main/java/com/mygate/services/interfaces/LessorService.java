package com.mygate.services.interfaces;

import java.util.List;

import com.mygate.exceptions.LessorNotFoundException;
import com.mygate.models.Gatepass;
import com.mygate.models.Lessor;
import com.mygate.models.Person;

public interface LessorService {

	Lessor getByHomeNumber(String homeNumber) throws LessorNotFoundException;
	List<Lessor> getAllLessor() throws LessorNotFoundException;
	List<Person> getFamilyMembers(String homeNumber) throws LessorNotFoundException;
	
	void addLessor(Lessor lessor);
	Lessor updateLessor(Lessor lessor);
	void deleteLessor(String homeNumber);
	
	void generateGatePass(Gatepass gatepass);
	Gatepass getPassById(String passId);
	void deleteGatePass(String passId);
}
