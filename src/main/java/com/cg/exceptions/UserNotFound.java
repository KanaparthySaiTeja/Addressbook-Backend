package com.cg.exceptions;

public class UserNotFound extends IllegalArgumentException{
    
    private static final long serialVersionUID = -9019431180560327068L;

    public UserNotFound(String message) {
        super(message);
    }
}
