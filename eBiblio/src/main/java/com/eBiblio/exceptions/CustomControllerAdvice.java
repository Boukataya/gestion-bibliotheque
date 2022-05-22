package com.eBiblio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
class CustomControllerAdvice {

    @ExceptionHandler(value = BusinessException.class)
    public final ResponseEntity<Object> handleEmailExistAlreadyException(BusinessException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Username or password incorrect", details);
        return new ResponseEntity(error, HttpStatus.NOT_ACCEPTABLE);
    }

}