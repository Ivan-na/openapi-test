package com.fenbeitong.openapitest.params.project;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * CreateRequest
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-23 - 下午4:08.
 **/
@Data
public class CreateRequest {
    /**
     * companyId : ding7e3a8c59b822c6d835c2f4657eb6378f
     * userId : 5a66b2c123445f2417491299
     * thirdCostId : 5a66b2c123445f2417491299
     * code : FBT987197917293
     * name : test
     * description : test
     * beginDate : 2018-03-20 10:00:00
     * endDate : 2018-03-21 10:00:00
     * expiredState : 1
     * usableRange : 1
     * state : 1
     * manager : [{"memberId":"123917239715","memberName":"zhangsan","isManager":true,"memberType":2},{"memberId":"123917239716","memberName":"lisi","isManager":true}]
     * member : [{"memberId":"123917239717","memberName":"李四","isManager":false},{"memberId":"123917239718","memberName":"张三","isManager":false}]
     * memberDept : [{"memberId":"123917239717","memberName":"研发部","isManager":false},{"memberId":"123917239718","memberName":"研发部","isManager":false}]
     */

    @ApiModelProperty(value = "企业ID", example = "5747fbc10f0e60e0709d8d7d", required = false)
    private String companyId;
    @ApiModelProperty(value = "", example = "", required = false)
    private String userId;
    @ApiModelProperty(value = "第三方项目ID", example = "THIRD-M-5253", required = false)
    private String thirdCostId;
    @ApiModelProperty(value = "项目编号", example = "FBT987197917293", required = false)
    private String code;
    @ApiModelProperty(value = "项目名称", example = "项目名称", required = false)
    private String name;
    @ApiModelProperty(value = "项目描述", example = "项目描述", required = false)
    private String description;
    @ApiModelProperty(value = "项目开始时间", example = "2018-03-20 10:00:00", required = false)
    private String beginDate;
    @ApiModelProperty(value = "项目结束时间", example = "2018-03-21 10:00:00", required = false)
    private String endDate;
    @ApiModelProperty(value = "过期后是否自动停用 1：不停用 2：停", example = "1", required = false)
    private int expiredState;
    @ApiModelProperty(value = "使用范围    1不限2限制", example = "1", required = false)
    private int usableRange;
    @ApiModelProperty(value = "项目状态 1启用 0停用", example = "1", required = false)
    private int state;
    @ApiModelProperty(value = "负责人", example = "", required = false)
    private List<ManagerBean> manager;
    @ApiModelProperty(value = "成员(人)", example = "", required = false)
    private List<MemberBean> member;
    @ApiModelProperty(value = "成员（部门）", example = "", required = false)
    private List<MemberDeptBean> memberDept;

    @Data
    public static class ManagerBean {
        /**
         * memberId : 123917239715
         * memberName : zhangsan
         * isManager : true
         * memberType : 2
         */
        @ApiModelProperty(value = "ID", example = "59bf74f423445f31bd64bc5c", required = false)
        private String memberId;
        @ApiModelProperty(value = "姓名", example = "胡汉三", required = false)
        private String memberName;
        @ApiModelProperty(value = "是否负责人", example = "true", required = false)
        private boolean isManager;
        @ApiModelProperty(value = "2是部门3是员工", example = "3", required = false)
        private int memberType;
    }
    @Data
    public static class MemberBean {
        /**
         * memberId : 123917239717
         * memberName : 李四
         * isManager : false
         */
        @ApiModelProperty(value = "ID", example = "", required = false)
        private String memberId;
        @ApiModelProperty(value = "姓名", example = "尼古拉斯。Cage", required = false)
        private String memberName;
        @ApiModelProperty(value = "是否负责人", example = "false", required = false)
        private boolean isManager;
    }
    @Data
    public static class MemberDeptBean {
        /**
         * memberId : 123917239717
         * memberName : 研发部
         * isManager : false
         */
        @ApiModelProperty(value = "ID", example = "", required = false)
        private String memberId;
        @ApiModelProperty(value = "姓名", example = "未来科技部", required = false)
        private String memberName;
        @ApiModelProperty(value = "是否负责人", example = "false", required = false)
        private boolean isManager;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
