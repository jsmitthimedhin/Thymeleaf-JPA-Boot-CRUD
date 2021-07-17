package com.ben.springboot.thymeleafdemo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages={"${spring.data.jpa.repository.packages}"})
public class DataSourceConfig {
	
	@Primary
	@Bean
	@ConfigurationProperties(prefix="app.datasource")
	public DataSource appDataSource() {
		System.out.println(">>> Fetching from church directory!!!!...");
		return DataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties(prefix="spring.data.jpa.entity")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource appDataSource) {
		System.out.println(">>> Fetching Spring Data JPA's entity");
		return builder
				.dataSource(appDataSource)
				.build();
	}

	@Bean
	@ConfigurationProperties(prefix="security.datasource")
	public DataSource securityDataSource() {
		System.out.println(">>> Fetching security data source from MYSQL");
		return DataSourceBuilder.create().build();
	}
}
