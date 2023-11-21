package com.excellence.spring_boot_library_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excellence.spring_boot_library_management_system.dto.Admin;
import com.excellence.spring_boot_library_management_system.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	AdminRepository adminRepository;
	
	/*
	 * this method will save or add the admin in db.
	 */
	
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	/*
	 * this method will fetch all the data from mainadmin table.
	 */
	
	public List<Admin> getAllAdmins(){
		return adminRepository.findAll();
	}
}

