package com.ko.home.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ko.home.bankmembers.BankMembersDTO;
import com.ko.home.board.impl.BoardDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String method = request.getMethod();
		
		if(method.equals("POST")) {
			return;
			
		}//이후는 get일때 실행
		
		
		//로그인 사용자의 ID와 DTO의 작성자가 일치하는가?
		// 로그인 사용자 정보
		BankMembersDTO bankMembersDTO = (BankMembersDTO)request.getSession().getAttribute("member");
		
		//로그인 사용자 정보 . member dto로 집어넣었으니 그 타입으로 꺼내야함
		//HttpSession session = request.getSession();
		//BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		
		//DTO
		Map<String, Object> map = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO)map.get("boardDTO");
		
		//java에서 문자열이 같은지 비교할때는 .equals ....js에서는 == 사용가능.
		if(!bankMembersDTO.getUserName().equals(boardDTO.getWriter())) {
			modelAndView.setViewName("common/result");
			modelAndView.addObject("message","작성자만 수정가능함");
			modelAndView.addObject("result",1);
			modelAndView.addObject("url","./list");
			
		}
		
		System.out.println("Writer Interceptor");
	}
	
	

}
