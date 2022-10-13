package com.student.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.student.mdoel.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, Integer> {

	
	public void deleteByRoll(int roll);
	public Student findByRoll(int roll);

}
