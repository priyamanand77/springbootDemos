package com.LibrarySystem.LibraryAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LibrarySystem.LibraryAPI.dao.LibraryRepo;
import com.LibrarySystem.LibraryAPI.model.Books;

@Service
public class LibraryService 
{
	@Autowired
	private LibraryRepo repo;

	
	public Books updatedBook(Books b)
	{
		Books newb= repo.findById(b.getId()).get();
		newb.setId(b.getId());
		newb.setName(b.getName());
		newb.setPrice(b.getPrice());
		repo.save(newb);
		return newb;
		
	}
}
