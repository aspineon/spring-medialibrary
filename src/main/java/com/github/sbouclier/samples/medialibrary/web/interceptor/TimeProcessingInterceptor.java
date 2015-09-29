package com.github.sbouclier.samples.medialibrary.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Time processing request interceptor
 * 
 * @author Stéphane Bouclier
 *
 */
public class TimeProcessingInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(TimeProcessingInterceptor.class);

	private static final String START_TIME = "startTime";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
	        Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute(START_TIME, startTime);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Request url={}", request.getRequestURL().toString());
			LOG.debug("host: {}", request.getHeader("host"));
			LOG.debug("status: {}", response.getStatus());
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
	        Object handler, ModelAndView modelAndView) throws Exception {
		long startTime = (Long) request.getAttribute(START_TIME);
		long executeTime = System.currentTimeMillis() - startTime;
		request.setAttribute("executeTime", executeTime);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Request url={} executeTime : {}ms", request.getRequestURL().toString(),
			        executeTime);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
	        Object handler, Exception ex) throws Exception {
		long startTime = (Long) request.getAttribute(START_TIME);
		long elapsedTotalTime = System.currentTimeMillis() - startTime;
		request.setAttribute("elapsedTotalTime", elapsedTotalTime);

		response.addHeader("elapsedTotalTime", String.valueOf(elapsedTotalTime));

		LOG.debug("Request url={} Time Taken={}ms", request.getRequestURL().toString(),
		        elapsedTotalTime);
	}
}
