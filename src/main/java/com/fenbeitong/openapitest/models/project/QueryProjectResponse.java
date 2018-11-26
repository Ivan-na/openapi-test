package com.fenbeitong.openapitest.models.project;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * QueryResponse
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-23 - 下午5:07.
 **/
@Data
public class QueryProjectResponse {
    /**
     * count : 8
     * data : [{"code":"723972934","name":"test","beginDate":"2018-03-20 10:10:00","end_date":"2018-03-21 10:10:00","memberName":"","usableRange":{"key":1,"value":"不限"},"state":{"key":1,"value":"启用"}},{"code":"723972934","name":"test","beginDate":"2018-03-20 10:10:00","endDate":"2018-03-21 10:10:00","memberName":"","usableRange":{"key":1,"value":"不限"},"state":{"key":1,"value":"启用"}}]
     * pSize : 20
     * page : 1
     */
    @ApiModelProperty(value = "总数", example = "8", required = false)
    private int count;
    @ApiModelProperty(value = "每页数量", example = "10", required = false)
    private int pSize;
    @ApiModelProperty(value = "当前页数", example = "1", required = false)
    private int page;
    @ApiModelProperty(value = "响应信息", example = "", required = false)
    private List<DataBean> data;

    @Data
    public static class DataBean {
        /**
         * code : 723972934
         * name : test
         * beginDate : 2018-03-20 10:10:00
         * end_date : 2018-03-21 10:10:00
         * memberName :
         * usableRange : {"key":1,"value":"不限"}
         * state : {"key":1,"value":"启用"}
         * endDate : 2018-03-21 10:10:00
         */

        @ApiModelProperty(value = "项目编码", example = "", required = false)
        private String code;
        @ApiModelProperty(value = "项目名称", example = "", required = false)
        private String name;
        @ApiModelProperty(value = "项目开始时间", example = "", required = false)
        private String beginDate;
        @ApiModelProperty(value = "项目结束时间", example = "", required = false)
        private String endDate;
        @ApiModelProperty(value = "", example = "", required = false)
        private String memberName;
        @ApiModelProperty(value = "1：不限，2：仅项目成员", example = "1", required = false)
        private UsableRangeBean usableRange;
        @ApiModelProperty(value = "项目状态 0停用 1启用", example = "1", required = false)
        private StateBean state;

        @Data
        static class UsableRangeBean {
            /**
             * key : 1
             * value : 不限
             */

            @ApiModelProperty(value = "代码", example = "1", required = false)
            private int key;
            @ApiModelProperty(value = "名称", example = "不限", required = false)
            private String value;
        }
        @Data
        static class StateBean {
            /**
             * key : 1
             * value : 启用
             */
            @ApiModelProperty(value = "代码", example = "1", required = false)
            private int key;
            @ApiModelProperty(value = "名称", example = "启用", required = false)
            private String value;
        }
    }
}
