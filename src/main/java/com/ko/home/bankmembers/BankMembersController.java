package com.ko.home.bankmembers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class BankMembersController {

	@Autowired
	private BankMembersService bankMembersService;
	
	@RequestMapping(value = "login.iu", method = RequestMethod.GET)
	public String login()throws Exception{
		System.out.println("로그인 접속 (GET)");
		return "member/login";
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO)throws Exception{
		System.out.println("로그인 접속 (POST)");
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/login");
		mv.addObject("login", bankMembersDTO);
		return "member/login";
	}
	
}
