/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llh.handler.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author lorenzolince
 */
@ControllerAdvice(basePackages = {"com.llh.handler"})
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> empExceptionsHandle(final CustomException ex, final HttpServletRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("message", ex.getMessage());
        body.put("status", ex.getStatus().getReasonPhrase());
        body.put("show", true);
        LOGGER.error("ERROR HANDLER CustomException "+ex);
        return new ResponseEntity<Map<String, Object>>(body, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> exceptionsHandle(final Exception ex, final HttpServletRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("message", "procces error");
        body.put("status", HttpStatus.valueOf(500));
        body.put("show", true);
        LOGGER.error("ERROR HANDLER  Exception ",ex);
        return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> exceptionsJpaRepositoryHandler(final DataAccessException ex, final HttpServletRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("message", "database error");
        body.put("status", HttpStatus.valueOf(500));
        body.put("show", true);
        LOGGER.error("ERROR HANDLER JPA REPOSITORY  ", ex);
        return new ResponseEntity<Map<String, Object>>(body,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersistenceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> exceptionsEntityManagerHandler(final PersistenceException ex, final HttpServletRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("message", "database error");
        body.put("status", HttpStatus.valueOf(500));
        body.put("show", true);
        LOGGER.error("ERROR HANDLER ENTITY MANAGER ", ex);
        return new ResponseEntity<Map<String, Object>>(body,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
