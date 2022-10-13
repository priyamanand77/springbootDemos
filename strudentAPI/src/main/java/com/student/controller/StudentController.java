package com.student.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.dao.StudentRepo;
import com.student.mdoel.Student;

@RestController
public class StudentController {

	@Autowired
	StudentRepo srepo;

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student s) {
		return srepo.save(s);
	}

	@GetMapping("/")
	public String test() {
		return "working very fine";
	}

//	@GetMapping("/all")
//	public List<Student> getAll() {
//
//		return srepo.findAll();
//
//	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAll() {

		List<Student> s= srepo.findAll();
		
		if(s.isEmpty())
		{
			
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else		
		{
//			return  ResponseEntity.of(Optional.of(s));
	return ResponseEntity.status(HttpStatus.OK).body(s);
	}
	}
	@DeleteMapping("/delete/{roll}")
	public String deletebyroll(@PathVariable("roll") int roll) {
		srepo.deleteByRoll(roll);
		return "deleted successfully";
	}

	@PutMapping("/update")
	public Student update(@RequestBody Student s) {
		Student old = srepo.findByRoll(s.getRoll());
		old.setName(s.getName());
		old.setRoll(s.getRoll());
		old.setSec(s.getSec());
		old.setStandard(s.getStandard());
		srepo.save(old);
		return old;
	}

}
