package br.com.bravi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bravi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findByName(String name);
}