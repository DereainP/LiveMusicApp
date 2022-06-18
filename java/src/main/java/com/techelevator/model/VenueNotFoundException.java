package com.techelevator.model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VenueNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 3015802323752245595L;

    public VenueNotFoundException() {
    }

    public VenueNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }



}
