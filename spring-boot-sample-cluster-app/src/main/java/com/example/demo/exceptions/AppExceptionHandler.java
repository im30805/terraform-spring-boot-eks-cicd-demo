package com.example.demo.exceptions;

import java.util.Date;

import com.example.demo.ui.model.response.ErrorMessage;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
  
  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();

    if(errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }
    
    ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());
    return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
  public ResponseEntity<Object> handleSpecificExceptions(Exception ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();

    if(errorMessageDescription == null) {
      errorMessageDescription = ex.toString();
    }

    ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());
    return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

}