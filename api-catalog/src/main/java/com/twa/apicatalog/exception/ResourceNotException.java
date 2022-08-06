package com.twa.apicatalog.exception;

import com.twa.apicatalog.enums.ApiError;

public class ResourceNotException extends TWAException{
    public ResourceNotException(ApiError apiError) {
        super(apiError.getHttpStatus(), apiError.getMessage(), null);
    }
}
