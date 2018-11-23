package com.fenbeitong.openapitest.models.frequent;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * UpdateResponse
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-22 - 下午6:20.
 **/
@Data
public class UpdateFrequentResponse {
    @ApiModelProperty(value = "主键id", required = true)
    private String employee_id;
}
