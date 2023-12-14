package com.ecommerce.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.error.ActionException;
import com.ecommerce.error.ErrorResponse;

/**
 * 當觸發ActionException的時候，自動捕捉
 */
@ControllerAdvice
public class ActionExceptionHandler {
    @ExceptionHandler(ActionException.class)
    public ResponseEntity<ErrorResponse> handleActionException(ActionException ex) {
        ErrorResponse response = new ErrorResponse(ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
