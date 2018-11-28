package com.fenbeitong.openapitest.params.project;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * UpdateStateRequest
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-23 - 下午4:55.
 **/
@Data
public class UpdateProjectStateRequest {

    /**
     * id : 5bea7d0737c755266ca5b75b
     * thirdCostId :
     * state : 1
     */
    @ApiModelProperty(value = "", example = "", required = false)
    private String id;
    @ApiModelProperty(value = "第三方项目ID", example = "THIRD-M-5253", required = false)
    private String thirdCostId;
    @ApiModelProperty(value = "项目状态，0停用 1启用", example = "1", required = true)
    private Integer state;
    @ApiModelProperty(value = "企业ID", example = "5747fbc10f0e60e0709d8d7d", required = true)
    private Integer companyId;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
