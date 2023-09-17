package com.hotel.service.Exception;

import com.hotel.service.PayLoad.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){


        ApiResponse response = ApiResponse.builder()
                .message(ex.getMessage())
                .success(true)
                .status(HttpStatus.NOT_FOUND)
                .build();

        return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
