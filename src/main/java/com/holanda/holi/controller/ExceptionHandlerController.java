package com.holanda.holi.controller;

import com.holanda.holi.exceptions.ErrorResponse;
import com.holanda.holi.exceptions.custom.InvalidDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidDataException.class)
    protected ResponseEntity<?> notFoundException(Exception e, HttpServletRequest req){
        ErrorResponse errorFound = new ErrorResponse(404, new Date(), e.getMessage(), req.getRequestURI());
        return new ResponseEntity<>(errorFound, HttpStatus.NOT_FOUND);
    }

}
