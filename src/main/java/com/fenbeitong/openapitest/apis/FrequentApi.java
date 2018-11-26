package com.fenbeitong.openapitest.apis;

import com.fenbeitong.openapitest.caller.ApiCaller;
import com.fenbeitong.openapitest.config.FbtConfig;
import com.fenbeitong.openapitest.models.BizCommonList;
import com.fenbeitong.openapitest.models.BizCommonModel;
import com.fenbeitong.openapitest.models.frequent.*;
import com.fenbeitong.openapitest.params.BizCommonParams;
import com.fenbeitong.openapitest.params.frequent.*;
import io.micrometer.core.instrument.util.StringUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * FrequentApi
 * <p><b>第三方联系人接口</b></p>
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-22 - 下午5:27.
 * @tag 第三方联系人
 **/
@RestController
@Api(value = "第三方常用联系人接口", tags = "常用联系人")
public class FrequentApi {

    private static final String CREATE_URL = "/open/api/third/frequent/create";
    private static final String UPDATE_URL = "/open/api/third/frequent/update";
    private static final String DELETE_URL = "/open/api/third/frequent/del";
    private static final String QUERY_URL = "/open/api/third/frequent/list";
    private static final String GET_URL = "/open/api/third/frequent/get";


    private FbtConfig fbtConfig;
    private ApiCaller apiCaller;

    @Autowired
    public FrequentApi(ApiCaller apiCaller, FbtConfig fbtConfig) {
        this.apiCaller = apiCaller;
        this.fbtConfig = fbtConfig;
    }

    /**
     * @param createFrequentRequest :
     * @param signKey               :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.frequent.CreateFrequentResponse>
     * @author Created by ivan on 下午7:56 18-11-22.
     * <p>添加常用联系人</p>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "添加常用联系人", notes = "添加常用联系人")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/createThirdFrenqent", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<CreateFrequentResponse> createThirdFrequent(@ApiParam(value = "创建常用联系人参数") @RequestBody BizCommonParams<CreateFrequentRequest> createFrequentRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + CREATE_URL, createFrequentRequest, new BizCommonModel<CreateFrequentResponse>(), false);
    }

    /**
     * @param updateFrequentRequest :
     * @param signKey               :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.frequent.UpdateFrequentReponse>
     * @author Created by ivan on 下午7:57 18-11-22.
     * <p>更新常用联系人</p>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "更新常用联系人", notes = "更新常用联系人")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/updateThirdFrenqent", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<UpdateFrequentResponse> updateThirdFrequent(@ApiParam(value = "更新常用联系人参数") @RequestBody BizCommonParams<UpdateFrequentRequest> updateFrequentRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + UPDATE_URL, updateFrequentRequest, new BizCommonModel<UpdateFrequentResponse>(), false);
    }

    /**
     * @param deleteFrequentRequest :
     * @param signKey               :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.frequent.DeleteFrequentReponse>
     * @author Created by ivan on 下午7:57 18-11-22.
     * <p>删除常用联系人</p>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "删除常用联系人", notes = "删除常用联系人")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/deleteThirdFrenqent", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<DeleteFrequentResponse> deleteThirdFrequent(@ApiParam(value = "删除常用联系人参数", type = "form") @RequestBody BizCommonParams<DeleteFrequentRequest> deleteFrequentRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + DELETE_URL, deleteFrequentRequest, new BizCommonModel<DeleteFrequentResponse>(), false);
    }

    /**
     * @param queryFrequentRequest :
     * @param signKey              :
     * @return com.fenbeitong.openapitest.models.BizCommonList<com.fenbeitong.openapitest.models.frequent.QueryFrequentReponse>
     * @author Created by ivan on 下午7:57 18-11-22.
     * <p>查询常用联系人列表</p>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "查询常用联系人列表", notes = "查询常用联系人列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/queryThirdFrenqent", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonList<QueryFrequentResponse> queryThirdFrequent(@ApiParam(value = "查询常用联系人参数", type = "form") @RequestBody BizCommonParams<QueryFrequentRequest> queryFrequentRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.getListByPostRequest(fbtConfig.getBaseUrl() + QUERY_URL, queryFrequentRequest, new BizCommonList<QueryFrequentResponse>(), null);
    }

    /**
     * @param getFrequentRequest :
     * @param signKey            :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.frequent.GetFrequentReponse>
     * @author Created by ivan on 下午7:57 18-11-22.
     * <p>查询常用联系人详情</p>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "查询常用联系人详情", notes = "查询常用联系人详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/getThirdFrenqent", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<GetFrequentResponse> getThirdFrequent(@ApiParam(value = "查询常用联系人参数", type = "form") @RequestBody BizCommonParams<GetFrequentRequest> getFrequentRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.getByPostRequest(fbtConfig.getBaseUrl() + GET_URL, getFrequentRequest, new BizCommonModel<GetFrequentResponse>(), null);
    }
}
