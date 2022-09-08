package com.ko.home.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.bankmembers.BankMembersDTO;
import com.ko.home.board.impl.BoardDTO;
import com.ko.home.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

   @Autowired
   private NoticeService noticeService;
   
	@ModelAttribute("board")
	public String getBoard() {
		
		return "notice";
	}

   // 글목록
   @RequestMapping(value = "list", method = RequestMethod.GET)
   //파라미터의 이름과 매개변수명이 일치 않는 경우 
   //@RequestParam(value="파라미터이름")  매개변수데이터타입 매개변수명
   //파라미터 값 안넘어갈때 자동세팅값 설정
   //public ModelAndView getList(@RequestParam(defaultValue = "1")Long page) throws Exception {
   
   public ModelAndView getList(Pager pager) throws Exception {
	  //public ModelAndView getList() throws Exception {
      List<BoardDTO> ar = noticeService.getList(pager);
      ModelAndView mv = new ModelAndView();
      mv.addObject("list", ar);
      mv.addObject("pager", pager); //jsp로 가져가기
      mv.setViewName("board/list");
      return mv;
      
   }
   
   // 상세보기
   @RequestMapping(value = "detail", method = RequestMethod.GET)
   public ModelAndView getDetail(BoardDTO boardDTO, Model model) throws Exception {
	   
	   ModelAndView mv = new ModelAndView();
      boardDTO = noticeService.getDetail(boardDTO);
      
      mv.setViewName("board/detail");
      mv.addObject("detail", boardDTO);
      
      return mv;
            
   }
   
   // 글쓰기
   @RequestMapping(value = "add", method = RequestMethod.GET)
   public String setAdd(HttpSession session) throws Exception {
	   
      BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
      
      if(bankMembersDTO != null) {
    	  return "board/add";
      }else {
    	  return "redirect:../member/login";
    	  
      }
      
      
   }
   @RequestMapping(value = "add", method = RequestMethod.POST)
   public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception {
      ModelAndView mv = new ModelAndView();

		 int result = noticeService.setAdd(boardDTO, files, session.getServletContext());
      
		String message ="메롱~ 실패";
		if (result>0) {
			message = "오 ~성공";
		}
		
		mv.addObject("result",result);
		mv.addObject("message", message);
		mv.addObject("url", "list");
		mv.setViewName("common/result");
		
		
		return mv;

      
   }
   
   // 글 수정
   @RequestMapping(value = "update", method = RequestMethod.GET)
   public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
      boardDTO = noticeService.getDetail(boardDTO);
      
      mv.addObject("boardDTO", boardDTO);
      mv.setViewName("board/update");
      
      return mv;
      
   }
   @RequestMapping(value = "update", method = RequestMethod.POST)
   public String setUpdate(BoardDTO boardDTO) throws Exception{
      int result = noticeService.setUpdate(boardDTO);
      
      return "redirect:./detail?num="+boardDTO.getNum();
      
   }
   
   // 글 삭제
   @RequestMapping(value = "delete", method = RequestMethod.GET)
   public String setDelete(BoardDTO boardDTO) throws Exception{
      int result = noticeService.setDelete(boardDTO);
      
      return "redirect:./list";
      
   }
}
