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
import org.springframework.web.bind.annotation.RestController;

import com.mygate.models.Guard;
import com.mygate.models.RequestForApproval;
import com.mygate.services.interfaces.GuardService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/guard")
public class GuardController {

	GuardService guardService;
	@Autowired
	public GuardController(GuardService guardService) {
		super();
		this.guardService = guardService;
	}
	
	@GetMapping
	public ResponseEntity<List<Guard>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(guardService.getAllGuards());
	}

	@GetMapping("/{guardId}")
	public ResponseEntity<Guard> getGuardById(@PathVariable("guardId")String guardId){
		return ResponseEntity.status(HttpStatus.OK).body(guardService.getByGuardId(guardId));
	}
	
	@PostMapping
	public ResponseEntity<String> addGuard(@RequestBody Guard guard){
		guardService.addGuard(guard);
		return ResponseEntity.status(HttpStatus.CREATED).body("created");
	}
	
	@PutMapping
	public ResponseEntity<String> updateGuard(@RequestBody Guard guard){
		guardService.updateGuard(guard);
		return ResponseEntity.status(HttpStatus.OK).body("updated");
	}
	
	@DeleteMapping("/{guardId}")
	public ResponseEntity<String> deleteGuard(@PathVariable("guardId")String guardId) {
		guardService.deleteGuard(guardId);
		return ResponseEntity.status(HttpStatus.OK).body("deleted");
	}
	
	@PostMapping("/requestForApproval")
	public ResponseEntity<String> addApproval(@RequestBody RequestForApproval approval){
		guardService.addApproval(approval);
		return ResponseEntity.status(HttpStatus.CREATED).body("requested");
	}
	
	@PutMapping("/requestForApproval")
	public ResponseEntity<String> updateApproval(@RequestBody RequestForApproval approval){
		guardService.updateApproval(approval);
		return ResponseEntity.status(HttpStatus.OK).body("requested updated");
		
	}
	
	@GetMapping("/requestForApproval/{requestId}")
	public ResponseEntity<RequestForApproval> getApprovalById(@PathVariable("requestId")String requestId){
		return ResponseEntity.status(HttpStatus.OK).body(guardService.getApprovalById(requestId));
	}
	
	@GetMapping("/requestForApproval/{homeNumber}")
	public ResponseEntity<List<RequestForApproval>> getApprovalByHomeNumber(@PathVariable("homeNumber")String homeNumber){
		return ResponseEntity.status(HttpStatus.OK).body(guardService.getApprovalByHomeNumber(homeNumber));
	}
	
	
	@GetMapping("/requestForApproval/{guardId}")
	public ResponseEntity<List<RequestForApproval>> getApprovalByGuardId(@PathVariable("guardId")String guardId){
		return ResponseEntity.status(HttpStatus.OK).body(guardService.getApprovalByGuardId(guardId));
	}
	
	@GetMapping("/requestForApproval")
	public ResponseEntity<List<RequestForApproval>> getAllApproval(){
		return ResponseEntity.status(HttpStatus.OK).body(guardService.getAllApproval());
	}
	
	@DeleteMapping("/requestForApproval/{requestId}")
	public ResponseEntity<String> deleteApprovalById(@PathVariable("requestId")String requestId) {
		guardService.deleteApprovalById(requestId);
		return ResponseEntity.status(HttpStatus.OK).body("deleted");
	}
}
