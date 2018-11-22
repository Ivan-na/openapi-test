package com.fenbeitong.openapitest.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * CommonParam
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-21 - 下午4:35.
 **/
@Data
public class CommonParam<T> {
    @ApiModelProperty(value = "权限Token", required = false)
    private String access_token;
    @ApiModelProperty(value = "签名", required = false)
    private String sign;
    @ApiModelProperty(value = "时间戳", required = false)
    private Long timestamp;
    @ApiModelProperty(value = "请求人ID", required = false)
    private String employee_id;
    @ApiModelProperty(value = "请求人类型", required = false)
    private String employee_type;
}
