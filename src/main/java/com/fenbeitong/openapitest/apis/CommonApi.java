package com.fenbeitong.openapitest.apis;

import com.fenbeitong.openapitest.caller.ApiCaller;
import com.fenbeitong.openapitest.config.FbtConfig;
import com.fenbeitong.openapitest.dao.CityInfoDao;
import com.fenbeitong.openapitest.models.BizCommonList;
import com.fenbeitong.openapitest.models.BizCommonModel;
import com.fenbeitong.openapitest.models.common.QueryAirInfoResponse;
import com.fenbeitong.openapitest.models.common.QueryCityInfoResponse;
import com.fenbeitong.openapitest.params.BizCommonParams;
import com.fenbeitong.openapitest.params.common.QueryCityInfoRequest;
import com.google.gson.Gson;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * CommonApi
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-12-4 - 上午10:40.
 **/
@RestController
@Api(value = "公用接口", tags = "公用接口")
public class CommonApi {
    private static final String CREATE_URL = "/open/api/common/city-code";

    private FbtConfig fbtConfig;
    private ApiCaller apiCaller;
    private CityInfoDao cityInfoDao;

    @Autowired
    public CommonApi(ApiCaller apiCaller, FbtConfig fbtConfig,CityInfoDao cityInfoDao) {
        this.apiCaller = apiCaller;
        this.fbtConfig = fbtConfig;
        this.cityInfoDao = cityInfoDao;
    }


    @SuppressWarnings("unchecked")
    @ApiOperation(value = "查询城市列表", notes = "查询城市列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/queryCityInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonList<QueryCityInfoResponse> queryCityInfo(@ApiParam(value = "查询城列表参数") @RequestBody BizCommonParams<QueryCityInfoRequest> queryCityInfoRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        BizCommonList<QueryCityInfoResponse> response = apiCaller.getListByPostRequest(fbtConfig.getBaseUrl() + CREATE_URL, queryCityInfoRequest, new QueryCityInfoResponse(), null);
        List<QueryCityInfoResponse> result = response.getData();
        result = cityInfoDao.saveAll(result);
        return response;
    }

    @SuppressWarnings("unchecked")
    @ApiOperation(value = "查询城市机场列表", notes = "查询城市机场列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "signKey", value = "签名密钥", required = false)
    })
    @PostMapping(value = "/queryAirInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BizCommonModel<QueryAirInfoResponse> queryAirInfo(@ApiParam(value = "查询城市机场列表参数") @RequestBody BizCommonParams<QueryCityInfoRequest> queryCityInfoRequest, String signKey) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(signKey)) {
            apiCaller.setSignKey(signKey);
        } else {
            apiCaller.setSignKey(fbtConfig.getSignKey());
        }
        BizCommonModel<QueryAirInfoResponse> response = apiCaller.getByPostRequest(fbtConfig.getBaseUrl() + CREATE_URL, queryCityInfoRequest, new QueryAirInfoResponse(), null);


        QueryAirInfoResponse r = response.getData();
        List<QueryAirInfoResponse.CitiesBean> cb = r.getCities();
        for(QueryAirInfoResponse.CitiesBean ccb : cb){
            List<QueryAirInfoResponse.CitiesBean.StationListBean> qcsl = ccb.getStationList();
            for(QueryAirInfoResponse.CitiesBean.StationListBean qcs:qcsl){
                System.out.println(qcs.toString());
            }
        }
        return response;
    }


}
