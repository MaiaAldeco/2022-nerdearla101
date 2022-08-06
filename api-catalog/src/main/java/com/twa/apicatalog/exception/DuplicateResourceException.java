package com.twa.apicatalog.exception;

import com.twa.apicatalog.enums.ApiError;

public class DuplicateResourceException extends TWAException{

    public DuplicateResourceException(ApiError error) {
        super(error.getHttpStatus(), error.getMessage(), null);
    }
}
