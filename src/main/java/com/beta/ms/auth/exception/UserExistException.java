package com.beta.ms.auth.exception;

import org.springframework.http.HttpStatus;

public class UserExistException extends BaseException {
    private static final String DEFAULT_MESSAGE = "User already exist";
    private static final String DEFAULT_ERROR = "USER_EXIST";
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.BAD_REQUEST;

    /**
     * Instantiates a new External dependency exception.
     */
    public UserExistException() {
        this(DEFAULT_STATUS, DEFAULT_ERROR, DEFAULT_MESSAGE);
    }

    /**
     * Instantiates a new External dependency exception.
     *
     * @param message the message
     */
    public UserExistException(String message) {
        this(DEFAULT_STATUS, DEFAULT_ERROR, message);
    }

    /**
     * Instantiates a new External dependency exception.
     *
     * @param status  the status
     * @param error   the error
     * @param message the message
     */
    private UserExistException(HttpStatus status, String error, String message) {
        super(status,error,message);
    }
}
