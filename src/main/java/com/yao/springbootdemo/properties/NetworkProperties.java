package com.yao.springbootdemo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>NetworkProperties 网络配置类
 * <p>
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/21 12:52
 */
@Component
@ConfigurationProperties(prefix = "network")
@Data
public class NetworkProperties {

    private String host;
    private Integer port;

    @Override
    public String toString() {
        return "NetworkProperties{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
