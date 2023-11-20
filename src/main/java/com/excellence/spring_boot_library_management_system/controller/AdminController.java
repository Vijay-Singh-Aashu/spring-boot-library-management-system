package com.excellence.spring_boot_library_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excellence.spring_boot_library_management_system.dto.Admin;
import com.excellence.spring_boot_library_management_system.dto.ResponseStructure;
import com.excellence.spring_boot_library_management_system.service.AdminService;

import jakarta.servlet.http.HttpSession;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	HttpSession httpSession;

	@PostMapping(value = "/saveAdmin")
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@GetMapping(value = "/loginAdmin/{adminName}/{adminEmail}")
	public String loginAdmin(@PathVariable String adminName, @PathVariable String adminEmail) {

		List<Admin> admins = adminService.getAllAdmins();

		for (Admin admin : admins) {

			if ((admin.getAdminName().equalsIgnoreCase(adminName))
					&& (admin.getAdminEmail().equalsIgnoreCase(adminEmail))) {

				httpSession.setAttribute("adminEmail", adminName);

				return "admin logged in successfully";

			} else {
				return "Please Check Your UserName and Password";
			}
		}
		return null;
	}

	@GetMapping(value = "/logoutAdmin")
	public String logoutAdmin() {

		if (httpSession.getAttribute("adminEmail") != null) {

			httpSession.invalidate();

			return "admin logout successfully";
		} else {
			return "please login again then logout";
		}
	}

}
