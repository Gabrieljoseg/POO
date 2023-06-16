package com.api.poo.apicomspring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(
            ResourceNotFoundExceptionex, WebRequestrequest) {
        ErrorResponse errorDetails =
                new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.toString(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

@ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<?> entityAlreadyExistsException(
            ResourceNotFoundExceptionex, WebRequestrequest) {
        ErrorResponse errorDetails =
                new ErrorResponse(new Date(), HttpStatus.UNPROCESSABLE_ENTITY.toString(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
    }

@ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exceptionex, WebRequestrequest) {
        ErrorResponse errorDetails =
                new ErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString() ,ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}