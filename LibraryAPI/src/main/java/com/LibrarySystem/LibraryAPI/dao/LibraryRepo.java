package com.LibrarySystem.LibraryAPI.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.LibrarySystem.LibraryAPI.model.Books;

@Repository
public interface LibraryRepo extends MongoRepository<Books, Integer> {

}
