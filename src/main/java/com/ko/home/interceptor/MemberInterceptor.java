package com.ko.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ko.home.bankmembers.BankMembersDAO;
import com.ko.home.bankmembers.BankMembersDTO;

public class MemberInterceptor extends HandlerInterceptorAdapter{

	//@Autowired
	//private BankMembersDAO membersDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		if(obj != null) {
			System.out.println("로그인 성공 ");
			
			return true;
		}else {
			System.out.println("로그인 안함 ");
			response.sendRedirect("../../../../../../member/login");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

}
