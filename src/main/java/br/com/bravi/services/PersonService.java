package br.com.bravi.services;

import java.util.List;

import br.com.bravi.model.Person;

public interface PersonService {
	
	Person findById(Long id);
	
	List<Person> findAllPersons();

	void savePerson(Person person);

	void updatePerson(Person person);

	void deletePerson(Long id);
}