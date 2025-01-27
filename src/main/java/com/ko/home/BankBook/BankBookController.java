package com.ko.home.BankBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setDelete(bankBookDTO);
		mv.setViewName("redirect:./list.iu");
		return mv;		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void Update(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.setUpdate(bankBookDTO);
		if(result>0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(BankBookDTO bankBookDTO, Model model)throws Exception{
		System.out.println("Update 페이지 접속");
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		System.out.println("DTOOOOOOOOOOOOOOO");
		
		model.addAttribute("detail", bankBookDTO);
		
		return "bankbook/update";
	}

	@RequestMapping(value = "list", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		System.out.println("List 페이지 접속");
		
		List<BankBookDTO> ar = bankBookService.getList();
		
		//return "bankbook/list"; 리턴URL과 요청URL이 똑같으면 리턴 생략가능(viod)
		
		model.addAttribute("list", ar);
		
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Detail 페이지 접속");
		//스프링이 하는 과정을 우리가 직접 객체를 만들어서 보내도 됀다
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		//return "bankbook/detail";
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankBookDTO);
		
		return mv;
	}
	
	// /bankbook/add GET/WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {
		System.out.println("Add 페이지 접속");
		
		// servlet-context.xml을 보면
		// beans:property name="prefix" value="/WEB-INF/views/"이 보임
		// 여기에 /WEB-INF/views/는 RequestMapping
		// beans:property name="suffix" value=".jsp" 가 있기 때문에
		// bankbook/add 만 쓰면 됀다
		//return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Add 페이지 접속");
		System.out.println(bankBookDTO.getBookName());
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.setBankBook(bankBookDTO);
		if(result>0) {
			System.out.println("통장 개설 성공!");
		}else {
			System.out.println("통장 개설 실패!");
		}
		
		//return "bankbook/add";
		//상품 등록 후 리스트페이지로
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@RequestMapping(value="commentAdd", method = RequestMethod.GET)
	public void commentAdd() throws Exception{
		
	}
	
	@RequestMapping(value="commentAdd", method = RequestMethod.POST)
	@ResponseBody
	//jsp를 안거치고 body에 바로 담아 응답으로 내보내겠다.
	
	public String commentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		
		System.out.println("booknum="+bankBookCommentDTO.getBookNum());
		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
		if(result>0) {
			System.out.println("뱅크북 커멘드 성공!");
		}else {
			System.out.println("뱅크북 커멘드 실패!");
		}
		
		String jsonResult = "{\"result\":\""+result+"\"}";
		//mv.addObject("result", result);
		//mv.setViewName("common/ajaxResult");
		return jsonResult;
		
	}
	
	@RequestMapping(value="commentDelete", method = RequestMethod.POST)
	@ResponseBody
	//jsp를 안거치고 body에 바로 담아 응답으로 내보내겠다.
	
	public int commentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		
		int result = bankBookService.setCommentDelete(bankBookCommentDTO);
		
		return result;

		
	}
	
	@RequestMapping(value="commentUpdate", method = RequestMethod.POST)
	@ResponseBody
	public int commentUpdate(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		
		System.out.println(bankBookCommentDTO.getNum());
		System.out.println("Contents="+bankBookCommentDTO.getContents());
		
		int result = bankBookService.setCommentUpdate(bankBookCommentDTO);
		
		return result;
	}
	
//	//1.jsp에 출력하고 결과물을 응답으로 전송
//	@RequestMapping(value = "commentList", method=RequestMethod.GET)
//	public ModelAndView commentList(CommentPager commentPager) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		
//		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
//		System.out.println("CommentList");
//		System.out.println(ar.size());
//		
//		mv.addObject("commentList", ar);
//		mv.setViewName("common/commentList");
//		
//		return mv;
//
//	}
	
	
	//2. json으로 body에 담아 바로 뿌리기 
	//DTO == {}  배열
	//num=1 == {"num":123, "bookNum":1234}, {"num":123, "bookNum":1234}
	
	@RequestMapping(value = "commentList", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> commentList(CommentPager commentPager) throws Exception {
		
		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		System.out.println("CommentList");
		System.out.println(ar.size());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", ar);
		map.put("pager", commentPager); //2개를 리턴해야해서 map에 담음
		
		
		return map;

	}
	
}