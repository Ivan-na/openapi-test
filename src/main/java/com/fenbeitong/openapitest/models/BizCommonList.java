package com.fenbeitong.openapitest.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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


    @SuppressWarnings("rawtypes")
    public static BizCommonList fromJson(String json, Class clazz) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Type objectType = type(BizCommonList.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public String toJson(Class<T> clazz) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Type objectType = type(BizCommonList.class, clazz);
        return gson.toJson(this, objectType);
    }

    @SuppressWarnings("rawtypes")
    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            @Override
            public Type getRawType() {
                return raw;
            }

            @Override
            public Type[] getActualTypeArguments() {
                return args;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }
}
