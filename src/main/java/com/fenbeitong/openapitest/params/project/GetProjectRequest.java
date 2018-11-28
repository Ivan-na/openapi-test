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
public class GetProjectRequest {
    @ApiModelProperty(value = "项目ID", example = "", required = false)
    private String id;
    @ApiModelProperty(value = "第三方项目ID", example = "THIRD-M-5258", required = false)
    private String thirdCostId;
    @ApiModelProperty(value = "企业ID", example = "5747fbc10f0e60e0709d8d7d", required = false)
    private String companyId;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
