package com.example.rentalservice.service;

import com.example.rentalservice.model.Movie;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        String URI = "http://localhost:8080/movies/" + id;
        ResponseEntity<Movie> response = restTemplate.getForEntity(URI, Movie.class);
        Movie movie = restTemplate.getForEntity(URI, Movie.class).getBody();
        int statusCode = response.getStatusCode().value();
        System.out.println(statusCode);
        return movie;
    }

    public void returnMovie(Long id) {
        String URI = "http://localhost:8080/movies/availability/" + id;
        restTemplate.put(URI, null);
    }

    public void rentMovie(Long id) {
        String URI = "http://localhost:8080/movies/availability/false/" + id;
        restTemplate.put(URI, null);
    }
}
