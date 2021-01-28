package com.beta.ms.auth.exception;

import org.springframework.http.HttpStatus;

public class InvalidUserNameException extends BaseException {
    private static final String DEFAULT_MESSAGE = "Invalid UserName";
    private static final String DEFAULT_ERROR = "INVALID_USER_NAME";
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.BAD_REQUEST;

    /**
     * Instantiates a new External dependency exception.
     */
    public InvalidUserNameException() {
        this(DEFAULT_STATUS, DEFAULT_ERROR, DEFAULT_MESSAGE);
    }

    /**
     * Instantiates a new External dependency exception.
     *
     * @param message the message
     */
    public InvalidUserNameException(String message) {
        this(DEFAULT_STATUS, DEFAULT_ERROR, message);
    }

    /**
     * Instantiates a new External dependency exception.
     *
     * @param status  the status
     * @param error   the error
     * @param message the message
     */
    private InvalidUserNameException(HttpStatus status, String error, String message) {
        super(status,error,message);
    }
}
