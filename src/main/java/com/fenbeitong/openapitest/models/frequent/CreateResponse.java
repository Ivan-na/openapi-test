package com.fenbeitong.openapitest.models.frequent;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * CreateResponse
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-22 - 下午5:51.
 **/
@Data
public class CreateResponse {
    @ApiModelProperty(value = "分贝员工ID", required = true)
    private String employee_id;
}
