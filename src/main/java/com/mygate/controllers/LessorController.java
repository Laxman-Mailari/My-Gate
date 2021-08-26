package com.mygate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mygate.models.Gatepass;
import com.mygate.models.Lessor;
import com.mygate.models.Person;
import com.mygate.services.interfaces.LessorService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/lessor")
public class LessorController {

	LessorService lessorService;
	@Autowired
	public LessorController(LessorService lessorService) {
		super();
		this.lessorService = lessorService;
	}
	
	@GetMapping
	public ResponseEntity<List<Lessor>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(lessorService.getAllLessor());
	}
	
	@GetMapping("/{homeNum}")
	public ResponseEntity<Lessor> getLessorById(@PathVariable("homeNum")String homeNum){
		return ResponseEntity.status(HttpStatus.OK).body(lessorService.getByHomeNumber(homeNum));
	}
	
	@GetMapping("/family/{homeNum}")
	public ResponseEntity<List<Person>> getFamilyMembers(@PathVariable("homeNum")String homeNum){
		return ResponseEntity.status(HttpStatus.OK).body(lessorService.getFamilyMembers(homeNum));
	}
	
	@PostMapping
	public ResponseEntity<String> addLessor(@RequestBody Lessor lessor){
		lessorService.addLessor(lessor);
		return ResponseEntity.status(HttpStatus.CREATED).body("created");
	}
	
	@PutMapping
	public ResponseEntity<String> updateLessor(@RequestBody Lessor lessor){
		lessorService.updateLessor(lessor);
		return ResponseEntity.status(HttpStatus.OK).body("updated");
	}
	
	@DeleteMapping("/{homeNum}")
	public void deleteLessor(@PathVariable("homeNum")String homeNum) {
		lessorService.deleteLessor(homeNum);
	}
	
	@PostMapping("/gatepass")
	public ResponseEntity<String> generateGatepass(@RequestBody Gatepass gatepass){
		lessorService.generateGatePass(gatepass);
		return ResponseEntity.status(HttpStatus.CREATED).body("Requested");
	}
	
	@GetMapping("/gatepass/{passNumber}")
	public ResponseEntity<Gatepass> getPassById(@RequestParam("passNumber")String passNumber){
		return ResponseEntity.status(HttpStatus.OK).body(lessorService.getPassById(passNumber));
	}
	
	@DeleteMapping("/gatepass/{passNumber}")
	public ResponseEntity<String> deletePassById(@RequestParam("passNumber")String passNumber){
		lessorService.deleteGatePass(passNumber);
		return ResponseEntity.status(HttpStatus.CREATED).body("deleted");
	}

	
}
