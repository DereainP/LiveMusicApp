package com.techelevator.model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArtistNotFoundException extends RuntimeException{


    private static final long serialVersionUID = 3015802323752245595L;

    public ArtistNotFoundException() {
    }

    public ArtistNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}

