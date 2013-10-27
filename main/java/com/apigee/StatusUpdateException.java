package com.apigee;

public class StatusUpdateException extends Exception {

    public StatusUpdateException (String message) {
        super(message);
    }

    public StatusUpdateException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
