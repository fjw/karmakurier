package com.coronakarma.backend.requester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
public class RequesterController {

    private RequesterRepository requesterRepository;

    @Autowired
    public RequesterController(RequesterRepository requesterRepository) {
        this.requesterRepository = requesterRepository;
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
                .orElseThrow(() -> new EntityNotFoundException("Requester with id " + requesterId + " not found"));
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
        }).orElseThrow(() -> new EntityNotFoundException("Requester with id " + requesterId + " not found"));
    }

    @DeleteMapping("/requesters/{requesterId}")
    public ResponseEntity<?> deleteRequester(@PathVariable Long requesterId) {
        return requesterRepository.findById(requesterId).map(requester -> {
            requesterRepository.delete(requester);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new EntityNotFoundException("Requester with id " + requesterId + " not found"));
    }
}
