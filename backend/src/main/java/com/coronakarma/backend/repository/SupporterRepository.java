package com.coronakarma.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coronakarma.backend.model.Supporter;

public interface SupporterRepository extends JpaRepository<Supporter, Long> {

	@Query("SELECT s FROM Supporter s WHERE s.person.postalCode LIKE ?1%")
	List<Supporter> findAllByPersonPostalCodeContaining(String postalCode);
}
