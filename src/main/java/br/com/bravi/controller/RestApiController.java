package br.com.bravi.controller;

import java.util.List;

import org.h2.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bravi.model.Person;
import br.com.bravi.services.PersonService;
import br.com.bravi.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger LOGGER = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	PersonService personService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPerson(@PathVariable("id") long id) {
		LOGGER.info("Fetching Person with id {}", id);
		Person person = personService.findById(id);
		if (person == null) {
			LOGGER.error("Person with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Person with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public ResponseEntity<?> createPerson(@RequestBody Person person) {
		LOGGER.info("Creating Person : {}", person);
		personService.savePerson(person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
		LOGGER.info("Updating Person with id {}", id);

		Person currentPerson = personService.findById(id);

		if (currentPerson == null) {
			LOGGER.error("Unable to update. Person with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Person with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}

		if (!StringUtils.isNullOrEmpty(person.getName())) {
			currentPerson.setName(person.getName());
		}

		personService.updatePerson(currentPerson);
		return new ResponseEntity<Person>(currentPerson, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePerson(@PathVariable("id") long id) {
		LOGGER.info("Fetching & Deleting Person with id {}", id);

		Person person = personService.findById(id);
		if (person == null) {
			LOGGER.error("Unable to delete. Person with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Person with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}
		personService.deletePerson(id);
		return new ResponseEntity<Person>(HttpStatus.OK);
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> listAllPersons() {
		List<Person> persons = personService.findAllPersons();
		if (persons.isEmpty()) {
			return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}
}