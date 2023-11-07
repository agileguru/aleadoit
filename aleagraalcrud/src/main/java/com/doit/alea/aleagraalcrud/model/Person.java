package com.doit.alea.aleagraalcrud.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.ToString;

@Entity
@ToString(callSuper = true)
public class Person extends AbstractPersistable<Long> {

	@Column(unique = true)
	private String username;

	private String firstname;
	private String lastname;

	public Person(Long id) {
		this.setId(id);
	}

	public Person() {
		this(null);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
