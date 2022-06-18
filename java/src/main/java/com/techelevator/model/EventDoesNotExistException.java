package com.techelevator.model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventDoesNotExistException  extends RuntimeException{



        private static final long serialVersionUID = -5735550862192890835L;

        public EventDoesNotExistException() {
        }

        public EventDoesNotExistException(String message, Throwable cause) {
            super(message, cause);
        }

    }

