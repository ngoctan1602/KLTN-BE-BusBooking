package com.tantan.BusBookingBEJava.exception;

import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ControllerAdvice
public class ValidationException {
    //    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<BaseResponse> handleCustomException(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(
//                error -> errors.put(error.getField(), error.getDefaultMessage())
//        );
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
//                new BaseResponse(true, HttpStatus.BAD_REQUEST.value(), "Some field has not validation", errors)
//        );
//    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<BaseResponse> handleCustomException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new BaseResponse(true, HttpStatus.BAD_REQUEST.value(), "Some field has not validation", errors)
        );
    }
}
