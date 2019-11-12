/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.llh.handler.converter;

import com.google.common.io.ByteStreams;
import com.llh.handler.dto.TestDto;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

/**
 *
 * @author lorenzolince
 */
@Component
public class CustomConverter extends AbstractHttpMessageConverter<TestDto> {

    public static final String APPLICATION_PDF_CUSTOM_VALUE = "application/api_custom_pdf";
    public static final MediaType APPLICATION_PDF_CUSTOM = new MediaType("application", "api_custom_pdf");

    @Autowired
    private ResourceLoader resourceLoader;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomConverter.class);

    @Override
    protected boolean supports(Class<?> type) {
        return TestDto.class.isAssignableFrom(type);
    }

    @Override
    protected TestDto readInternal(Class<? extends TestDto> type, HttpInputMessage him) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(TestDto t, HttpOutputMessage hom) throws IOException, HttpMessageNotWritableException {
        LOGGER.info(t.toString());
        Resource res = resourceLoader.getResource("classpath:test.pdf");
        hom.getBody().write(ByteStreams.toByteArray(res.getInputStream()));

    }

}
