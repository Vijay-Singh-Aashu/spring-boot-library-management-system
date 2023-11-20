package com.excellence.spring_boot_library_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excellence.spring_boot_library_management_system.dto.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

}

