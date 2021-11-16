package com.ajn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.ajn.util.ViewNames;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.ajn")
public class WebConfig implements WebMvcConfigurer {

	private static final String VIEW_RESOLVER_PREFIX="WEB-INF/view/"; 
	private static final String VIEW_RESOLVER_SUFFIX=".jsp";
	
	
	// == bean methods
	@Bean
	public ViewResolver viewResolver() {
		
		UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
		viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);
		return viewResolver;
		
	}


	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/").setViewName(ViewNames.HOME);
	}
	
	
	
}
