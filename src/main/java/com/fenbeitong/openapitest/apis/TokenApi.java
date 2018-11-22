package com.fenbeitong.openapitest.apis;

import com.fenbeitong.openapitest.caller.RestTemplateUtil;
import com.fenbeitong.openapitest.config.FbtConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * TokenApi
 * <p><b>API 鉴权接口，颁发Token</b></p>
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-22 - 下午4:05.
 * @tag 权限模块
 **/
@RestController
@Api(value = "API 鉴权接口，颁发Token", tags = "权限模块")
public class TokenApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenApi.class);

    private static final String TOKEN_URL = "/open/api/auth/v1/dispense";

    private FbtConfig fbtConfig;

    @Autowired
    public TokenApi(FbtConfig fbtConfig) {
        this.fbtConfig = fbtConfig;
    }

    /**
     * @return java.lang.String
     * @author Created by ivan on 下午4:11 18-11-22.
     * <p>//TODO getAccessToken
     **/
    @ApiOperation(value = "API 鉴权接口，颁发Token", notes = "根据项目配置参数获取企业访问Token")
    @PostMapping(value = "/getToken", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getAccessToken() {
        Map<String, String> req = new HashMap<String, String>();
        req.put("app_id", fbtConfig.getAppId());
        req.put("app_key", fbtConfig.getAppKey());
        req.put("app_type", fbtConfig.getAppType());
        LinkedMultiValueMap<String, String> inputParameter = new LinkedMultiValueMap<String, String>();
        inputParameter.setAll(req);
        return RestTemplateUtil.post(fbtConfig.getBaseUrl() + TOKEN_URL, String.class, null, inputParameter);

    }

    /**
     * @param app_id   : 企业ID
     * @param app_key  : 企业Key
     * @param app_type : 企业类型
     * @return java.lang.String 返回结果
     * @author Created by ivan on 下午4:11 18-11-22.
     * <p><b>API 鉴权接口，颁发Token</b></p>
     * <p>根据企业参数获取企业访问Token</p>
     * <p>请求参数，统一以application/x-www-form-urlencoded传递</p>
     **/
    @ApiOperation(value = "API 鉴权接口，颁发Token", notes = "根据企业参数获取企业访问Token  \n请求参数，统一以application/x-www-form-urlencoded传递")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", dataType = "String", name = "app_id", value = "企业ID", required = true),
            @ApiImplicitParam(paramType = "form", dataType = "String", name = "app_key", value = "企业KEY", required = true),
            @ApiImplicitParam(paramType = "form", dataType = "String", name = "app_type", value = "企业类型", required = true)
    })
    @PostMapping(value = "/getTokenWithParams", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getAccessTokenWithParam(@RequestParam String app_id,
                                          @RequestParam String app_key,
                                          String app_type) {
        Map<String, String> req = new HashMap<String, String>();
        req.put("app_id", app_id);
        req.put("app_key", app_key);
        req.put("app_type", app_type);
        LinkedMultiValueMap<String, String> inputParameter = new LinkedMultiValueMap<String, String>();
        inputParameter.setAll(req);
        return RestTemplateUtil.post(fbtConfig.getBaseUrl() + TOKEN_URL, String.class, null, inputParameter);
    }
}

