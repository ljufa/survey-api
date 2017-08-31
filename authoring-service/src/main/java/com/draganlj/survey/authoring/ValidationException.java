package com.draganlj.survey.authoring;

public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = 4329710056704148895L;

    public ValidationException(String message) {
        super(message);
    }
}
