package com.twa.apicatalog.exception;

import com.twa.apicatalog.dto.ErrorDTO;
import com.twa.apicatalog.enums.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotException.class)
    public ResponseEntity<ErrorDTO> resourceNotFound(ResourceNotException resourceNotException, WebRequest request){
        return ResponseEntity.status(resourceNotException.getStatus())
                .body(new ErrorDTO(resourceNotException.getDescription(), resourceNotException.getReasons()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> reasons = new ArrayList<>();
        for(FieldError error : ex.getBindingResult().getFieldErrors()) {
            reasons.add(String.format("%s - %s", error.getField(), error.getDefaultMessage()));
        }
        return ResponseEntity.status(ApiError.VALIDATION_ERROR.getHttpStatus())
                .body(new ErrorDTO(ApiError.VALIDATION_ERROR.getMessage(), reasons));
    }
}
