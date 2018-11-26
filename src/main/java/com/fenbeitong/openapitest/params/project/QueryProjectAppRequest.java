package com.fenbeitong.openapitest.params.project;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * QueryAppRequest
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-23 - 下午5:35.
 **/
@Data
public class QueryProjectAppRequest {
    @ApiModelProperty(value = "页数", example = "1", required = false)
    private Integer pageIndex;
    @ApiModelProperty(value = "每页条数", example = "20", required = false)
    private Integer pageSize;
    @ApiModelProperty(value = "项目状态", example = "1", required = false)
    private Integer state;
    @ApiModelProperty(value = "第三方企业ID", example = "5747fbc10f0e60e0709d8d7d", required = false)
    private String companyId;
    @ApiModelProperty(value = "用户ID", example = "59bf74f423445f31bd64bc5c", required = false)
    private String userId;
    @ApiModelProperty(value = "模糊查询条件，参数示意包括项目名称、编码、负责人", example = "", required = false)
    private String unknown;
    @ApiModelProperty(value = "可看范围", example = "0:所有项目 1:仅用户自己可看项目", required = false)
    private String seeRange;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
