package com.dvir.spring.test.web.dao;

import javax.validation.constraints.Size;

import com.dvir.spring.test.web.validation.ValidEmail;

public class Offer {
	private int id;

	@Size(min = 2, max = 100, message = "Name must be between 2 to 100 chars")
	private String name;

	// @Pattern(regexp = ".*\\@.*\\..*", message =
	// "This is not appere to be a valid email address")
	@ValidEmail(min = 6, message = "This email address is not valid.")
	private String email;

	@Size(min = 20, max = 4000, message = "Text must be between 2 to 100 chars")
	private String text;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}

}
