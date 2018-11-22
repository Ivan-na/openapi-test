package com.fenbeitong.openapitest.params.frequent;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * DeleteRequest
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-22 - 下午6:32.
 **/
@Data
public class DeleteRequest {
    /**
     * frequentIdType : 1
     * idList : ["5820915c5f281a38552d6129","582192e95f281a0364465210"]
     * type : 1
     * companyId : 111111
     * ownerId : 111111
     */

    @ApiModelProperty(value = "1：根据分贝联系人ID 进行删除   2：根据第三方联系人ID删除  必填", example = "1", required = true)
    private int frequentIdType;
    @ApiModelProperty(value = "frequentIdType = 2时 必填  \ntype = 1 时  代表companyId  ownerId 为分贝企业数据 type = 2 时  代表companyId  ownerId 为第三方企业对应数据 ", example = "1", required = false)
    private int type;
    @ApiModelProperty(value = "frequentIdType = 2时 必填 ", example = "1111", required = false)
    private String companyId;
    @ApiModelProperty(value = "frequentIdType = 2时 必填 ", example = "1111", required = false)
    private String ownerId;
    @ApiModelProperty(value = "必填", example = "", required = true)
    private List<String> idList;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
