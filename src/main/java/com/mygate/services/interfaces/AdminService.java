package com.mygate.services.interfaces;

import java.util.List;

import com.mygate.models.Admin;

public interface AdminService {

	Admin getByUsername(String username);
	List<Admin> getAllAdmin();
	
	void addAdmin(Admin admin);
	Admin updateAdmin(Admin admin);
	void deleteAdmin(String username);
}
