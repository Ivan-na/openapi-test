package com.fenbeitong.openapitest.params.project;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * CreateBatchRequest
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-23 - 下午5:20.
 **/
@Data
public class CreateProjectBatchRequest {
    /**
     * companyId : 5afa956523445f22dd043d8a
     * userId : 5afa956523445f22dd043d8b
     * autoFlag : 2
     * costCenterNum : 100
     * projectInfo : [{"code":"23648235","name":"灭世、霸者","thirdCostId":"123123"},{"code":"23648236","name":"蔑视、霸者","thirdCostId":"1234121"}]
     */

    @ApiModelProperty(value = "企业ID", example = "5747fbc10f0e60e0709d8d7d", required = false)
    private String companyId;
    @ApiModelProperty(value = "用户ID", example = "59bf74f423445f31bd64bc5c", required = false)
    private String userId;
    @ApiModelProperty(value = "自动生成", example = "1", required = false)
    private Integer autoFlag;
    @ApiModelProperty(value = "自动生成传数量 手动生成传projectInfo", example = "100", required = false)
    private Integer costCenterNum;
    @ApiModelProperty(value = "项目信息", example = "", required = false)
    private List<ProjectInfoBean> projectInfo;
    @Data
    private static class ProjectInfoBean {
        /**
         * code : 23648235
         * name : 灭世、霸者
         * thirdCostId : 123123
         */

        @ApiModelProperty(value = "项目编号", example = "FBT123456789", required = false)
        private String code;
        @ApiModelProperty(value = "项目名称", example = "项目MC", required = false)
        private String name;
        @ApiModelProperty(value = "第三方项目ID", example = "THIRD-T-5253", required = false)
        private String thirdCostId;

    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
