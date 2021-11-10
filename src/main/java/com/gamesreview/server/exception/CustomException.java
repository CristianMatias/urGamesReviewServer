package com.gamesreview.server.exception;

import lombok.Getter;

public class CustomException extends Exception {
    @Getter private String message;

    public CustomException(Exception ex){
        super(ex);
        this.message = ex.getMessage();
    }

    public CustomException(Exception ex, String message){
        super(ex);
        this.message = message;
    }

    public CustomException(String message){
        super(new Exception());
        this.message = message;
    }
}
