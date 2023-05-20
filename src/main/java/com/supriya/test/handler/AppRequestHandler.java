package com.supriya.test.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class AppRequestHandler implements HandlerInterceptor {

	@Value("${custome.authkey}")
	private String auth_key;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Request Received from "+request.getHeader("Host"));
		System.out.println("request :" +request.getContentType()+ " "+request.getAuthType()+" "+request.getRemoteAddr());
		if (null != request.getHeader("auth_key") && request.getHeader("auth_key").equals(auth_key)) {
			response.addHeader("Authentication", "Success");
			response.addHeader("Access-Control-Allow-Origin", "*");
			return true;
		} else {
			response.addHeader("Authentication", "Fail");
			response.addHeader("Access-Control-Allow-Origin", "*");
			return false;
		}
	}

}
