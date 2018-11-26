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
     * @param createProjectRequest :
     * @param signKey       :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.CreateProjectResponse>
     * @author Created by ivan on 下午5:58 18-11-23.
     * <p>添加第三方项目</p>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "添加第三方项目", notes = "添加第三方项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/createThirdProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<CreateProjectResponse> createThirdProject(@ApiParam(value = "创建第三方项目参数") @RequestBody BizCommonParams<CreateProjectRequest> createProjectRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + CREATE_URL, createProjectRequest, new BizCommonModel<CreateProjectResponse>(), false);
    }
    /**
     * @author Created by ivan on 下午6:22 18-11-23.
     * <p>批量添加第三方项目</p>
     * @param createProjectBatchRequest :
     * @param signKey :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.CreateBatchProjectResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "批量添加第三方项目", notes = "批量添加第三方项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/createThirdProjectBatch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<CreateProjectBatchResponse> createThirdProjectBatch(@ApiParam(value = "批量创建第三方项目参数") @RequestBody BizCommonParams<CreateProjectBatchRequest> createProjectBatchRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + CREATE_BATCH_URL, createProjectBatchRequest, new BizCommonModel<CreateProjectBatchResponse>(), false);
    }

    /**
     * @author Created by ivan on 下午6:23 18-11-23.
     * <p>更新第三方项目</p>
     * @param updateProjectRequest :
     * @param signKey :
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.UpdateProjectResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "更新第三方项目", notes = "更新第三方项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/updateThirdProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<UpdateProjectResponse> updateThirdProject(@ApiParam(value = "更新第三方项目") @RequestBody BizCommonParams<UpdateProjectRequest> updateProjectRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + UPDATE_URL, updateProjectRequest, new BizCommonModel<UpdateProjectResponse>(), false);
    }
    
    /**
     * @author Created by ivan on 下午6:23 18-11-23.
     * <p>更新第三方项目状态</p>
     * @param updateProjectStateRequest :
     * @param signKey : 
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.UpdateProjectStateResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "更新第三方项目状态", notes = "更新第三方项目状态")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/updateThirdProjectState", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<UpdateProjectStateResponse> updateThirdProjectState(@ApiParam(value = "更新第三方项目状态参数") @RequestBody BizCommonParams<UpdateProjectStateRequest> updateProjectStateRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + UPDATE_STATE_URL, updateProjectStateRequest, new BizCommonModel<UpdateProjectStateResponse>(), false);
    }
    /**
     * @author Created by ivan on 下午6:23 18-11-23.
     * <p>批量更新第三方项目状态</p>
     * @param updateProjectStateBatchRequest :
     * @param signKey : 
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.UpdateProjectStateBatchResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "批量更新第三方项目状态", notes = "批量更新第三方项目状态")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/updateThirdProjectStateByBatch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<UpdateProjectStateBatchResponse> updateThirdProjectStateByBatch(@ApiParam(value = "批量更新第三方项目状态参数") @RequestBody BizCommonParams<UpdateProjectStateBatchRequest> updateProjectStateBatchRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.postRequest(fbtConfig.getBaseUrl() + UPDATE_STATE_BATCH_URL, updateProjectStateBatchRequest, new BizCommonModel<UpdateProjectStateBatchResponse>(), false);
    }
    /**
     * @author Created by ivan on 下午6:23 18-11-23.
     * <p>查询第三方项目详情</p>
     * @param getProjectRequest :
     * @param signKey : 
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.GetProjectResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "查询第三方项目详情", notes = "查询第三方项目详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/getThirdProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<GetProjectResponse> getThirdProject(@ApiParam(value = "查询第三方项目详情参数", type = "form") @RequestBody BizCommonParams<GetProjectRequest> getProjectRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.getByPostRequest(fbtConfig.getBaseUrl() + GET_URL, getProjectRequest, new BizCommonModel<GetProjectResponse>(), null);
    }
    /**
     * @author Created by ivan on 下午6:24 18-11-23.
     * <p>查询第三方项目列表</p>
     * @param queryProjectRequest :
     * @param signKey : 
     * @return com.fenbeitong.openapitest.models.BizCommonModel<com.fenbeitong.openapitest.models.project.QueryProjectResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "查询第三方项目列表", notes = "查询第三方项目列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/queryThirdProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<QueryProjectResponse> queryThirdProject(@ApiParam(value = "查询第三方项目列表参数", type = "form") @RequestBody BizCommonParams<QueryProjectRequest> queryProjectRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return apiCaller.getByPostRequest(fbtConfig.getBaseUrl() + QUERY_URL, queryProjectRequest, new BizCommonModel<GetProjectResponse>(), null);
    }
    /**
     * @author Created by ivan on 下午6:24 18-11-23.
     * <p>查询第三方项目列表(APP)</p>
     * @param queryProjectAppRequest :
     * @param signKey : 
     * @return com.fenbeitong.openapitest.models.BizCommonList<com.fenbeitong.openapitest.models.project.QueryProjectAppResponse>
     **/
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "查询第三方项目列表(APP)", notes = "查询第三方项目列表(APP)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/queryThirdProjectApp", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonList<QueryProjectAppResponse> queryThirdProjectApp(@ApiParam(value = "查询第三方项目列表参数", type = "form") @RequestBody BizCommonParams<QueryProjectAppRequest> queryProjectAppRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        return  apiCaller.getListByPostRequest(fbtConfig.getBaseUrl() + QUERY_APP_URL, queryProjectAppRequest, new BizCommonList<QueryProjectAppResponse>(), null);
    }
}
