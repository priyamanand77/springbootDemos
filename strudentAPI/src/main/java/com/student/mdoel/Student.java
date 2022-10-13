package com.student.mdoel;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;



@Data
@Document(collection = "stud")
public class Student {
	private String _id;
	private int roll;
	private String name;
	private int standard;
	private String sec;
	
	
}
