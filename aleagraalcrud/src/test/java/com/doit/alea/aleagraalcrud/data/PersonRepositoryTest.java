package com.doit.alea.aleagraalcrud.data;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.doit.alea.aleagraalcrud.model.Person;

import lombok.extern.slf4j.Slf4j;

@Transactional
@SpringBootTest
@Slf4j
class PersonRepositoryTest {

	@Autowired
	private PersonRepository repository;
	private Person person;
	
	@BeforeEach
	void setUp() throws Exception {
		this.person = new Person();
		this.person.setFirstname(this.getClass().getName());
		this.person.setLastname(this.getClass().getCanonicalName());
		this.person.setUsername(this.getClass().getSimpleName());
	}

	@Test
	void testCanCreate() {
		log.info("Create a new user ");
		this.repository.save(this.person);
		Assertions.assertThat(person.getId()).isNotNull();
		log.info("Created new user with id {} " , person.getId());
	}
	
	@Test
	void testCanDelete() {
		testCanCreate();
		log.info("Delete an existing user  with ID {}", person.getId());
		if ( person.getId() == null ) {
			return;
		}
		Optional<Person> fetchedPerson = this.repository.findById(person.getId());
		log.info("Found Existing user with id {} having name {} " , person.getId(), fetchedPerson.get().getUsername());
	}

}
