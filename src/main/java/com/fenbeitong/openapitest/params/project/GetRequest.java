package com.fenbeitong.openapitest.params.project;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * GetRequest
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-23 - 下午5:25.
 **/
@Data
public class GetRequest {
    @ApiModelProperty(value = "项目ID", example = "", required = false)
    private String id;
    @ApiModelProperty(value = "第三方项目ID", example = "THIRD-M-5253", required = false)
    private String thirdCostId;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
