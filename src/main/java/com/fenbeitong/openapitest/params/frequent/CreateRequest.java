package com.fenbeitong.openapitest.params.frequent;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * createResponse
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-22 - 下午5:28.
 **/
@Data
public class CreateRequest {
    /**
     "birthDate": "1990-02-02",
     "category": 40,
     "certValidDate": "2017-02-01",
     "companyId": "5747fbc10f0e60e0709d8d7d",
     "email": "shuqi.han@fenbeitong.com",
     "employeeFlag": true,
     "familyName": "dave",
     "frequentType": 2,
     "gender": 1,
     "givenName": "hansins",
     "idNumber": "2305434",
     "idType": 2,
     "name": "韩树起-企业员工55",
     "nationality": "CN",
     "nationalityName": "中国",
     "ownerId": "hanshuqi-H5-dev",
     "phoneNum": "17800089098",
     "selectedEmployeeId": "hanshuqi-H5-dev",
     "thirdFrequentId": "4575798876576we7654",
     "type": 2,
     "useType": 1
     */

    @ApiModelProperty(value = "1:代表分贝公司, 2:代表第三方企业;  \n注: type=2时,代表所示字段均为第三方数据 ", required = true, example = "2")
    private int type;
    @ApiModelProperty(value = "可不传  \n但在查询联系人详情/修改/删除等操作时 需要根绝分贝联系人ID进行操作。不能重复", required = false, example = "4575798876576we7654")
    private String thirdFrequentId;
    @ApiModelProperty(value = "同行人姓名  \n当frequentType=1时  则必填", required = false, example = "韩树起-企业员工1")
    private String name;
    @ApiModelProperty(value = "1:男2:女  \n证件类型为非身份证 当idType为1时不需要传递，其他类型需要传递", required = false, example = "1")
    private int gender;
    @ApiModelProperty(value = "生日  \n证件类型为非身份证 当idType为1时不需要传递，其他类型需要传递", required = false, example = "1990-02-02")
    private String birthDate;
    @ApiModelProperty(value = "邮件", required = false, example = "shuqi.han@fenbeitong.com")
    private String email;
    @ApiModelProperty(value = "联系电话", required = true, example = "17800089098")
    private String phoneNum;
    @ApiModelProperty(value = "是否为员工  \n必填 ，如果是从组织架构入口进入则为true,反之则为false ", required = true, example = "true")
    private boolean employeeFlag;
    @ApiModelProperty(value = "同行人在组织架构的id ，当employeeFlag为false时，则可以不进行传递。为false时是从非组织架构选择添加的人员", required = false, example = "hanshuqi-H5-dev")
    private String selectedEmployeeId;
    @ApiModelProperty(value = "必填", required = true, example = "2305434")
    private String idNumber;
    @ApiModelProperty(value = "证件类型 1.身份证 2.护照 3.回乡证 4.台胞证 5.港澳通行证 6.大陆居民往来台湾通行证 必填", required = true, example = "2")
    private int idType;
    @ApiModelProperty(value = "当frequentType为1时，酒店:11, 其它:0,当frequentType为2时，国际机票传:40,  必填,根据业务类型进行相应参数校验，不进行实际业务处理", required = false, example = "40")
    private int category;
    @ApiModelProperty(value = "姓  \nfrequentType=2时必填，必须使用拼音或者英文", required = false, example = "dave")
    private String familyName;
    @ApiModelProperty(value = "名  \nfrequentType=2时必填，必须使用拼音或者英文", required = false, example = "hansins")
    private String givenName;
    @ApiModelProperty(value = "证书有效期  \nfrequentType=2时必填", required = false, example = "2017-02-01")
    private String certValidDate;
    @ApiModelProperty(value = "国籍 CN  \nfrequentType=2时必填", required = false, example = "CN")
    private String nationality;
    @ApiModelProperty(value = "国籍名称 中国", required = false, example = "中国")
    private String nationalityName;
    @ApiModelProperty(value = "1:国内 2:国际  \n必填 默认是1", required = true, example = "2")
    private int frequentType;
    @ApiModelProperty(value = "必填", required = true, example = "5747fbc10f0e60e0709d8d7d")
    private String companyId;
    @ApiModelProperty(value = "当前登录用户ID 必填，为第三方用户ID", required = true, example = "hanshuqi-H5-dev")
    private String ownerId;
    @ApiModelProperty(value = "1：因公  \n必填", required = true, example = "1")
    private int useType;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
