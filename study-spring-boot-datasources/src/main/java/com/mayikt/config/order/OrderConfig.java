package com.mayikt.config.order;

import com.mayikt.Base.entity.BaseEntity;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource.order")
public class OrderConfig extends BaseEntity {


}
