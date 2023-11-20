package com.excellence.spring_boot_library_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excellence.spring_boot_library_management_system.dto.Book;
import com.excellence.spring_boot_library_management_system.dto.ResponseStructure;
import com.excellence.spring_boot_library_management_system.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping("/saveBook")
	public ResponseStructure<Book> saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
}
