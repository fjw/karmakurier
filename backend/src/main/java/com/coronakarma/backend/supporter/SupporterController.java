package com.coronakarma.backend.supporter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
public class SupporterController {

    private SupporterRepository supporterRepository;

    @Autowired
    public SupporterController(SupporterRepository supporterRepository) {
        this.supporterRepository = supporterRepository;
    }

    @GetMapping("/location/{postalCode}/supporters/")
    public List<Supporter> getByPostalCode(@PathVariable String postalCode) {
        return supporterRepository.findAllByPersonPostalCodeContaining(postalCode);
    }

    @GetMapping("/supporters")
    public List<Supporter> getSupporters() {
        return supporterRepository.findAll();
    }

    @PostMapping("/supporters")
    public Supporter create(@Valid @RequestBody Supporter supporter) {
        return supporterRepository.save(supporter);
    }

    @GetMapping("/supporters/{supporterId}")
    public Supporter get(@PathVariable Long supporterId) {
        return supporterRepository.findById(supporterId)
                .orElseThrow(() -> new EntityNotFoundException("Supporter with id " + supporterId + " not found"));
    }

    @PatchMapping("/supporters/{supporterId}")
    public Supporter update(@PathVariable Long supporterId, @Valid @RequestBody Supporter supporterRequest) {
        return supporterRepository.findById(supporterId).map(supporter -> {
            supporter.setEmail(supporterRequest.getEmail());
            supporter.setAvailability(supporterRequest.getAvailability());
            supporter.setTransport(supporterRequest.getTransport());
            return supporterRepository.save(supporter);
        }).orElseThrow(() -> new EntityNotFoundException("Supporter with id " + supporterId + " not found"));
    }

    @DeleteMapping("/supporters/{supporterId}")
    public ResponseEntity<?> deleteSupporter(@PathVariable Long supporterId) {
        return supporterRepository.findById(supporterId).map(supporter -> {
            supporterRepository.delete(supporter);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new EntityNotFoundException("Supporter with id " + supporterId + " not found"));
    }
}
