package com.LibrarySystem.LibraryAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.LibrarySystem.LibraryAPI.dao.LibraryRepo;
import com.LibrarySystem.LibraryAPI.model.Books;
import com.LibrarySystem.LibraryAPI.service.LibraryService;

@RestController
public class LibraryController {

	@Autowired
	private LibraryRepo repo;

	@Autowired
	private LibraryService ser;

	@GetMapping("/get")
	public List<Books> getAllBooks() {
		return repo.findAll();
	}

	@PostMapping("/add")
	public Books addBooks(@RequestBody Books b) {
		return repo.save(b);

	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneItem(@PathVariable("id") int id) {
		repo.deleteById(id);
		return "deleted successful";
	}

	@PutMapping("/upd")
	public Books updateItem(@RequestBody Books b) {
		Books newb = ser.updatedBook(b);
		return newb;

	}

}
