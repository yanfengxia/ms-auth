package com.beta.ms.auth.exception;

import org.springframework.http.HttpStatus;

public class UserRegisterException extends BaseException {
    private static final String DEFAULT_MESSAGE = "User registration failed";
    private static final String DEFAULT_ERROR = "USER_REGISTER_FAIL";
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    /**
     * Instantiates a new External dependency exception.
     */
    public UserRegisterException() {
        this(DEFAULT_STATUS, DEFAULT_ERROR, DEFAULT_MESSAGE);
    }

    /**
     * Instantiates a new External dependency exception.
     *
     * @param message the message
     */
    public UserRegisterException(String message) {
        this(DEFAULT_STATUS, DEFAULT_ERROR, message);
    }

    /**
     * Instantiates a new External dependency exception.
     *
     * @param status  the status
     * @param error   the error
     * @param message the message
     */
    private UserRegisterException(HttpStatus status, String error, String message) {
        super(status,error,message);
    }
}
