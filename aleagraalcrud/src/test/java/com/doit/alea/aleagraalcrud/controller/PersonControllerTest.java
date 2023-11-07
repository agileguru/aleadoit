package com.doit.alea.aleagraalcrud.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.doit.alea.aleagraalcrud.model.Person;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
class PersonControllerTest {

	@Autowired
	private PersonController controller;
	
	@Test
	void testCaMappings() {
		log.info("Getting All User");
		ResponseEntity<List<String>> allPersons = this.controller.getDefault();
		assertThat(allPersons.getBody()).isNotNull().hasSize(2);
		log.info("Mappings are {} " , allPersons.getBody());
	}
	
	
	@Test
	void testCanGet() {
		log.info("Getting All User");
		ResponseEntity<List<Person>> allPersons = this.controller.getAll();
		assertThat(allPersons.getBody()).isNotNull();
		log.info("All Users are {} " , allPersons.getBody());
	}

	@Test
	void testCanCreate() {
		log.info("Creating User");
		ResponseEntity<Person> newPerson = this.controller.createPerson();
		Person person = newPerson.getBody();
		assertThat(person).isNotNull();
		assertThat(person.getId()).isNotNull();
		log.info("Created new user with id {} and userName {} " , person.getId(), person.getUsername());
		
		testCanGet();
	}
	
}
