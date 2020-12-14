package com.cg.exceptions;

public class DetailsNotProvidedExceptions  extends IllegalArgumentException{
   
    private static final long serialVersionUID = -4705287187799673847L;

    public DetailsNotProvidedExceptions(String message) {
        super(message);
    }
}
