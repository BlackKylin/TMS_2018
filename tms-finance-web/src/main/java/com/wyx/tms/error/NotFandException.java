package com.wyx.tms.error;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 404
 * @author wyx
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFandException extends RuntimeException {
}
