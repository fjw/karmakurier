package com.coronakarma.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronakarma.backend.model.Requester;

public interface RequesterRepository extends JpaRepository<Requester, Long> {

	List<Requester> findAllByPersonPostalCode(String postalCode);
}