package com.crud.rentalmobil.config.jdbc;

import com.crud.rentalmobil.config.variable.AppConstant;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataMobilConfig {

    @Qualifier(AppConstant.BEAN_DS_MOBIL)
    private HikariDataSource dataSource;

    @Bean(AppConstant.BEAN_JDBC_MOBIL)
    public JdbcTemplate jdbcDataMobil(@Qualifier(AppConstant.BEAN_DS_MOBIL) HikariDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}