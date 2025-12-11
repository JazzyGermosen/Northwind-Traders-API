package com.pluralsight.NorthwindTradersAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    private DataSource basicDataSource;

    @Bean
    public DataSource dataSource(){
        return basicDataSource;
    }

}
