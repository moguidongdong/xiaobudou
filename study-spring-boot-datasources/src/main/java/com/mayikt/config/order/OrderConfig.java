package com.mayikt.config.order;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.datasource.order")
public class OrderConfig {
    private String jdbcUrl;
    private String username;
    private String password;
    private String driverClassName;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private int maxLifetime;
    private int maxPoolSize;
    private int minPoolSize;
    private String uniqueResourceName;
    private String testQuery;
}
