package br.com.condagil.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresConfig {

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
          .driverClassName("org.postgresql.Driver")
          //.url("jdbc:postgresql://localhost:5432/condagil")
          .url("jdbc:postgresql://condagildb.cqaelx9bkz68.sa-east-1.rds.amazonaws.com:5432/condagildb")
          .username("postgres")
          .password("postgres")
          .build();	
    }
	
}
