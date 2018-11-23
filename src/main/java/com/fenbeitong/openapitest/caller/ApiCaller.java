package com.fenbeitong.openapitest.caller;

import com.fenbeitong.openapitest.comms.ValueHelper;
import com.fenbeitong.openapitest.models.BizCommonList;
import com.fenbeitong.openapitest.models.BizCommonModel;
import com.fenbeitong.openapitest.params.BizCommonParams;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ApiCaller
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-21 - 下午4:57.
 **/
@Component
public class ApiCaller<T extends BizCommonParams, R> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValueHelper.class);

    private String[] ignores = {};
    private String signKey = "";

    /**
     * @param url        :
     * @param param      :
     * @param model      :
     * @param extraParam :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<R>
     * @author Created by ivan on 下午3:51 18-11-22.
     * <p>//TODO getRequest
     **/
    @SuppressWarnings(value = "unchecked")
    public BizCommonModel<R> getRequest(String url, T param, R model, Map<String, String> extraParam) throws UnsupportedEncodingException {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        // set common
        T paramData = this.initParam(param);
        LOGGER.info("Post Request: " + url + " | Params: " + gson.toJson(paramData));

        // expend url
        Map<String, String> urlParameters = new HashMap<String, String>();
        urlParameters = ValueHelper.transBean2Map(paramData, urlParameters, ignores);
        url = expandUrl(url, urlParameters);
        // call
        String resultString = RestTemplateUtil.get(url, String.class, null);
        LOGGER.info("Get Single Request: " + url + " | Response: " + resultString);
        // return
        return (BizCommonModel<R>) (gson.fromJson(resultString, model.getClass()));
    }
    /**
     * @author Created by ivan on 下午3:22 18-11-23.
     * <p>//TODO getByPostRequest
     * @param url : 
     * @param param : 
     * @param model : 
     * @param extraParam : 
     * @return com.fenbeitong.openapitest.models.BizCommonModel<R>
     **/
    public BizCommonModel<R> getByPostRequest(String url, T param, R model, Map<String, String> extraParam) throws UnsupportedEncodingException {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        // set common
        T paramData = this.initParam(param);
        LOGGER.info("Post Request: " + url + " | Params: " + gson.toJson(paramData));
        // put body
        LinkedMultiValueMap<String, String> inputParameter = new LinkedMultiValueMap<String, String>();
        Map<String, String> valueMap = ValueHelper.transBean2Map(paramData, new HashMap<String, String>(), ignores);
        inputParameter.setAll(valueMap);
        if (null != extraParam) {
            inputParameter.setAll(extraParam);
        }
        // call
        String resultString = RestTemplateUtil.post(url, String.class, null,inputParameter);
        LOGGER.info("Get Single Request: " + url + " | Response: " + resultString);
        // return
        return (BizCommonModel<R>) (gson.fromJson(resultString, model.getClass()));
    }
    /**
     * @author Created by ivan on 下午3:23 18-11-23.
     * <p>//TODO getListRequest
     * @param url : 
     * @param param : 
     * @param model : 
     * @param extraParam : 
     * @return com.fenbeitong.openapitest.models.BizCommonList<R>
     **/
    public BizCommonList<R> getListRequest(String url, T param, R model, Map<String, String> extraParam) throws UnsupportedEncodingException {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        // set commom
        T paramData = this.initParam(param);
        LOGGER.info("Get List Request: " + url + " | Params: " + gson.toJson(paramData));
        // expend url
        Map<String, String> urlParameters = new HashMap<String, String>();
        urlParameters = ValueHelper.transBean2Map(paramData, urlParameters, ignores);
        url = expandUrl(url, urlParameters);

        // call
        String resultString = RestTemplateUtil.get(url, String.class, null);
        LOGGER.info("Get Single Request: " + url + " | Response: " + resultString);
        // return
        return (BizCommonList<R>) (gson.fromJson(resultString, model.getClass()));
    }

    /**
     * @param url        :
     * @param param      :
     * @param model      :
     * @param extraParam :
     * @return com.fenbeitong.openapitest.models.BizCommonList<R>
     * @author Created by ivan on 下午7:33 18-11-22.
     * <p>//TODO getListRequest
     **/
    @SuppressWarnings(value = "unchecked")
    public BizCommonList<R> getListByPostRequest(String url, T param, R model, Map<String, String> extraParam) throws UnsupportedEncodingException {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        // set commom
        T paramData = this.initParam(param);
        LOGGER.info("Get List Request: " + url + " | Params: " + gson.toJson(paramData));

        // put body
        LinkedMultiValueMap<String, String> inputParameter = new LinkedMultiValueMap<String, String>();
        Map<String, String> valueMap = ValueHelper.transBean2Map(paramData, new HashMap<String, String>(), ignores);
        inputParameter.setAll(valueMap);
        if (null != extraParam) {
            inputParameter.setAll(extraParam);
        }
        // call
        String resultString = RestTemplateUtil.post(url, String.class, null, inputParameter);
        LOGGER.info("Get Single Request: " + url + " | Response: " + resultString);
        // return
        return (BizCommonList<R>) (gson.fromJson(resultString, model.getClass()));
    }


    /**
     * @param url      :
     * @param param    :
     * @param model    :
     * @param jsonFlag :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<R>
     * @author Created by ivan on 下午3:51 18-11-22.
     * <p>//TODO postRequest
     **/
    @SuppressWarnings(value = "unchecked")
    public BizCommonModel<R> postRequest(String url, T param, R model, boolean jsonFlag) throws
            UnsupportedEncodingException {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        // Set Common Part
        T paramData = this.initParam(param);
        LOGGER.info("Post Request: " + url + " | Params: " + gson.toJson(paramData));

        // put param
        LinkedMultiValueMap<String, String> inputParameter = new LinkedMultiValueMap<String, String>();
        Map<String, String> valueMap = ValueHelper.transBean2Map(paramData, new HashMap<String, String>(), ignores);
        inputParameter.setAll(valueMap);

        // call
        String resultString;
        if (jsonFlag) {
            resultString = RestTemplateUtil.postJson(url, String.class, null, paramData);
        } else {
            resultString = RestTemplateUtil.post(url, String.class, null, inputParameter);
        }
        LOGGER.info("Post Request: " + url + " | Response: " + resultString);

        // return
        return (BizCommonModel<R>) (gson.fromJson(resultString, model.getClass()));
    }

    /**
     * @param param :
     * @return T
     * @author Created by ivan on 下午3:51 18-11-22.
     * <p>//TODO initParam
     **/
    private T initParam(T param) throws UnsupportedEncodingException {
        param.setTimestamp(System.currentTimeMillis());
        param.setSign(this.generateSign(String.valueOf(param.getTimestamp()), param.getData().toString(), this.signKey));
        return param;
    }

    /**
     * @param timestamp :
     * @param data      :
     * @param signKey   :
     * @return java.lang.String
     * @author Created by ivan on 下午3:51 18-11-22.
     * <p>//TODO generateSign
     **/
    private String generateSign(String timestamp, String data, String signKey) throws UnsupportedEncodingException {
        LOGGER.info("timestamp=" + timestamp + "&data=" + data + "&sign_key=" + signKey);
        return DigestUtils.md5DigestAsHex(("timestamp=" + timestamp + "&data=" + data + "&sign_key=" + signKey).getBytes(StandardCharsets.UTF_8));
    }

    /**
     * @param url    :
     * @param params :
     * @return java.lang.String
     * @author Created by ivan on 下午3:51 18-11-22.
     * <p>//TODO expandUrl
     **/
    private String expandUrl(String url, Map<String, String> params) {
        Set<String> keySet = params.keySet();
        if (!keySet.isEmpty()) {
            url = url + "/?";
            for (String key : keySet) {
                String value = params.get(key);
                if (StringUtils.isNotBlank(value)) {
                    url = StringUtils.join(url, key, "=", value.toString(), "&");
                }
            }
            return url.substring(0, url.length() - 1);
        }
        LOGGER.info("expandUrl-----URL=" + url);
        return url;
    }

    /**
     * @param signKey :
     * @author Created by ivan on 下午3:51 18-11-22.
     * <p>//TODO setSignKey
     **/
    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }
}
