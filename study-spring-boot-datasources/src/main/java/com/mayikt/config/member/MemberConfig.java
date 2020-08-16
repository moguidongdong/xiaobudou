package com.mayikt.config.member;

import com.mayikt.Base.entity.BaseEntity;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource.member")
public class MemberConfig extends BaseEntity {

}
