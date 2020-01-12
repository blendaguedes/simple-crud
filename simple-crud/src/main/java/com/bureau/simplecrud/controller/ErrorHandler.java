package com.bureau.simplecrud.controller;

import com.bureau.simplecrud.exception.ApplicationError;
import com.bureau.simplecrud.exception.TranslatorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    private String details;

    @ExceptionHandler(TranslatorNotFoundException.class)
    public ResponseEntity<ApplicationError> handleCostumerNotFoundException(TranslatorNotFoundException exception, WebRequest webRequest){

        ApplicationError applicationError = new ApplicationError();
        applicationError.setCode(HttpStatus.NOT_FOUND.value());
        applicationError.setMessage(exception.getMessage());
        applicationError.setDetails(details);

        return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
    }
}
