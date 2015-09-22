package com.github.sbouclier.samples.medialibrary.config;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.sbouclier.samples.medialibrary.web.interceptor.TimeProcessingInterceptor;

/**
 * Web configuration
 * 
 * @author Stéphane Bouclier
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(WebConfig.class);

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LOG.debug("addInterceptors()");

		registry.addInterceptor(new TimeProcessingInterceptor());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/pdf/**").addResourceLocations("classpath:/static/pdf/");
	}

	/**
	 * Servlet Context
	 * 
	 * @return
	 */
	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return new ServletContextInitializer() {

			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				// delete JSESSIONID
				Set<SessionTrackingMode> modes = new HashSet<SessionTrackingMode>();
				modes.add(SessionTrackingMode.COOKIE);
				servletContext.setSessionTrackingModes(modes);
			}
		};
	}
}
