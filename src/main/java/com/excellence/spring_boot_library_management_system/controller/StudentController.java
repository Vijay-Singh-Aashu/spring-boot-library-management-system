package com.excellence.spring_boot_library_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excellence.spring_boot_library_management_system.dto.ResponseStructure;
import com.excellence.spring_boot_library_management_system.dto.Student;
import com.excellence.spring_boot_library_management_system.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	/*
	 * SaveMethod For Student You Can Save The Data once You will login with the
	 * librarian
	 */
	@PostMapping("/saveStudent")
	public ResponseStructure<Student> saveStudent(@RequestBody Student student) {

		return studentService.saveStudent(student);
	}
}
