package com.backend.backend.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.backend.backend.exception.BaseException;

import lombok.Data;

@ControllerAdvice
public class ErrorAdviser {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {
        
    }

    @Data
    public static class ErrorResponse {
        private LocalDateTime timeStamp = LocalDateTime.now();
        private int status;
        private String error;
    }
}
