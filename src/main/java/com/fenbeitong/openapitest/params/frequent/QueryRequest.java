package com.fenbeitong.openapitest.params.frequent;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * QueryRequest
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-22 - 下午6:38.s
 **/
@Data
public class QueryRequest {
    @ApiModelProperty(value = "企业ID", example = "5ab5bf092bfe67c7b6bfb241", required = true)
    private String companyId;
    @ApiModelProperty(value = "当前登录用户ID", example = "5ab5bf092bfe67c7b6bfb241", required = true)
    private String ownerId;
    @ApiModelProperty(value = "员工ID  当前组织架构员工ID（type为1必填)", example = "000001", required = true)
    private String selectedEmployeeId;
    @ApiModelProperty(value = "类型    1:分贝企业    2:第三方企业", example = "1", required = true)
    private String type;
    @ApiModelProperty(value = "1：国内   2：国际   不传默认1", example = "1", required = true)
    private String frequentType;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
