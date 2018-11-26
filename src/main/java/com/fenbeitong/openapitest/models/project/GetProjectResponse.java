package com.fenbeitong.openapitest.models.project;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * GetResponse
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-23 - 下午5:27.
 **/
public class GetProjectResponse {
    /**
     * beginDate : 1970-01-01 00:00:00
     * code : 987197917293
     * endDate : 1970-01-01 00:00:00
     * expiredState : {"key":2,"value":"过期自动停用"}
     * manager : [{"companyId":"5747fbc10f0e60e0709d8d7d","deptName":"北京分贝金服科技有限公司","memberId":"59e46b8323445f28f203fb8e","memberName":"许你一世繁华","memberType":2},{"companyId":"5747fbc10f0e60e0709d8d7d","memberId":"123917239715","memberName":"王霸天下","deptName":"","memberType":2}]
     * member : [{"companyId":"5747fbc10f0e60e0709d8d7d","memberId":"123917239717","memberName":"李小四","deptName":""},{"companyId":"5747fbc10f0e60e0709d8d7d","memberId":"123917239718","memberName":"张小三","deptName":""}]
     * memberDept : [{"memberId":"123917239717","memberName":"研发部"},{"memberId":"123917239718","memberName":"研发部"}]
     * name : test
     * state : {"key":1,"value":"启用"}
     * usableRange : {"key":2,"value":"启用"}
     */

    @ApiModelProperty(value = "项目开始时间", example = "2018-03-20 10:00:00", required = false)
    private String beginDate;
    @ApiModelProperty(value = "项目编号", example = "FBT987197917293", required = false)
    private String code;
    @ApiModelProperty(value = "项目结束时间", example = "2018-03-21 10:00:00", required = false)
    private String endDate;
    @ApiModelProperty(value = "过期后是否自动停用 1：不停用 2：停", example = "1", required = false)
    private ExpiredStateBean expiredState;
    @ApiModelProperty(value = "项目名称", example = "项目名称", required = false)
    private String name;
    @ApiModelProperty(value = "项目状态 1启用 0停用", example = "1", required = false)
    private StateBean state;
    @ApiModelProperty(value = "使用范围    1不限2限制", example = "1", required = false)
    private UsableRangeBean usableRange;
    @ApiModelProperty(value = "负责人", example = "", required = false)
    private List<ManagerBean> manager;
    @ApiModelProperty(value = "成员(人)", example = "", required = false)
    private List<MemberBean> member;
    @ApiModelProperty(value = "成员（部门）", example = "", required = false)
    private List<MemberDeptBean> memberDept;

    public static class ExpiredStateBean {
        /**
         * key : 2
         * value : 过期自动停用
         */

        @ApiModelProperty(value = "值", example = "1", required = false)
        private int key;
        @ApiModelProperty(value = "名称", example = "不停用", required = false)
        private String value;

    }

    public static class StateBean {
        /**
         * key : 1
         * value : 启用
         */

        @ApiModelProperty(value = "值", example = "1", required = false)
        private int key;
        @ApiModelProperty(value = "名称", example = "启用", required = false)
        private String value;

    }

    public static class UsableRangeBean {
        /**
         * key : 2
         * value : 1不限2限制
         */

        @ApiModelProperty(value = "值", example = "1", required = false)
        private int key;
        @ApiModelProperty(value = "名称", example = "不限制", required = false)
        private String value;


    }

    public static class ManagerBean {
        /**
         * companyId : 5747fbc10f0e60e0709d8d7d
         * deptName : 北京分贝金服科技有限公司
         * memberId : 59e46b8323445f28f203fb8e
         * memberName : 许你一世繁华
         * memberType : 2
         */

        @ApiModelProperty(value = "企业ID", example = "5747fbc10f0e60e0709d8d7d", required = false)
        private String companyId;
        @ApiModelProperty(value = "部门名称", example = "未来科技部", required = false)
        private String deptName;
        @ApiModelProperty(value = "人员ID", example = "59bf74f423445f31bd64bc5c", required = false)
        private String memberId;
        @ApiModelProperty(value = "人员姓名", example = "胡汉三", required = false)
        private String memberName;
        @ApiModelProperty(value = "人员类型 2是部门3是员工", example = "3", required = false)
        private int memberType;


    }

    public static class MemberBean {
        /**
         * companyId : 5747fbc10f0e60e0709d8d7d
         * memberId : 123917239717
         * memberName : 李小四
         * deptName :
         */

        @ApiModelProperty(value = "企业ID", example = "5747fbc10f0e60e0709d8d7d", required = false)
        private String companyId;
        @ApiModelProperty(value = "人员ID", example = "", required = false)
        private String memberId;
        @ApiModelProperty(value = "人员姓名", example = "尼古拉斯", required = false)
        private String memberName;
        @ApiModelProperty(value = "部门名称", example = "研发部", required = false)
        private String deptName;


    }

    public static class MemberDeptBean {
        /**
         * memberId : 123917239717
         * memberName : 研发部
         */

        @ApiModelProperty(value = "部门ID", example = "", required = false)
        private String memberId;
        @ApiModelProperty(value = "部门名称", example = "研发部", required = false)
        private String memberName;


    }
}
