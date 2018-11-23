package com.fenbeitong.openapitest.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * BizCommonList
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-22 - 下午7:17.
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BizCommonList<T> extends CommonModel<T> {
    @ApiModelProperty(value = "内部记录ID")
    private String request_id;
    @ApiModelProperty(value = "响应代码")
    private String code;
    @ApiModelProperty(value = "响应类型")
    private String type;
    @ApiModelProperty(value = "响应信息")
    private String msg;
    @ApiModelProperty(value = "结果数据列表")
    private List<T> data;
}
