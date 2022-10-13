package com.LibrarySystem.LibraryAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Books {
	@Id
	private int id;
	private String name;
	private float price;

	public Books(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Books() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	// POJO 1. class public
	// 2. constructor with filed
	// 3. no args constructor
	// 4. getter setter
	// 5. tostring overrige

}
