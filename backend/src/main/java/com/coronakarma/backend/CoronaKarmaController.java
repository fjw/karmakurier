package com.coronakarma.backend;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coronakarma.backend.model.Person;
import com.coronakarma.backend.model.Requester;
import com.coronakarma.backend.model.Supporter;
import com.coronakarma.backend.repository.PersonRepository;
import com.coronakarma.backend.repository.RequesterRepository;
import com.coronakarma.backend.repository.SupporterRepository;

@RestController
public class CoronaKarmaController {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private RequesterRepository requesterRepository;

	@Autowired
	private SupporterRepository supporterRepository;

	@GetMapping("/location/{postalCode}/persons/")
	public List<Person> getPersonsByPostalCode(@PathVariable String postalCode) {
		return personRepository.findAllByPostalCodeContaining(postalCode);
	}

	@GetMapping("/persons")
	public List<Person> getPersons() {
		return personRepository.findAll();
	}
	
	@PostMapping("/persons")
	public Person createPerson(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}

	@GetMapping("/persons/{personId}")
	public Person getPerson(@PathVariable Long personId) {
		return personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person with id " + personId + " not found"));
	}

	@PutMapping("/persons/{personId}")
	public Person updatePerson(@PathVariable Long personId, @Valid @RequestBody Person personRequest) {
		return personRepository.findById(personId).map(person -> {
			person.setFirstName(personRequest.getFirstName());
			person.setLastName(personRequest.getLastName());
			person.setPostalCode(personRequest.getPostalCode());
			person.setStreet(personRequest.getStreet());
			person.setCity(personRequest.getCity());
			person.setPhoneNumber(personRequest.getPhoneNumber());
			return personRepository.save(person);
		}).orElseThrow(() -> new ResourceNotFoundException("Person with id " + personId + " not found"));
	}

	@DeleteMapping("/persons/{personId}")
	public ResponseEntity<?> deletePerson(@PathVariable Long personId) {
		return personRepository.findById(personId).map(person -> {
			personRepository.delete(person);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Person with id " + personId + " not found"));
	}

	@GetMapping("/location/{postalCode}/requesters/")
	public List<Requester> getRequestersByPostalCode(@PathVariable String postalCode) {
		return requesterRepository.findAllByPersonPostalCodeContaining(postalCode);
	}

	@GetMapping("/requesters")
	public List<Requester> getRequesters() {
		return requesterRepository.findAll();
	}

	@PostMapping("/requesters")
	public Requester createRequester(@Valid @RequestBody Requester requester) {
		return requesterRepository.save(requester);
	}

	@GetMapping("/requesters/{requesterId}")
	public Requester getRequester(@PathVariable Long requesterId) {
		return requesterRepository.findById(requesterId)
				.orElseThrow(() -> new ResourceNotFoundException("Requester with id " + requesterId + " not found"));
	}

	@PutMapping("/requesters/{requesterId}")
	public Requester updateRequester(@PathVariable Long requesterId, @Valid @RequestBody Requester requesterRequest) {
		return requesterRepository.findById(requesterId).map(requester -> {
			requester.setShoppingList(requesterRequest.getShoppingList());
			requester.setDietaryRequirements(requesterRequest.getDietaryRequirements());
			requester.setPaymentMethod(requesterRequest.getPaymentMethod());
			requester.setPremium(requesterRequest.getPremium());
			requester.setMaxAmount(requesterRequest.getMaxAmount());
			return requesterRepository.save(requester);
		}).orElseThrow(() -> new ResourceNotFoundException("Requester with id " + requesterId + " not found"));
	}

	@DeleteMapping("/requesters/{requesterId}")
	public ResponseEntity<?> deleteRequester(@PathVariable Long requesterId) {
		return requesterRepository.findById(requesterId).map(requester -> {
			requesterRepository.delete(requester);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Requester with id " + requesterId + " not found"));
	}

	@GetMapping("/location/{postalCode}/supporters/")
	public List<Supporter> getSupportersByPostalCode(@PathVariable String postalCode) {
		return supporterRepository.findAllByPersonPostalCodeContaining(postalCode);
	}

	@GetMapping("/supporters")
	public List<Supporter> getSupporters() {
		return supporterRepository.findAll();
	}

	@PostMapping("/supporters")
	public Supporter createSupporter(@Valid @RequestBody Supporter supporter) {
		return supporterRepository.save(supporter);
	}

	@GetMapping("/supporters/{supporterId}")
	public Supporter getSupporter(@PathVariable Long supporterId) {
		return supporterRepository.findById(supporterId)
				.orElseThrow(() -> new ResourceNotFoundException("Supporter with id " + supporterId + " not found"));
	}

	@PutMapping("/supporters/{supporterId}")
	public Supporter updateSupporter(@PathVariable Long supporterId, @Valid @RequestBody Supporter supporterRequest) {
		return supporterRepository.findById(supporterId).map(supporter -> {
			supporter.setEmail(supporterRequest.getEmail());
			supporter.setAvailability(supporterRequest.getAvailability());
			supporter.setTransport(supporterRequest.getTransport());
			return supporterRepository.save(supporter);
		}).orElseThrow(() -> new ResourceNotFoundException("Supporter with id " + supporterId + " not found"));
	}

	@DeleteMapping("/supporters/{supporterId}")
	public ResponseEntity<?> deleteSupporter(@PathVariable Long supporterId) {
		return supporterRepository.findById(supporterId).map(supporter -> {
			supporterRepository.delete(supporter);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Supporter with id " + supporterId + " not found"));
	}

}
