package com.beta.ms.auth.exception;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends BaseException {
    private static final String DEFAULT_MESSAGE = "Invalid Password";
    private static final String DEFAULT_ERROR = "INVALID_PASSWORD";
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.BAD_REQUEST;

    /**
     * Instantiates a new External dependency exception.
     */
    public InvalidPasswordException() {
        this(DEFAULT_STATUS, DEFAULT_ERROR, DEFAULT_MESSAGE);
    }

    /**
     * Instantiates a new External dependency exception.
     *
     * @param message the message
     */
    public InvalidPasswordException(String message) {
        this(DEFAULT_STATUS, DEFAULT_ERROR, message);
    }

    /**
     * Instantiates a new External dependency exception.
     *
     * @param status  the status
     * @param error   the error
     * @param message the message
     */
    private InvalidPasswordException(HttpStatus status, String error, String message) {
        super(status,error,message);
    }
}
