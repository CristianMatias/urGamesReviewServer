package com.gamesreview.server.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseHelper {

    public <E> ResponseEntity<E> sendCorrect(E type){
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    public ResponseEntity<String> sendError(String message){
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
