package com.fenbeitong.openapitest.config;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * FbtConfig
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-22 - 下午3:59.
 **/
@SpringBootConfiguration
@ConfigurationProperties(prefix = "fbt")
@Data
public class FbtConfig {
    private String baseUrl;
    private String appId;
    private String appKey;
    private String appType;
    private String employeeId;
    private String signKey;
}
