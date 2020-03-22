package com.coronakarma.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coronakarma.backend.model.Requester;

public interface RequesterRepository extends JpaRepository<Requester, Long> {

	@Query("SELECT r FROM Requester r WHERE r.person.postalCode LIKE ?1%")
	List<Requester> findAllByPersonPostalCodeContaining(String postalCode);
}