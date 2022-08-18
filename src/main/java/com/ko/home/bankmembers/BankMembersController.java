package com.ko.home.bankmembers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/*")
public class BankMembersController {

	@Autowired
	private BankMembersService bankMembersService;
	
	@RequestMapping(value = "login.ko", method = RequestMethod.GET)
	public String login()throws Exception{
		System.out.println("로그인 접속 (GET)");
		return "member/login";
	}
	
	@RequestMapping(value = "login.ko", method = RequestMethod.POST)
	public String login(HttpServletRequest request, BankMembersDTO bankMembersDTO)throws Exception{
		System.out.println("DB로그인 접속 (POST)");
		//DB에서 아이디와 패스워드가 일치하는 DTO데이터 가져옴
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		
		//request에 있는 파라미터를 session에 넣음
		HttpSession session = request.getSession();
		//DB에서 가져온 DTO데이터를 JSP로 속성만들어서 보내기
		session.setAttribute("member", bankMembersDTO);
		return "redirect:../";
	}
	
	@RequestMapping(value = "join.ko", method = RequestMethod.GET)
	public void join()throws Exception {
		System.out.println("회원가입 접속 (GET)");
	}
	
}
