package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.demo.exceptions.ApiErrors;
import com.example.demo.exceptions.RegraNegocioException;

    @RestControllerAdvice
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public class ApplicationControllerAdvice {
    @ExceptionHandler(RegraNegocioException.class)

    public ApiErrors handlerRegraNegocioException(RegraNegocioException ex) {
    return new ApiErrors(ex.getMessage());
    }
}
