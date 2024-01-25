package com.crud.rentalmobil.config.profile;

import com.crud.rentalmobil.config.properties.AppProperties;
import com.crud.rentalmobil.config.variable.AppConstant;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalProfile {

    @Bean(AppConstant.BEAN_APP_CONF)
    public AppProperties loadAppConfig(){
        return new AppProperties();
    }

    @Bean(AppConstant.BEAN_DS_MOBIL)
    public HikariDataSource rentalMobilDatasource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("admin");
        config.setPoolName("Hikaripool-DataMobil");
        return new HikariDataSource(config);
    }
}
