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

import com.mygate.models.Admin;
import com.mygate.services.interfaces.AdminService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {

	AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@GetMapping
	public ResponseEntity<List<Admin>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(adminService.getAllAdmin());
	}

	@GetMapping("/{username}")
	public ResponseEntity<Admin> getByUsername(@PathVariable("username")String username){
		return ResponseEntity.status(HttpStatus.OK).body(adminService.getByUsername(username));
	}
	
	@PostMapping
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin){
		adminService.addAdmin(admin);
		return ResponseEntity.status(HttpStatus.CREATED).body("created");
	}
	
	@PutMapping
	public ResponseEntity<String> updateGuard(@RequestBody Admin admin){
		adminService.updateAdmin(admin);
		return ResponseEntity.status(HttpStatus.OK).body("updated");
	}
	
	@DeleteMapping("/{username}")
	public void deleteGuard(@PathVariable("username")String username) {
		adminService.deleteAdmin(username);
	}
}
