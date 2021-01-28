package com.beta.ms.auth.ro;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * This class defines the customized error information for this microservice
 * This microservice will return timestamp, error code, message and reference ID to API callers in http response
 * These information are handled during exception handling defined in ExceptionConfig.java
 */
@Data
@NoArgsConstructor
public class ErrorRO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ" )
    private Date timeStamp;
    private String error;
    private String message;
    private String referenceID;

    /**
     * Instantiates a new Error info.
     *
     * @param error       the error
     * @param message     the message
     * @param referenceID the reference id
     */
    public ErrorRO(String error, String message, String referenceID) {
        this.timeStamp = new Date();
        this.error = error;
        this.message = message;
        this.referenceID = referenceID;
    }

}
