package com.fenbeitong.openapitest.caller;


import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * RestTemplateUtil
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-21 - 下午4:46.
 **/
public class RestTemplateUtil {
    /**
     * @param url             :
     * @param returnClassName :
     * @param parameters      :
     * @return T
     * @author Created by ivan on 下午3:49 18-11-22.
     * <p>//TODO get
     **/
    static <T> T get(String url, Class<T> returnClassName, LinkedMultiValueMap<String, String> parameters) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ErrorHandler());
        if (parameters == null) {
            return restTemplate.getForObject(url, returnClassName);
        }
        return restTemplate.getForObject(url, returnClassName, parameters);
    }

    /**
     * @param url             :
     * @param returnClassName :
     * @param inputHeader     :
     * @param inputParameter  :
     * @return T
     * @author Created by ivan on 下午3:49 18-11-22.
     * <p>//TODO post
     **/
    public static <T> T post(String url, Class<T> returnClassName, Map<String, Object> inputHeader,
                             LinkedMultiValueMap<String, String> inputParameter) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ErrorHandler());
        // 请求Header
        HttpHeaders httpHeaders = new HttpHeaders();
        // 拼接Header
        if (inputHeader != null) {
            Set<String> keys = inputHeader.keySet();
            for (Iterator<String> i = keys.iterator(); i.hasNext(); ) {
                String key = (String) i.next();
                httpHeaders.add(key, inputHeader.get(key).toString());
            }
        }
        // 设置请求的类型及编码
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        if (inputParameter == null) {
            return restTemplate.postForObject(url, null, returnClassName);
        } else {
            HttpEntity<LinkedMultiValueMap<String, String>> formEntity = new HttpEntity<LinkedMultiValueMap<String, String>>(inputParameter, httpHeaders);
            return restTemplate.postForObject(url, formEntity, returnClassName);
        }
    }

    /**
     * @param url             :
     * @param returnClassName :
     * @param inputHeader     :
     * @param requestObj      :
     * @return T
     * @author Created by ivan on 下午3:49 18-11-22.
     * <p>//TODO postJson
     **/
    static <T> T postJson(String url, Class<T> returnClassName, Map<String, Object> inputHeader,
                          Object requestObj) {
        RestTemplate restTemplate = new RestTemplate();
        // 请求Header
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        // 拼接Header
        if (inputHeader != null) {
            Set<String> keys = inputHeader.keySet();
            for (Iterator<String> i = keys.iterator(); i.hasNext(); ) {
                String key = (String) i.next();
                httpHeaders.add(key, inputHeader.get(key).toString());
            }
        }
        String jsonData = "";
        if (null != requestObj) {
            Gson gson = new Gson();
            jsonData = gson.toJson(requestObj);
        }
        HttpEntity<String> requestEntity = new HttpEntity<String>(jsonData, httpHeaders);
        return restTemplate.postForObject(url, requestEntity, returnClassName);
    }

    /**
     * @param url             :
     * @param returnClassName :
     * @param inputHeader     :
     * @param inputParameter  :
     * @param urlVariables    :
     * @return T
     * @author Created by ivan on 下午3:50 18-11-22.
     * <p>//TODO put
     **/
    public static <T> T put(String url, Class<T> returnClassName, Map<String, Object> inputHeader,
                            LinkedMultiValueMap<String, String> inputParameter, Map<String, String> urlVariables) {
        return exchange(url, HttpMethod.PUT, returnClassName, inputHeader, inputParameter, urlVariables);
    }

    /**
     * @param url             :
     * @param returnClassName :
     * @param inputHeader     :
     * @param requestObj      :
     * @param urlVariables    :
     * @return T
     * @author Created by ivan on 下午3:50 18-11-22.
     * <p>//TODO putJson
     **/
    public static <T> T putJson(String url, Class<T> returnClassName, Map<String, Object> inputHeader,
                                Object requestObj, Map<String, String> urlVariables) {
        return exchangeJson(url, HttpMethod.PUT, returnClassName, inputHeader, requestObj, urlVariables);
    }

    /**
     * @param url             :
     * @param returnClassName :
     * @param inputHeader     :
     * @param urlVariables    :
     * @return T
     * @author Created by ivan on 下午3:50 18-11-22.
     * <p>//TODO delete
     **/
    public static <T> T delete(String url, Class<T> returnClassName, Map<String, Object> inputHeader,
                               Map<String, String> urlVariables) {
        return exchange(url, HttpMethod.DELETE, returnClassName, inputHeader, null, urlVariables);
    }

    /**
     * @param url             :
     * @param returnClassName :
     * @param inputHeader     :
     * @param urlVariables    :
     * @return T
     * @author Created by ivan on 下午3:50 18-11-22.
     * <p>//TODO deleteJson
     **/
    public static <T> T deleteJson(String url, Class<T> returnClassName, Map<String, Object> inputHeader,
                                   Map<String, String> urlVariables) {
        return exchangeJson(url, HttpMethod.DELETE, returnClassName, inputHeader, null, urlVariables);
    }

    /**
     * @param url             :
     * @param method          :
     * @param returnClassName :
     * @param inputHeader     :
     * @param inputParameter  :
     * @param urlVariables    :
     * @return T
     * @author Created by ivan on 下午3:50 18-11-22.
     * <p>//TODO exchange
     **/
    public static <T> T exchange(String url, HttpMethod method, Class<T> returnClassName,
                                 Map<String, Object> inputHeader, LinkedMultiValueMap<String, String> inputParameter,
                                 Map<String, String> urlVariables) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ErrorHandler());
        // 请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        // 拼接Header
        if (inputHeader != null) {
            Set<String> keys = inputHeader.keySet();
            for (Iterator<String> i = keys.iterator(); i.hasNext(); ) {
                String key = (String) i.next();
                httpHeaders.add(key, inputHeader.get(key).toString());
            }
        }
        // 请求体
        // 设置请求的类型及编码
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        // 发送请求
        if (inputParameter == null) {
            HttpEntity<Object> formEntity = new HttpEntity<Object>(null, httpHeaders);
            ResponseEntity<T> resultEntity = restTemplate.exchange(url, method, formEntity, returnClassName,
                    urlVariables);
            return resultEntity.getBody();
        } else {
            HttpEntity<LinkedMultiValueMap<String, String>> formEntity = new HttpEntity<LinkedMultiValueMap<String, String>>(
                    inputParameter, httpHeaders);
            ResponseEntity<T> resultEntity = restTemplate.exchange(url, method, formEntity, returnClassName,
                    urlVariables);
            return resultEntity.getBody();
        }
    }

    /**
     * @param url             :
     * @param method          :
     * @param returnClassName :
     * @param inputHeader     :
     * @param requestObj      :
     * @param urlVariables    :
     * @return T
     * @author Created by ivan on 下午3:51 18-11-22.
     * <p>//TODO exchangeJson
     **/
    public static <T> T exchangeJson(String url, HttpMethod method, Class<T> returnClassName,
                                     Map<String, Object> inputHeader, Object requestObj, Map<String, String> urlVariables) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ErrorHandler());
        // 请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        // 拼接Header
        if (inputHeader != null) {
            Set<String> keys = inputHeader.keySet();
            for (Iterator<String> i = keys.iterator(); i.hasNext(); ) {
                String key = (String) i.next();
                httpHeaders.add(key, inputHeader.get(key).toString());
            }
        }
        // 请求体
        // 设置请求的类型及编码
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        // 发送请求
        if (requestObj == null) {
            HttpEntity<Object> formEntity = new HttpEntity<Object>(null, httpHeaders);
            ResponseEntity<T> resultEntity = restTemplate.exchange(url, method, formEntity, returnClassName,
                    urlVariables);
            return resultEntity.getBody();
        } else {
            Gson gson = new Gson();
            String jsonData = gson.toJson(requestObj);
            HttpEntity<String> formEntity = new HttpEntity<String>(jsonData, httpHeaders);
            ResponseEntity<T> resultEntity = restTemplate.exchange(url, method, formEntity, returnClassName,
                    urlVariables);
            return resultEntity.getBody();
        }
    }
}
