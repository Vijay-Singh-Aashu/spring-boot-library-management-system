package com.excellence.spring_boot_library_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excellence.spring_boot_library_management_system.dto.BookIssue;

public interface BookIssueRepository extends JpaRepository<BookIssue, Integer> {

}
