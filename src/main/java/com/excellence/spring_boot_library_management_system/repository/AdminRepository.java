package com.excellence.spring_boot_library_management_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.excellence.spring_boot_library_management_system.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query(value = "SELECT * FROM mainadmin WHERE adminemail=?1 AND adminname=?2", nativeQuery = true)
	Admin getByNameEmail(String adminEmail, String adminName);

	Optional<Admin> findByAdminEmail(String adminEmail);
}
