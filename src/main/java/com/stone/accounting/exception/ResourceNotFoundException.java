package com.stone.accounting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author stone
 * @date 2022/11/15-@17:50
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ServiceException{

    public ResourceNotFoundException(String message){
        super(message);
        this.setStatusCode(HttpStatus.NOT_FOUND.value());

    }
}
