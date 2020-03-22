package com.coronakarma.backend.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coronakarma.backend.common.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("SELECT p FROM Person p WHERE  p.postalCode LIKE ?1%")
	List<Person> findAllByPostalCodeContaining(String postalCode);
}
