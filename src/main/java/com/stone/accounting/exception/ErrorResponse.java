package com.stone.accounting.exception;

/**
 * @author stone
 * @date 2022/11/15-@20:29
 */
public class ErrorResponse {
    private String errorCode;
    private ServiceException.ErrorType errorType;
    private String message;
    private int statusCode;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorCode, ServiceException.ErrorType errorType, String message, int statusCode) {
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceException.ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ServiceException.ErrorType errorType) {
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}
