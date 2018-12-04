package com.fenbeitong.openapitest.models.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * QueryCityInfoResponse
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-12-4 - 上午10:33.
 **/
@Data
@Entity
@Table(name="CITY_INFO")
public class QueryCityInfoResponse {
    /**
     * fullCityName : 南宁市,广西壮族自治区
     * self_city_code : 1715
     * city_name : 南宁市
     * pinyin : nanningshi
     * short_pinyin : nns
     * parent_id : 20
     * areaType : 2
     * city_code : 1715
     * sort : N
     * self_city_name : 南宁市
     * municipal_district_flag : false
     */

    @ApiModelProperty(value = "城市全称", example = "", required = false)
    @Column
    private String fullCityName;
    @ApiModelProperty(value = "自有城市代码", example = "", required = false)
    @Column
    private String selfCityCode;
    @ApiModelProperty(value = "城市名称", example = "", required = false)
    @Column
    private String cityName;
    @ApiModelProperty(value = "拼音名称", example = "", required = false)
    @Column
    private String pinyin;
    @ApiModelProperty(value = "拼音简称", example = "", required = false)
    @Column
    private String shortPinyin;
    @ApiModelProperty(value = "上级代码", example = "", required = false)
    @Column
    private String parentId;
    @ApiModelProperty(value = "地域类型", example = "", required = false)
    @Column
    private int areaType;
    @ApiModelProperty(value = "城市代码", example = "", required = false)
    @Id
    private String cityCode;
    @ApiModelProperty(value = "城市拼音", example = "", required = false)
    @Column
    private String sort;
    @ApiModelProperty(value = "自有城市名称", example = "", required = false)
    @Column
    private String selfCityName;
    @ApiModelProperty(value = "自治区", example = "", required = false)
    @Column
    private boolean municipalDistrictFlag;

    public String getFullCityName() {
        return fullCityName;
    }

    public void setFullCityName(String fullCityName) {
        this.fullCityName = fullCityName;
    }

    public String getSelfCityCode() {
        return selfCityCode;
    }

    public void setSelfCityCode(String selfCityCode) {
        this.selfCityCode = selfCityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getShortPinyin() {
        return shortPinyin;
    }

    public void setShortPinyin(String shortPinyin) {
        this.shortPinyin = shortPinyin;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getAreaType() {
        return areaType;
    }

    public void setAreaType(int areaType) {
        this.areaType = areaType;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSelfCityName() {
        return selfCityName;
    }

    public void setSelfCityName(String selfCityName) {
        this.selfCityName = selfCityName;
    }

    public boolean isMunicipalDistrictFlag() {
        return municipalDistrictFlag;
    }

    public void setMunicipalDistrictFlag(boolean municipalDistrictFlag) {
        this.municipalDistrictFlag = municipalDistrictFlag;
    }
}
