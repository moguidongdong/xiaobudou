package com.mayikt.config.order;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.mayikt.order.tony.dao", sqlSessionTemplateRef = "orderSqlSessionTemplate")
public class OrderDataSourceConfig {

    //@Configuration  xml  OrderDataSourceConfig.xml

    /**
     * 创建 orderDataSource
     *
     * @return
     */
    @Bean("orderDataSource")
    public DataSource orderDataSource(OrderConfig orderConfig) throws SQLException {
        // 1、创建xaDataSource
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL(orderConfig.getJdbcUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setUser(orderConfig.getUsername());
        mysqlXADataSource.setPassword(orderConfig.getPassword());

        //注册到全局事务上
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName(orderConfig.getUniqueResourceName());
        xaDataSource.setMinPoolSize(orderConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(orderConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(orderConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(orderConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(orderConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(orderConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(orderConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(orderConfig.getTestQuery());
        // 3、把原来的事务干掉，用全局事务
//        return DataSourceBuilder.create().build();
        return xaDataSource;
    }

    /**
     * 创建SqlSessionFactory
     *
     * @param orderDataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory orderSqlSessionFactory(@Qualifier("orderDataSource") DataSource orderDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(orderDataSource());
        sqlSessionFactoryBean.setDataSource(orderDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    /*    *//**
     * 创建会员事务管理器
     * @param orderDataSource
     * @return
     * @throws Exception
     *//*
    @Bean(name = "orderTransactionManager")
    public DataSourceTransactionManager orderTransactionManager(@Qualifier("orderDataSource") DataSource orderDataSource) throws Exception{
        return new DataSourceTransactionManager(orderDataSource);
    }*/

    /**
     * 创建订单sqlSesion模板
     *
     * @param orderSqlSessionFactory
     * @return
     */
    @Bean(name = "orderSqlSessionTemplate")
    public SqlSessionTemplate orderSqlSessionTemplate(@Qualifier("orderSqlSessionFactory") SqlSessionFactory orderSqlSessionFactory) {
        return new SqlSessionTemplate(orderSqlSessionFactory);
    }

}
