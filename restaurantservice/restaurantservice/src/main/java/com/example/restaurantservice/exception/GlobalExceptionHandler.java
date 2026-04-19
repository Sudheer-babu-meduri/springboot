package com.example.restaurantservice.exception;


import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //  Restaurant Not Found
    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRestaurantNotFound(
            RestaurantNotFoundException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
        		LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Restaurant Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //  Food Item Not Found
    @ExceptionHandler(FoodItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFoodItemNotFound(
            FoodItemNotFoundException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
        		LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Food Item Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //  Invalid Data
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidData(
            InvalidDataException ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
        		LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Data",
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // any other exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
        		LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}