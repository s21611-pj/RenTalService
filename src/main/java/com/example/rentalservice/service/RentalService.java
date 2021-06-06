package com.example.rentalservice.service;

import com.example.rentalservice.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        Movie movie = restTemplate.getForEntity("http://localhost:8080/movies/" + id, Movie.class).getBody();
        return movie;
    }
}
