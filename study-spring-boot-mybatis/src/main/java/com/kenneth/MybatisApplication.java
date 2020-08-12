package com.kenneth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

import java.util.Collections;

@SpringBootApplication
@MapperScan("com.kenneth.ex.dao")
public class MybatisApplication implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class);
    }

    /**
     * 修改spring-boot默认端口的方法二
     *
     * @param factory
     */
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(8083);
//        factory.setAddress("");
    }


    /**
     * 修改spring-boot默认端口的方法一
     */
//    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(MybatisApplication.class);
//        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
//        app.run(args);
//    }

}
