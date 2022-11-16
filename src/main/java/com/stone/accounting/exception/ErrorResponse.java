package com.stone.accounting.exception;

import lombok.*;

/**
 * @author stone
 * @date 2022/11/15-@20:29
 */
@Data
@Builder
public class ErrorResponse {
    private String errorCode;
    private ServiceException.ErrorType errorType;
    private String message;
    private int statusCode;


}
