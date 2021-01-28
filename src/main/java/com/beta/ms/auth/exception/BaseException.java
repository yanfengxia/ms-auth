package com.beta.ms.auth.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * This is the base exception definition for this microservice
 * This class defines the default error code, message and http status in an exception for this microservice
 */
@Getter
public class BaseException extends RuntimeException {

    private String error;
    private HttpStatus status;

    private static final String DEFAULT_MESSAGE = "Process failed due to system operation, please use the reference ID contact system admin or try again later";
    private static final String DEFAULT_ERROR = "SERVER_ERROR";
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    /**
     * Instantiates a new Base exception.
     */
    public BaseException() {
        this(DEFAULT_STATUS, DEFAULT_ERROR, DEFAULT_MESSAGE);
    }

    /**
     * Instantiates a new Base exception.
     *
     * @param message the message
     */
    public BaseException(String message) {
        super(message);
        this.status = DEFAULT_STATUS;
        this.error = DEFAULT_ERROR;
    }

    /**
     * Instantiates a new Base exception.
     *
     * @param status  the status
     * @param error   the error
     * @param message the message
     */
    public BaseException(HttpStatus status, String error, String message) {
        super(message);
        this.status = status;
        this.error = error;
    }

    /**
     * Instantiates a new Base exception.
     *
     * @param status  the status
     * @param message the message
     */
    public BaseException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

}
