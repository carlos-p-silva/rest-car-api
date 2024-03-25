package com.caps.rentcarapi.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ResponseException implements Serializable {

    private static final long serialVersionUID = 2013286435909711400L;

    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ResponseException(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}
