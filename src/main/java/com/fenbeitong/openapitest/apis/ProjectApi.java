package com.fenbeitong.openapitest.apis;

import com.fenbeitong.openapitest.caller.ApiCaller;
import com.fenbeitong.openapitest.config.FbtConfig;
import com.fenbeitong.openapitest.models.BizCommonList;
import com.fenbeitong.openapitest.models.BizCommonModel;
import com.fenbeitong.openapitest.models.project.*;
import com.fenbeitong.openapitest.params.BizCommonParams;
import com.fenbeitong.openapitest.params.project.*;
import io.micrometer.core.instrument.util.StringUtils;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * ProjectApi
 * <p><b>第三方项目接口</b></p>
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-22 - 下午8:02.
 * @tag 第三方项目
 **/
@RestController
@Api(value = "第三方项目接口", tags = "第三方项目中心")
public class ProjectApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrequentApi.class);

    private static final String CREATE_URL = "/open/api/third/project/create";
    private static final String CREATE_BATCH_URL = "/open/api/third/project/createBatch";

    private static final String UPDATE_URL = "/open/api/third/project/update";
    private static final String UPDATE_STATE_URL = "/open/api/third/project/updateState";
    private static final String UPDATE_STATE_BATCH_URL = "/open/api/third/project/updateStateBatch";

    private static final String QUERY_URL = "/open/api/third/project/list";
    private static final String QUERY_APP_URL = "/open/api/third/project/listApp";

    private static final String GET_URL = "/open/api/third/project/get";

    private FbtConfig fbtConfig;
    private ApiCaller apiCaller;

    @Autowired
    public ProjectApi(ApiCaller apiCaller, FbtConfig fbtConfig) {
        this.apiCaller = apiCaller;
        this.fbtConfig = fbtConfig;
    }

    /**
     * @param createRequest :
     * @param signKey       :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.CreateResponse>
     * @author Created by ivan on 下午5:58 18-11-23.
     * <p>添加第三方项目</p>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "添加第三方项目", notes = "添加第三方项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/createThirdProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<CreateResponse> createThirdProject(@ApiParam(value = "创建第三方项目参数") @RequestBody BizCommonParams<CreateRequest> createRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + CREATE_URL, createRequest, new BizCommonModel<CreateResponse>(), false);
    }
    /**
     * @author Created by ivan on 下午6:22 18-11-23.
     * <p>批量添加第三方项目</p>
     * @param createRequest :
     * @param signKey :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.CreateBatchResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "批量添加第三方项目", notes = "批量添加第三方项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/createThirdProjectBatch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<CreateBatchResponse> createThirdProjectBatch(@ApiParam(value = "批量创建第三方项目参数") @RequestBody BizCommonParams<CreateBatchRequest> createRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + CREATE_BATCH_URL, createRequest, new BizCommonModel<CreateBatchResponse>(), false);
    }

    /**
     * @author Created by ivan on 下午6:23 18-11-23.
     * <p>更新第三方项目</p>
     * @param updateRequest :
     * @param signKey :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.UpdateResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "更新第三方项目", notes = "更新第三方项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/updateThirdProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<UpdateResponse> updateThirdProject(@ApiParam(value = "更新第三方项目") @RequestBody BizCommonParams<UpdateRequest> updateRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + UPDATE_URL, updateRequest, new BizCommonModel<UpdateResponse>(), false);
    }
    
    /**
     * @author Created by ivan on 下午6:23 18-11-23.
     * <p>更新第三方项目状态</p>
     * @param updateStateRequest : 
     * @param signKey : 
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.UpdateStateResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "更新第三方项目状态", notes = "更新第三方项目状态")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/updateThirdProjectState", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<UpdateStateResponse> updateThirdProjectState(@ApiParam(value = "更新第三方项目状态参数") @RequestBody BizCommonParams<UpdateStateRequest> updateStateRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + UPDATE_STATE_URL, updateStateRequest, new BizCommonModel<UpdateStateResponse>(), false);
    }
    /**
     * @author Created by ivan on 下午6:23 18-11-23.
     * <p>批量更新第三方项目状态</p>
     * @param updateStateBatchRequest : 
     * @param signKey : 
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.UpdateStateBatchResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "批量更新第三方项目状态", notes = "批量更新第三方项目状态")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/updateThirdProjectStateByBatch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<UpdateStateBatchResponse> updateThirdProjectStateByBatch(@ApiParam(value = "批量更新第三方项目状态参数") @RequestBody BizCommonParams<UpdateStateBatchRequest> updateStateBatchRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + UPDATE_STATE_BATCH_URL, updateStateBatchRequest, new BizCommonModel<UpdateStateBatchResponse>(), false);
    }
    /**
     * @author Created by ivan on 下午6:23 18-11-23.
     * <p>查询第三方项目详情</p>
     * @param getRequest : 
     * @param signKey : 
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.GetResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "查询第三方项目详情", notes = "查询第三方项目详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/getThirdProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<GetResponse> getThirdProject(@ApiParam(value = "查询第三方项目详情参数", type = "form") @RequestBody BizCommonParams<GetRequest> getRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.getByPostRequest(fbtConfig.getBaseUrl() + GET_URL, getRequest, new BizCommonModel<GetResponse>(), null);
    }
    /**
     * @author Created by ivan on 下午6:24 18-11-23.
     * <p>查询第三方项目列表</p>
     * @param queryRequest : 
     * @param signKey : 
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.QueryResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "查询第三方项目列表", notes = "查询第三方项目列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/queryThirdProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<QueryResponse> queryThirdProject(@ApiParam(value = "查询第三方项目列表参数", type = "form") @RequestBody BizCommonParams<QueryRequest> queryRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.getByPostRequest(fbtConfig.getBaseUrl() + QUERY_URL, queryRequest, new BizCommonModel<GetResponse>(), null);
    }
    /**
     * @author Created by ivan on 下午6:24 18-11-23.
     * <p>查询第三方项目列表(APP)</p>
     * @param queryRequest : 
     * @param signKey : 
     * @return com.fenbeitong.openapitest.models.BizCommonList<com.fenbeitong.openapitest.models.project.QueryAppResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "查询第三方项目列表(APP)", notes = "查询第三方项目列表(APP)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/queryThirdProjectApp", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonList<QueryAppResponse> queryThirdProjectApp(@ApiParam(value = "查询第三方项目列表参数", type = "form") @RequestBody BizCommonParams<QueryAppRequest> queryRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return  apiCaller.getListByPostRequest(fbtConfig.getBaseUrl() + QUERY_APP_URL, queryRequest, new BizCommonList<QueryAppResponse>(), null);
    }
}
