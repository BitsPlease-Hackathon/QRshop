package com.bitsplease.qrshop.api.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author Chrisostomos Bakouras
 */
@Configuration
@Profile("H2")
public class H2Config {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:qrshop");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
    }
}
