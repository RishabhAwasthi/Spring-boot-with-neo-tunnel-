package com.sap.ct.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class CloudDatabaseConfig {

    @Bean
    public DataSource dataSource() {

        return DataSourceBuilder.create()
                .driverClassName(com.sap.db.jdbc.Driver.class.getName())
                .url("jdbc:sap://localhost:30015/")
                .username("SYSTEM")
                .password("Awertyuioplkjhgfds6785432190zxcvbnm")
                .build();

    }
}