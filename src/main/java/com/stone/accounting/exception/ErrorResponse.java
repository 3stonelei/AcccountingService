package com.stone.accounting.exception;

import lombok.Builder;
import lombok.Data;


/*
 * @Author stone
 * @Date 2022/12/3 18:02
 * @Description ErrorResponse
 */

@Data
@Builder
public class ErrorResponse {
    private String errorCode;
    private ServiceException.ErrorType errorType;
    private String message;
    private int statusCode;


}
