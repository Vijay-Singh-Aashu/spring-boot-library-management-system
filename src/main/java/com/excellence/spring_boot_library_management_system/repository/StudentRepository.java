package com.excellence.spring_boot_library_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excellence.spring_boot_library_management_system.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
