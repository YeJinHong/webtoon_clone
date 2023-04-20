package com.example.webtoon_api.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex){
        ErrorCode errorCode = ex.getErrorCode();
        String errorMessage = errorCode.getMessage();

        Map<String, Object> response = new HashMap<>();

        response.put("error", errorCode.getHttpStatus().name());
        response.put("code", errorCode.name());
        response.put("status", errorCode.getHttpStatus().value());
        response.put("message", errorMessage);

        return new ResponseEntity<>(response, errorCode.getHttpStatus());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request){
        Map<String, Object> response = new HashMap<>();

        response.put("error", HttpStatus.BAD_REQUEST);
        response.put("code", "UNPROCESSABLE ENTITY");
        response.put("status", "422");
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}