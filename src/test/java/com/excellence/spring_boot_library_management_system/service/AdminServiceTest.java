package com.excellence.spring_boot_library_management_system.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.excellence.spring_boot_library_management_system.repository.AdminRepository;

@SpringBootTest
class AdminServiceTest {

	@Autowired
	private AdminService adminService;

	@MockBean
	private AdminRepository adminRepository;

	@Test
	public void testAdminSave() {

	}

}
