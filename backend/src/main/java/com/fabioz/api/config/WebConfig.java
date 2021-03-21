package com.fabioz.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author fabioz
 *
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	@Override
    public void addCorsMappings( CorsRegistry registry ) {
		registry
    		.addMapping("/**")
    		.allowedOrigins("*")
    		.allowedMethods( "POST", "GET", "PUT", "PATCH", "OPTIONS", "DELETE");
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
	            .addResourceHandler("swagger-ui.html")
	            .addResourceLocations("classpath:/META-INF/resources/");

	    registry
	            .addResourceHandler("/webjars/**")
	            .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}


