package br.com.bravi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bravi.model.Person;
import br.com.bravi.repositories.PersonRepository;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person findById(Long id) {
		return personRepository.findOne(id);
	}

	public List<Person> findAllPersons() {
		return personRepository.findAll();
	}

	public void savePerson(Person person) {
		personRepository.save(person);
	}

	public void updatePerson(Person person) {
		savePerson(person);
	}

	public void deletePerson(Long id) {
		personRepository.delete(id);
	}
}