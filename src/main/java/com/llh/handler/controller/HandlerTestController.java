/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llh.handler.controller;

import static com.llh.handler.converter.CustomConverter.APPLICATION_PDF_CUSTOM_VALUE;
import com.llh.handler.dto.ListTestDto;
import com.llh.handler.dto.TestDto;
import com.llh.handler.enums.TypeException;
import com.llh.handler.exceptions.CustomException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lorenzolince
 */
@RestController
@RequestMapping(name = "Handler Test", value = "/api/handler")
public class HandlerTestController {

    @RequestMapping(
            value = "/pdf",
            method = GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE, APPLICATION_PDF_CUSTOM_VALUE}
    )
    public @ResponseBody
    ResponseEntity<TestDto> getElectionBookPdf(
            @RequestParam(name = "typeThrow", required = true) TypeException typeThrow)
            throws Exception {
        switch (typeThrow) {
            case CUSTOM_EXCEPTION:
                throw new CustomException().setMessage("test error handler").setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

            case GENERAL_EXCEPTION:
                Integer value = 1 / 0;
                break;
            case DATAACCESSEXCEPTION:
                throw new DataAccessException("DataAccessException") {
                };
            case PERSISTENCEEXCEPTION:
                throw new PersistenceException("PersistenceException");
            default: break;
        }
        List<ListTestDto> list = new ArrayList<ListTestDto>();
        list.add(new ListTestDto().setName("Carlos Lince")
                .setTel("6245-8966")
                .setEmail("carloslince@gmail.com"));
        list.add(new ListTestDto().setName("David Lince")
                .setTel("6245-5452")
                .setEmail("davidlince@gmail.com"));
        list.add(new ListTestDto().setName("Martha Jurado")
                .setTel("6218-6603")
                .setEmail("mart32@gmail.com"));
        TestDto test = new TestDto()
                .setCode(1)
                .setName("Lorenzo Lince")
                .setDirection("Panama Chorrera")
                .setStreet("6805")
                .setFriends(list);

        return new ResponseEntity<TestDto>(test, HttpStatus.OK);
    }
}
