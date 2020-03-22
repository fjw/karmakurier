package com.coronakarma.backend.supporter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupporterRepository extends JpaRepository<Supporter, Long> {

	@Query("SELECT s FROM Supporter s WHERE s.person.postalCode LIKE ?1%")
	List<Supporter> findAllByPersonPostalCodeContaining(String postalCode);
}
