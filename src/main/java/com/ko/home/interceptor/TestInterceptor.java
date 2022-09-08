package com.ko.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//return 이 true면 Controller로 진행
		//false면 Controller로 진행 X
		System.out.println("Controller 진입 전 실행");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {		
		System.out.println("Controller에서 DS나가기 전");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	

}
