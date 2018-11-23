package com.fenbeitong.openapitest.caller;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * ErrorHandler
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-21 - 下午4:47.
 **/
public class ErrorHandler implements ResponseErrorHandler {

    /**
     * @author Created by ivan on 下午8:57 18-11-22.
     * <p>//TODO hasError
     * @param response : 
     * @return boolean
     * @see org.springframework.web.client.ResponseErrorHandler#hasError(org.springframework.http.client.ClientHttpResponse)
     **/
    @Override
    public boolean hasError(ClientHttpResponse response) {
        return false;
    }

    /**
     * @author Created by ivan on 下午8:57 18-11-22.
     * <p>//TODO handleError
     * @param response : 
     * @return void
     * @see org.springframework.web.client.ResponseErrorHandler#handleError(org.springframework.http.client.ClientHttpResponse)
     **/
    @Override
    public void handleError(ClientHttpResponse response) {

    }

}