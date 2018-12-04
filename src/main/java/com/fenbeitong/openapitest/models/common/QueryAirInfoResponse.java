package com.fenbeitong.openapitest.models.common;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * QueryAirInfoResponse
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-12-4 - 下午3:50.
 **/
public class QueryAirInfoResponse {

    @ApiModelProperty(value = "城市列表", example = "", required = false)
    private List<CitiesBean> cities;
    @ApiModelProperty(value = "热门城市", example = "", required = false)
    private List<HotBean> hot;

    public List<CitiesBean> getCities() {
        return cities;
    }

    public void setCities(List<CitiesBean> cities) {
        this.cities = cities;
    }

    public List<HotBean> getHot() {
        return hot;
    }

    public void setHot(List<HotBean> hot) {
        this.hot = hot;
    }

    public static class CitiesBean {
        /**
         * id : 111111
         * name : 遵义茅台
         * pinyin : zun yi mao tai
         * description : 遵义茅台
         * station_list : [{"name":"茅台机场","code":"WMT"}]
         * cr_code : CN
         */

        @ApiModelProperty(value = "城市ID", example = "", required = false)
        private String id;
        @ApiModelProperty(value = "城市名称", example = "", required = false)
        private String name;
        @ApiModelProperty(value = "城市拼音", example = "", required = false)
        private String pinyin;
        @ApiModelProperty(value = "城市描述", example = "", required = false)
        private String description;
        @ApiModelProperty(value = "CR-CODE", example = "", required = false)
        private String crCode;
        @ApiModelProperty(value = "站点列表", example = "", required = false)
        private List<StationListBean> stationList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCrCode() {
            return crCode;
        }

        public void setCrCode(String crCode) {
            this.crCode = crCode;
        }

        public List<StationListBean> getStationList() {
            return stationList;
        }

        public void setStationList(List<StationListBean> stationList) {
            this.stationList = stationList;
        }

        public static class StationListBean {
            /**
             * name : 茅台机场
             * code : WMT
             */

            @ApiModelProperty(value = "机场名称", example = "", required = false)
            private String name;
            @ApiModelProperty(value = "机场编码", example = "", required = false)
            private String code;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }
    }

    public static class HotBean {
        /**
         * id : 1000001
         * name : 北京市
         * pinyin : bei jing shi
         * description : 北京市
         * station_list : [{"name":"首都机场","code":"PEK"},{"name":"南苑机场","code":"NAY"}]
         * cr_code : CN
         */

        @ApiModelProperty(value = "城市编码", example = "", required = false)
        private String id;
        @ApiModelProperty(value = "城市名称", example = "", required = false)
        private String name;
        @ApiModelProperty(value = "城市拼音", example = "", required = false)
        private String pinyin;
        @ApiModelProperty(value = "城市描述", example = "", required = false)
        private String description;
        @ApiModelProperty(value = "CR-CODE", example = "", required = false)
        private String crCode;
        @ApiModelProperty(value = "站点列表", example = "", required = false)
        private List<StationListBeanX> stationList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCrCode() {
            return crCode;
        }

        public void setCrCode(String crCode) {
            this.crCode = crCode;
        }

        public List<StationListBeanX> getStationList() {
            return stationList;
        }

        public void setStationList(List<StationListBeanX> stationList) {
            this.stationList = stationList;
        }

        public static class StationListBeanX {
            /**
             * name : 首都机场
             * code : PEK
             */

            @ApiModelProperty(value = "机场名称", example = "", required = false)
            private String name;
            @ApiModelProperty(value = "机场编码", example = "", required = false)
            private String code;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }
    }
}
