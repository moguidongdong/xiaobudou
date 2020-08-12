package com.mayikt;

import com.mayikt.config.member.MemberConfig;
import com.mayikt.config.order.OrderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties({MemberConfig.class, OrderConfig.class})
public class DataSourcesApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataSourcesApplication.class);
    }
}
