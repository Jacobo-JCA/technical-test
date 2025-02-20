package com.tata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handlerExceptionGlobal(Exception ex, WebRequest req) {
        CustomErrorResponse error = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handlerModelNotFound(ModelNotFoundException ex, WebRequest req) {
        CustomErrorResponse er = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<CustomErrorResponse> handlerSQLException(SQLException ex, WebRequest req) {
        CustomErrorResponse err = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.CONFLICT);
    }
}
