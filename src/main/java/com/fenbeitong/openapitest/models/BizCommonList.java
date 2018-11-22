package com.fenbeitong.openapitest.models;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * BizCommonList
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-22 - 下午7:17.
 **/
public class BizCommonList<T> extends CommonModel<T> {
    @ApiModelProperty(value = "内部记录ID", required = false)
    private String request_id;
    @ApiModelProperty(value = "响应代码", required = false)
    private String code;
    @ApiModelProperty(value = "响应类型", required = false)
    private String type;
    @ApiModelProperty(value = "响应信息", required = false)
    private String msg;
    @ApiModelProperty(value = "结果数据列表", required = false)
    private List<T> data;
}
