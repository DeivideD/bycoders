package com.bycoders.apidemo.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class ResourceExceptionHandler {

  SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
  Date date = new Date(System.currentTimeMillis());

  @ExceptionHandler(AppException.class)
  public ResponseEntity<StandardError> objectNotFound(AppException e, HttpServletRequest request) {

    StandardError error = new StandardError();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMensage(e.getMessage());
    error.setTimeHour(formatter.format(date));

    return new ResponseEntity(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<StandardError> internalServerError(RuntimeException e, HttpServletRequest request) {

    StandardError error = new StandardError();
    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    error.setMensage(e.getMessage());
    error.setTimeHour(formatter.format(date));

    return new ResponseEntity(error, HttpStatus.NOT_FOUND);
  }

}