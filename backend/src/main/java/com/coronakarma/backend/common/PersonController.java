package com.coronakarma.backend.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

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
                .orElseThrow(() -> new EntityNotFoundException("Person with id " + personId + " not found"));
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
        }).orElseThrow(() -> new EntityNotFoundException("Person with id " + personId + " not found"));
    }

    @DeleteMapping("/persons/{personId}")
    public ResponseEntity<?> deletePerson(@PathVariable Long personId) {
        return personRepository.findById(personId).map(person -> {
            personRepository.delete(person);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new EntityNotFoundException("Person with id " + personId + " not found"));
    }
}
