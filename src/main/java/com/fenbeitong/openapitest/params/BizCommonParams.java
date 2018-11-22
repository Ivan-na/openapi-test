package com.fenbeitong.openapitest.params;


import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * BizCommonParams
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-21 - 下午4:36.
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BizCommonParams<T> extends CommonParam<T> {
    private String request_id;
    private T data;

    public String toJsonDataWithLowerCase() {
        Gson gson = new Gson();
        return gson.toJson(this.getData(), data.getClass());
    }
}
