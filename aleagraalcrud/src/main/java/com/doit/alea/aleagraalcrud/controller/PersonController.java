package com.doit.alea.aleagraalcrud.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doit.alea.aleagraalcrud.data.PersonRepository;
import com.doit.alea.aleagraalcrud.model.Person;

@RestController
@Transactional
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	
	@GetMapping("/")
	public ResponseEntity<List<String>> getDefault() {
		return new ResponseEntity<>(List.of("/person/create","/persons"),HttpStatus.OK);
	}
	
	@GetMapping("/persons")
	public ResponseEntity<List<Person>> getAll() {
		return new ResponseEntity<>(this.personRepository.findAll(),HttpStatus.OK);
	}

	@GetMapping("/person/create")
	public ResponseEntity<Person> createPerson() {
		Person person = new Person();
		person.setUsername(UUID.randomUUID().toString());
		person.setFirstname(this.getClass().getName());
		person.setLastname(this.getClass().getCanonicalName());
		this.personRepository.save(person);
		
		return new ResponseEntity<>(person,HttpStatus.OK);
	}
	
	
}
