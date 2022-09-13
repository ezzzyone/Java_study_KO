package com.ko.home.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//어드바이스(예외처리) 전문 컨트롤러
@ControllerAdvice
public class BackErrorController {
	
	//ExceptionHandler method만 모임
	
	   //exception처리 전문 메서드
	   @ExceptionHandler(NullPointerException.class)
	   public ModelAndView exceptionTest() {
		   ModelAndView mv = new ModelAndView();
		   
		   mv.setViewName("errors/error_404");
		   
		   return mv;
	   }
	   
	   @ExceptionHandler(Exception.class)
	   public ModelAndView exceptionTest2(Exception e) {
		   ModelAndView mv = new ModelAndView();
		   
		   mv.setViewName("errors/error_404");
		   
		   return mv;
	   }
	
	
}
