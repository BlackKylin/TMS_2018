package com.wyx.tms.exception;

/**
 * 业务异常
 */
public class ServiceException extends RuntimeException {

    public ServiceException(){}

    public ServiceException(Throwable th){
        super(th);
    }

    public ServiceException(String message){
        super(message);
    }
    public ServiceException(Throwable th,String message){
        super(message,th);
    }

}
