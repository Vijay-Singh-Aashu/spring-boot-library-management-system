package com.excellence.spring_boot_library_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.excellence.spring_boot_library_management_system.dto.Librarian;
import com.excellence.spring_boot_library_management_system.repository.LibrarianRepository;

@Repository
public class LibrariranDao {

	@Autowired
	LibrarianRepository librarianRepository;

	/*
	 * save method to save librarian data
	 */
	public Librarian saveLibrarian(Librarian librarian) {

		return librarianRepository.save(librarian);
	}

	/*
	 * update method to update any data of librarian
	 */
	public Librarian updateLibrarian(Librarian librarian, int librarianId) {

		Optional<Librarian> optional = librarianRepository.findById(librarianId);

		if (optional.isPresent()) {

			Librarian librarian2 = optional.get();

			if ((librarian.getLibrarianName() != null) && (librarian.getLibrarianEmail() != null)) {

				librarian2.setLibrarianName(librarian.getLibrarianName());

				librarian2.setLibrarianEmail(librarian.getLibrarianEmail());

				librarianRepository.save(librarian2);

				return librarian2;
			} else if (librarian.getLibrarianName() != null) {
				librarian2.setLibrarianName(librarian.getLibrarianName());
				librarianRepository.save(librarian2);
				return librarian2;
			} else {

				librarian2.setLibrarianEmail(librarian.getLibrarianEmail());
				librarianRepository.save(librarian2);
				return librarian2;
			}
		}

		return null;
	}

	/*
	 * getAllData
	 */
	public List<Librarian> getAllLibrariansData() {

		return librarianRepository.findAll();
	}
}