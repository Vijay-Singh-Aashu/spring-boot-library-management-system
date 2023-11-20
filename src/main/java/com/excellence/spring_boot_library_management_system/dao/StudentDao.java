package com.excellence.spring_boot_library_management_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excellence.spring_boot_library_management_system.dto.Student;
import com.excellence.spring_boot_library_management_system.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository repository;

	public void saveStudent(Student student) {

		repository.save(student);
	}

	public Student getStudentById(int studentId) {

		return repository.findById(studentId).get();
	}
}
