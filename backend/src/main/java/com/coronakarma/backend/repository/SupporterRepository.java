package com.coronakarma.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronakarma.backend.model.Supporter;

public interface SupporterRepository extends JpaRepository<Supporter, Long> {

	List<Supporter> findAllByPersonPostalCode(String postalCode);
}
