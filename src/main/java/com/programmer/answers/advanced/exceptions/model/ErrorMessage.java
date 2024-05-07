package com.programmer.answers.advanced.exceptions.model;

import java.time.Instant;

public class ErrorMessage {

    private int statusCode;
    private Instant timestamp;
    private String message;
    private String description;

    public ErrorMessage(int statusCode, Instant timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
