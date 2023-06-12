package com.example.springmvc;

import com.example.springmvc.config.CommonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringmvcApplication {

	@Autowired
	private CommonConfig config;
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

	@Bean
	public DataSource getDataSource(){
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(config.databaseDriver);
		dataSourceBuilder.url(config.databaseUrl);
		dataSourceBuilder.username(config.databaseUsername);
		dataSourceBuilder.password(config.databasePassword);
		return dataSourceBuilder.build();
	}

	@Bean
	public JdbcTemplate getJdbcTemplate(){
		return new JdbcTemplate(getDataSource());
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return  new NamedParameterJdbcTemplate(getDataSource());
	}
}
