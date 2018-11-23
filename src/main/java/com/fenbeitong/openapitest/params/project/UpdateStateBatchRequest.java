package com.fenbeitong.openapitest.params.project;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * UpdateStateBatchRequest
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-23 - 下午4:59.
 **/
@Data
public class UpdateStateBatchRequest {
    /**
     * state : 0
     * idType : 1
     * idList : ["12341234","21234324"]
     */
    @ApiModelProperty(value = "0停用 1启用", example = "1", required = false)
    private int state;
    @ApiModelProperty(value = "自建Id 1，第三方Id 2", example = "2", required = false)
    private int idType;
    @ApiModelProperty(value = "项目ID", example = "THIRD-M-5253", required = false)
    private List<String> idList;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
