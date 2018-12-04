package com.fenbeitong.openapitest.params.common;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * QueryCityInfo
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-12-4 - 上午10:30.
 **/
@Data
public class QueryCityInfoRequest {
    @ApiModelProperty(value = "业务类型", example = "6", required = true)
    private String type;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
