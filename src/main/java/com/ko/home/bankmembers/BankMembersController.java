package com.ko.home.bankmembers;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.BankAccount.BankAccountDTO;
import com.ko.home.BankAccount.BankAccountService;

@Controller
@RequestMapping(value = "/member/*")
public class BankMembersController {

	@Autowired
	private BankMembersService bankMembersService;
	@Autowired
	private BankAccountService bankAccountService;

	
	@GetMapping("agree")
	public String getAgree() throws Exception {

		return "member/agree";
	}
	
	
	
	// 로그인
	
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() throws Exception {
		System.out.println("로그인 접속 (GET)");

		return "member/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, BankMembersDTO bankMembersDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("DB로그인 접속 (POST)");
		// DB에서 아이디와 패스워드가 일치하는 DTO데이터 가져옴
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);

		// request에 있는 파라미터를 session에 넣음
		HttpSession session = request.getSession();
		// DB에서 가져온 DTO데이터를 JSP로 속성만들어서 보내기
		session.setAttribute("member", bankMembersDTO);
		
		int result =0;
		String message ="메롱~ 로그인 실패";
		String url="./login";
		if (bankMembersDTO!=null) {
			message = "오 ~ 로그인 성공";
			result =1;
			url="../";
		}
		
		mv.addObject("result",result);
		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("common/result");
		
		
		return mv;
	}

	// 로그아웃
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:../";
	}

	// 회원가입
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() throws Exception {
		System.out.println("회원가입 접속 (GET)");

		return "member/join";
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception {
		System.out.println("회원가입 접속 (POST)");
		System.out.println("업로드시 파일명: " + photo.getOriginalFilename());
		System.out.println("업로드시 파라미터명: " + photo.getName());
		System.out.println("업로드 파일 크기: " + photo.getSize());
		
		
		  int result = bankMembersService.setJoin(bankMembersDTO, photo, session.getServletContext()); 
		  
		  
		  if(result>0) {
		  System.out.println("회원가입 성공!"); }else { System.out.println("회원가입 실패.."); }
		 

		return "redirect:../";

	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public void search() throws Exception {
		System.out.println("아이디 검색중 (GET)");

		// return "member/search";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView search(String userName) throws Exception {
		System.out.println("아이디 검색중 (POST)");
		ModelAndView mv = new ModelAndView();

		List<BankMembersDTO> ar = bankMembersService.getSearchByID(userName);

		// 경로와 데이터를 함께 보낼때
		mv.setViewName("member/list");
		mv.addObject("list", ar);

		return mv;
	}

	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public ModelAndView getMyPage(HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
		// List<BankAccountDTO> ar =
		// bankAccountService.getListByUserName(bankMembersDTO);
		mv.addObject("dto", bankMembersDTO);
		// mv.addObject("list", ar);
		mv.setViewName("member/mypage");

		return mv;
	}

}
