package com.twa.apicatalog.enums;

import org.springframework.http.HttpStatus;

public enum ApiError {

    VALIDATION_ERROR(HttpStatus.BAD_REQUEST,"Attributes with wrong values"),
    BAD_FORMAT(HttpStatus.BAD_REQUEST,"The message not have a correct form"),
    COUNTRY_NOT_FOUND(HttpStatus.BAD_REQUEST,"Country not found");
    private final HttpStatus httpStatus;
    private final String message;

    ApiError(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
