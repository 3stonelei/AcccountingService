package com.stone.accounting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @Author stone
 * @Date 2022/12/3 18:03
 * @Description ResourceNotFoundException

 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ServiceException {

    /**
     * Constructor for ResourceNotFoundException.
     *
     * @param message throw message
     */
    public ResourceNotFoundException(String message) {
        super(message);
        this.setStatusCode(HttpStatus.NOT_FOUND.value());

    }
}
