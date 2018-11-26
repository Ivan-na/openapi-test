package com.fenbeitong.openapitest.models.project;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * QueryAppResponse
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-23 - 下午5:38.
 **/
@Data
public class QueryProjectAppResponse {
    /**
     * thirdCostId : 1231231
     * code : 723972934
     * name : test
     * beginDate : 2018-03-20 10:10:00
     * endDate : 2018-03-21 10:10:00
     * memberName :
     * usableRange : {"key":1,"value":"不限"}
     * state : {"key":1,"value":"启用"}
     */

    @ApiModelProperty(value = "", example = "", required = false)
    private String thirdCostId;
    @ApiModelProperty(value = "项目编号", example = "FBT987197917293", required = false)
    private String code;
    @ApiModelProperty(value = "项目名称", example = "项目名称", required = false)
    private String name;
    @ApiModelProperty(value = "项目开始时间", example = "2018-03-20 10:00:00", required = false)
    private String beginDate;
    @ApiModelProperty(value = "项目结束时间", example = "2018-03-21 10:00:00", required = false)
    private String endDate;
    @ApiModelProperty(value = "负责人", example = "", required = false)
    private String memberName;
    @ApiModelProperty(value = "使用范围    1不限2限制", example = "1", required = false)
    private UsableRangeBean usableRange;
    @ApiModelProperty(value = "项目状态 1启用 0停用", example = "1", required = false)
    private StateBean state;

    @Data
    private static class UsableRangeBean {
        /**
         * key : 1
         * value : 不限
         */

        @ApiModelProperty(value = "值", example = "1", required = false)
        private int key;
        @ApiModelProperty(value = "名称", example = "不限制", required = false)
        private String value;


    }
    @Data
    private static class StateBean {
        /**
         * key : 1
         * value : 启用
         */

        @ApiModelProperty(value = "值", example = "1", required = false)
        private int key;
        @ApiModelProperty(value = "名称", example = "启用", required = false)
        private String value;

    }
}
