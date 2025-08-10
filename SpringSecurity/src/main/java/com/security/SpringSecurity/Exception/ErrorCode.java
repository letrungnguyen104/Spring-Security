package com.security.SpringSecurity.Exception;

import org.aspectj.bridge.IMessage;

public enum ErrorCode {
    UNCATEGORIED_EXCEPTION(9999, "Uncategorized Exception!"),
    KEY_INVALID(1001, "Invalid message key!"),
    USER_EXISTED(1002, "User existed!"),
    USERNAME_INVALID(1003, "Username must be at least 8 characters!"),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters!"),
    USER_NOT_EXISTED(1005, "User not found!"),
    EMAIL_INVALID(1006, "Incorrect email format!")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
