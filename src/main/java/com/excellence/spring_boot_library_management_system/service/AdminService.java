package com.excellence.spring_boot_library_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.excellence.spring_boot_library_management_system.dao.AdminDao;
import com.excellence.spring_boot_library_management_system.dto.Admin;
import com.excellence.spring_boot_library_management_system.dto.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;

	@Autowired
	ResponseStructure<Admin> adminSave;

	public ResponseStructure<Admin> saveAdmin(Admin admin) {

		if (admin != null) {
			adminSave.setStatusCode(HttpStatus.CREATED.value());
			adminSave.setMsg("Data-inserted-successfully");
			adminSave.setData(admin);
			adminDao.saveAdmin(admin);
			return adminSave;
		} else {
			adminSave.setStatusCode(HttpStatus.NO_CONTENT.value());
			adminSave.setMsg("please check your data...");
			adminSave.setData(admin);
			return adminSave;
		}

	}

	/*
	 * thids method will fetch all the data from mainadmin table
	 */
	public List<Admin> getAllAdmins() {

		return adminDao.getAllAdmins();
	}

}
