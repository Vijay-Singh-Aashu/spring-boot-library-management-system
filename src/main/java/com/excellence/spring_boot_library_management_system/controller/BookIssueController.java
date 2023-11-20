package com.excellence.spring_boot_library_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excellence.spring_boot_library_management_system.dto.BookIssue;
import com.excellence.spring_boot_library_management_system.dto.ResponseStructure;
import com.excellence.spring_boot_library_management_system.service.BookIssueService;
import com.excellence.spring_boot_library_management_system.service.BookService;

@RestController
public class BookIssueController {

	@Autowired
	private BookIssueService bookIssueService;

	@Autowired
	private BookService bookService;

	/*
	 * update book to set student inside book
	 */

	@PostMapping(value = "/bookIssue/{studentId}/{BookId}")
	public ResponseStructure<BookIssue> updateBookWithStudentId(@PathVariable int studentId, @PathVariable int BookId) {
		return bookIssueService.updateBookWithStudentId(studentId, BookId);

	}

	/*
	 * submitbook that student has taken before
	 */

	@DeleteMapping(value = "/submitBook/{bookId}/{studentId}")
	public ResponseStructure<BookIssue> submitIssuedBook(@PathVariable int bookId, @PathVariable int studentId) {
		return bookIssueService.submitIssuedBook(bookId, studentId);
	}

	/*
	 * check the fine for late submission
	 */

	@PutMapping(value = "/checkFine/{bookId}/{studentId}")
	public ResponseStructure<BookIssue> checkFineForLateSubmission(@PathVariable int bookId,
			@PathVariable int studentId) {
		return bookIssueService.checkFineForLateSubmission(bookId, studentId);
	}
}
