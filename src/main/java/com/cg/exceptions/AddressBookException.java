package com.cg.exceptions;

public class AddressBookException extends Exception {
    
    private static final long serialVersionUID = 2852365301586571753L;
    public ExceptionTypes exceptionTypes;

    public AddressBookException(ExceptionTypes exceptionTypes){
        this.exceptionTypes = exceptionTypes;
    }

    public enum ExceptionTypes{
        USER_NOT_FOUND("Invalid Data.. User not found"),
        ID_NOT_FOUND("Incorrect id..Enter the valid id"),
        OTHER_EXCEPTION("other exceptions");
        public String errorMessage;

        ExceptionTypes(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

}
