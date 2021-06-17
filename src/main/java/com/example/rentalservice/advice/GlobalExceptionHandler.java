package com.example.rentalservice.advice;

import com.example.rentalservice.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.ConnectException;
import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * ConnectException -->> 504
     */
    @ExceptionHandler(ConnectException.class)
    @ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT)
    public ResponseEntity<Object> handleConnectException(ConnectException exception) {
        return new ResponseEntity<>(new ErrorModel(HttpStatus.GATEWAY_TIMEOUT.value(), exception.toString(), Instant.now()), HttpStatus.GATEWAY_TIMEOUT);
    }

    /**
     * 500 -->> 502
     */
    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public ResponseEntity<Object> handleIntervalServerException(HttpServerErrorException exception) {
        if (exception.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR))
            return new ResponseEntity<>(new ErrorModel(HttpStatus.BAD_GATEWAY.value(), exception.toString(), Instant.now()), HttpStatus.BAD_GATEWAY);
        return ResponseEntity.ok().build();
    }

    /**
     * 404 -->> 404
     * 400 -->> 400
     */
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handle_4XX_Exceptions(HttpClientErrorException exception) {
        if (exception.getStatusCode().equals(HttpStatus.NOT_FOUND))
            return new ResponseEntity<>(new ErrorModel(HttpStatus.NOT_FOUND.value(), exception.toString(), Instant.now()), HttpStatus.NOT_FOUND);
        if (exception.getStatusCode().equals(HttpStatus.BAD_REQUEST))
            return new ResponseEntity<>(new ErrorModel(HttpStatus.BAD_REQUEST.value(), exception.toString(), Instant.now()), HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().build();
    }
}
