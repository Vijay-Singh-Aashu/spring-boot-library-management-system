package com.excellence.spring_boot_library_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.excellence.spring_boot_library_management_system.dao.StudentDao;
import com.excellence.spring_boot_library_management_system.dto.ResponseStructure;
import com.excellence.spring_boot_library_management_system.dto.Student;

import jakarta.servlet.http.HttpSession;

@Service
public class StudentService {

	@Autowired
	HttpSession httpSession;

	@Autowired
	StudentDao studentDao;

	@Autowired
	ResponseStructure<Student> responseStructure;

	/*
	 * saveMethod For Student
	 */
	public ResponseStructure<Student> saveStudent(Student student) {

		if (httpSession.getAttribute("librarianEmail") != null) {

			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data-Inserted.....");
			responseStructure.setData(student);
			studentDao.saveStudent(student);
			return responseStructure;

		} else {

			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Please-Login-With-Librarian-And-Then-Add");
			responseStructure.setData(student);

			return responseStructure;
		}

	}

	/*
	 * getStudentById method
	 */
	public ResponseStructure<Student> getStudentById(int studentId) {

		if (httpSession.getAttribute("librarianEmail") != null) {

			Student student=studentDao.getStudentById(studentId);
			
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data-Present....");
			responseStructure.setData(student);
			return responseStructure;

		} else {

			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Please-Login-With-Librarian");
			responseStructure.setData(null);
			return responseStructure;
		}
	}
}
