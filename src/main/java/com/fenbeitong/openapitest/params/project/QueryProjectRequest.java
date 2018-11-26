package com.fenbeitong.openapitest.params.project;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * QueryRequest
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-23 - 下午5:01.
 **/
@Data
public class QueryProjectRequest {
    @ApiModelProperty(value = "项目编码", example = "FBT987197917293", required = false)
    private String code;
    @ApiModelProperty(value = "项目名称", example = "项目名称", required = false)
    private String name;
    @ApiModelProperty(value = "负责人姓名", example = "胡汉三", required = false)
    private String memberName;
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

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
