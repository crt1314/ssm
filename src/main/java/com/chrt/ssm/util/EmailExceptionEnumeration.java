package com.chrt.ssm.util;

public enum EmailExceptionEnumeration {

    EMAIL_FAILED_TO_SEND("Failed to send email."),
    EMAIL_FAILED_TO_SET_MESSAGE("Failed to set email message"),
    EMAIL_FAILED_TO_INSERT("Failed to insert email"),
    EMAIL_FAILED_TO_MEET_REQUIREMENTS("Failed to meet requirements");

    private final String message;

    EmailExceptionEnumeration(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
