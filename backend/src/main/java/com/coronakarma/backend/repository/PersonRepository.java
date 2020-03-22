package com.coronakarma.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coronakarma.backend.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("SELECT p FROM Person p WHERE  p.postalCode LIKE ?1%")
	List<Person> findAllByPostalCodeContaining(String postalCode);
}
