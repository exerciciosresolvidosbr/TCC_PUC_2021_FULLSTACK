package br.com.condagil;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class CondagilApplication {

	public static void main(String[] args) {
		SpringApplication.run(CondagilApplication.class, args);
	}
	
	@Bean
    public FilterRegistrationBean simpleCorsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        CorsConfiguration config = new CorsConfiguration();  
        config.setAllowCredentials(true); 
        // *** URL below needs to match the Vue client URL and port ***
        //config.setAllowedOrigins(Collections.singletonList("http://localhost:8080"));
        //config.setAllowedOrigins(Collections.singletonList("http://condagilbackend-env.eba-4put3pzz.sa-east-1.elasticbeanstalk.com"));
        //config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        //config.setAllowedOrigins(Collections.singletonList("http://condagilfrontend.s3-website-sa-east-1.amazonaws.com"));
        //config.setAllowedOrigins(Collections.singletonList("http://localhost:8080/**"));
        config.setAllowedOriginPatterns(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));  
        config.setAllowedHeaders(Collections.singletonList("*"));  
        source.registerCorsConfiguration("/**", config);  
        FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
        return bean;  
    }   

}
