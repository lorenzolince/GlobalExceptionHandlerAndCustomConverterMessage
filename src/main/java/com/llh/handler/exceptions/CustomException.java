/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llh.handler.exceptions;

import org.springframework.http.HttpStatus;

/**
 *
 * @author lorenzolince
 */
public class CustomException extends RuntimeException {

    private HttpStatus status;

    public CustomException() {
        super();
    }
     public CustomException(String mesage) {
        super(mesage);
    }


    public HttpStatus getStatus() {
        return status;
    }

    public CustomException setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return  super.getMessage();
    }

    public CustomException setMessage(String mesage) {
        return  new CustomException(mesage);
    }
}
