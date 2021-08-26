package com.mygate.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygate.dao.AdminDao;
import com.mygate.exceptions.AdminNotFoundException;
import com.mygate.models.Admin;
import com.mygate.services.interfaces.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDao adminDao;

	@Override
	public Admin getByUsername(String username) {
		Optional<Admin> admin = adminDao.getByUsername(username);
		if(admin.isEmpty()) {
			throw new AdminNotFoundException("[getByUserName] : admin not found");
		}
		return admin.get();
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> admins = adminDao.getAllAdmin();
		if(admins.isEmpty()) {
			throw new AdminNotFoundException("[getAllAdmin] : admins not found");
		}
		return admins;
	}

	@Override
	public void addAdmin(Admin admin) {
		if(isAdminExist(admin.getUsername())) {
			throw new AdminNotFoundException("[addAdmin] : admin exist with this id");
		}
		adminDao.addAdmin(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		if(!isAdminExist(admin.getUsername())) {
			throw new AdminNotFoundException("[updateAdmin] : admin not found with this id");
		}
		adminDao.updateAdmin(admin);
		return admin;
	}

	@Override
	public void deleteAdmin(String username) {
		if(!isAdminExist(username)) {
			throw new AdminNotFoundException("[deleteAdmin] : admin not found with this id");
		}
		adminDao.deleteAdmin(username);
	}
	
	public boolean isAdminExist(String username) {
		Optional<Admin> admin = adminDao.getByUsername(username);
		if(admin.isEmpty()) {
			return false;
		}
		return true;
	}

}
