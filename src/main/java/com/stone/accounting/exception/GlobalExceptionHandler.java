package com.stone.accounting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.InvalidParameterException;

/**
 * @author stone
 * @date 2022/11/15-@20:58
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .errorCode("USER_NOT_FOUND")
                        .errorType(ServiceException.ErrorType.Client)
                        .message(e.getMessage())
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .build());
    }
    @ExceptionHandler(InvalidParameterException.class)
    ResponseEntity<?> handlerInvalidParameterException(InvalidParameterException e){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(ErrorResponse.builder()
                        .errorCode("ID_IS_INVALID")
                        .errorType(ServiceException.ErrorType.Client)
                        .message(e.getMessage())
                        .statusCode(HttpStatus.NOT_ACCEPTABLE.value())
                        .build());
    }
}
