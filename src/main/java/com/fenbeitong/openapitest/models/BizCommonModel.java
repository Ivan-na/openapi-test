package com.fenbeitong.openapitest.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * BizCommonModel
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-21 - 下午4:31.
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class BizCommonModel<T> extends CommonModel<T> {
    @ApiModelProperty(value = "内部记录ID", required = false)
    private String request_id;
    @ApiModelProperty(value = "响应代码", required = false)
    private String code;
    @ApiModelProperty(value = "响应信息", required = false)
    private String msg;
    @ApiModelProperty(value = "结果数据", required = false)
    private T data;
}
