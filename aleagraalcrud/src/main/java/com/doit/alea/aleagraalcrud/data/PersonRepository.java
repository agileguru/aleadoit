package com.doit.alea.aleagraalcrud.data;

import org.springframework.data.repository.ListCrudRepository;

import com.doit.alea.aleagraalcrud.model.Person;

public interface PersonRepository extends ListCrudRepository<Person, Long> {

}
