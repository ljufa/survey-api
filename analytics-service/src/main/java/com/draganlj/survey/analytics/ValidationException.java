package com.draganlj.survey.analytics;

public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = -8996253939829432246L;

    public ValidationException(String message) {
        super(message);
    }
}
