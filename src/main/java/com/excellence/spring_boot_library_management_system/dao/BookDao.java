package com.excellence.spring_boot_library_management_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excellence.spring_boot_library_management_system.dto.Book;
import com.excellence.spring_boot_library_management_system.dto.BookIssue;
import com.excellence.spring_boot_library_management_system.dto.Student;
import com.excellence.spring_boot_library_management_system.repository.BookIssueRepository;
import com.excellence.spring_boot_library_management_system.repository.BookRepository;

@Repository
public class BookDao {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookIssueRepository bookIssueRepository;
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	BookIssue bookIssue;
	
	public void saveBook(Book book) {
		
		bookRepository.save(book);
	}
	
	/*
	 * getBookById method
	 */
	public Book getBookById(int bookId) {
		
		return bookRepository.findById(bookId).get();
		
	}
	
	/*
	 * update book to set student inside book
	 */
	public Book updateBookWithStudentId(int studentId,int BookId) {
		
		Book book=getBookById(BookId);
		
		Student student = studentDao.getStudentById(studentId);
		
		if((student!=null)&&(book!=null)) {
			
			book.setStudent(student);
			
			bookRepository.save(book);
			
			return book;
			
		}else {
			return null;
		}
	}
}
