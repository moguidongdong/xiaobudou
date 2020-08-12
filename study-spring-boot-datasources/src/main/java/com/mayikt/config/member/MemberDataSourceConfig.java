package com.mayikt.config.member;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.mayikt.member.tony.dao", sqlSessionTemplateRef = "memberSqlSessionTemplate")
public class MemberDataSourceConfig {

    //@Configuration  xml  MemberDataSourceConfig.xml

    /**
     * 创建 memberDataSource
     *
     * @return
     */
    @Bean("memberDataSource")
    public DataSource memberDataSource(MemberConfig memberConfig) throws SQLException {
        // 1、创建xaDataSource
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL(memberConfig.getJdbcUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setUser(memberConfig.getUsername());
        mysqlXADataSource.setPassword(memberConfig.getPassword());

        //注册到全局事务上
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName(memberConfig.getUniqueResourceName());
        xaDataSource.setMinPoolSize(memberConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(memberConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(memberConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(memberConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(memberConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(memberConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(memberConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(memberConfig.getTestQuery());
        // 3、把原来单独的事务干掉
//        return DataSourceBuilder.create().build();
        return xaDataSource;
    }

    /**
     * 创建SqlSessionFactory
     *
     * @param memberDataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "memberSqlSessionFactory")
    public SqlSessionFactory memberSqlSessionFactory(@Qualifier("memberDataSource") DataSource memberDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(memberDataSource());
        sqlSessionFactoryBean.setDataSource(memberDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    /*    *//**
     * 创建会员事务管理器
     * @param memberDataSource
     * @return
     * @throws Exception
     *//*
    @Bean(name = "memberTransactionManager")
    public DataSourceTransactionManager memberTransactionManager(@Qualifier("memberDataSource") DataSource memberDataSource) throws Exception{
        return new DataSourceTransactionManager(memberDataSource);
    }*/

    /**
     * 创建订单sqlSesion模板
     *
     * @param memberSqlSessionFactory
     * @return
     */
    @Bean(name = "memberSqlSessionTemplate")
    public SqlSessionTemplate memberSqlSessionTemplate(@Qualifier("memberSqlSessionFactory") SqlSessionFactory memberSqlSessionFactory) {
        return new SqlSessionTemplate(memberSqlSessionFactory);
    }

}
