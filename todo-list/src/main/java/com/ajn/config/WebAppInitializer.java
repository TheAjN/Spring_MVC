package com.ajn.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		log.info("onStartup");

		// create the spring application context
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class); // Similiar to (ConfigurableApplicationContext context  = new AnnotationConfigApplicationContext(GameConfig.class);)
										//but since we are creating a web application and not a console application,
										//AnnotationConfigWebApplicationContext class should be used
		//Here context.register() means we are registering a config class, only class with @Configuration annotation will work here

		
		//create the dispatcher servlet
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
		
		//register and configure the dispatcher servlet
		ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
		
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}

}
