package com.project.backend.common.exceptions.handler;


import com.project.backend.common.exceptions.CustomException;
import com.project.backend.common.exceptions.dto.ErrorCode;
import com.project.backend.common.exceptions.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = ErrorResponse.of(e.getErrorCode());
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
    }

    @ExceptionHandler(IOException.class)
    protected ResponseEntity<ErrorResponse> handleIOException(IOException e) {
        log.error(e.getMessage(), e);
        ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
    }
}
