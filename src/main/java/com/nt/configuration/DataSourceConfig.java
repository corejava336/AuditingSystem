package com.nt.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/db");
		config.setUsername("root");
		config.setPassword("login1-2");
		config.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Optional, HikariCP will automatically detect the
															// driver class
		return new HikariDataSource(config);
	}
}
