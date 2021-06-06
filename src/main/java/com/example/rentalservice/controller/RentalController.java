package com.example.rentalservice.controller;

import com.example.rentalservice.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.rentalservice.service.RentalService;

@RestController
@RequestMapping("/rent")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> returnMovie(@PathVariable Long id) {
        rentalService.returnMovie(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/false/{id}")
    public ResponseEntity<Void> rentMovie(@PathVariable Long id) {
        rentalService.rentMovie(id);
        return ResponseEntity.ok().build();
    }
}
