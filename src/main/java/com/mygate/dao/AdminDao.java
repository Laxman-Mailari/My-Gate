package com.mygate.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mygate.models.Admin;
import com.mygate.repositories.AdminRepository;

@Component
public class AdminDao {

	@Autowired
	AdminRepository adminRepository;
	
	public Optional<Admin> getByUsername(String username) {
		return adminRepository.findById(username);
	}

	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	public void addAdmin(Admin admin) {
		adminRepository.insert(admin);
	}

	public void updateAdmin(Admin admin) {
		adminRepository.save(admin);
	}

	public void deleteAdmin(String username) {
		adminRepository.deleteById(username);
	}
}
