package com.ko.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.BankBook.BankBookDTO;
import com.ko.home.board.impl.BoardDTO;


@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	
	@Autowired
	   private QnaService qnaService;
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	   public String setReply() throws Exception {
	      
	      return "qna/list";
	      
	   }
	   @RequestMapping(value = "reply", method = RequestMethod.POST)
	   public ModelAndView setReply(BoardDTO boardDTO) throws Exception {
	      ModelAndView mv = new ModelAndView();
	   
	      int result = qnaService.setReply(boardDTO);
	      
	      mv.setViewName("redirect:./list");
	      
	      return mv;
	      
	   }
	

	   // 글목록
	   @RequestMapping(value = "list", method = RequestMethod.GET)
	   public ModelAndView getList() throws Exception {
		   System.out.println("list get 실행");
	      List<BoardDTO> ar = qnaService.getList();
	      ModelAndView mv = new ModelAndView();
	      
	      mv.addObject("list", ar);
	      mv.setViewName("qna/list");
	      
	      return mv;
	      
	   }
	   
	   // 상세보기
	   @RequestMapping(value = "detail", method = RequestMethod.GET)
	   public ModelAndView getDetail(BoardDTO boardDTO, Model model) throws Exception {
		   
		   ModelAndView mv = new ModelAndView();
	      boardDTO = qnaService.getDetail(boardDTO);
	      
	      mv.setViewName("qna/detail");
	      mv.addObject("detail", boardDTO);
	      return mv;
	            
	   }
	   
	   // 글쓰기
	   @RequestMapping(value = "add", method = RequestMethod.GET)
	   public String setAdd() throws Exception {
	      
	      return "qna/add";
	      
	   }
	   @RequestMapping(value = "add", method = RequestMethod.POST)
	   public ModelAndView setAdd(BoardDTO boardDTO) throws Exception {
	      ModelAndView mv = new ModelAndView();
	   
	      int result = qnaService.setAdd(boardDTO);
	      
	      mv.setViewName("redirect:./list");
	      
	      return mv;
	      
	   }
	   
	   // 글 수정
	   @RequestMapping(value = "update", method = RequestMethod.GET)
	   public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
	      boardDTO = qnaService.getDetail(boardDTO);
	      
	      mv.addObject("boardDTO", boardDTO);
	      mv.setViewName("qna/update");
	      
	      return mv;
	      
	   }
	   @RequestMapping(value = "update", method = RequestMethod.POST)
	   public String setUpdate(BoardDTO boardDTO) throws Exception{
	      int result = qnaService.setUpdate(boardDTO);
	      
	      return "redirect:./detail?num="+boardDTO.getNum();
	      
	   }
	   
	   // 글 삭제
	   @RequestMapping(value = "delete.", method = RequestMethod.GET)
	   public String setDelete(BoardDTO boardDTO) throws Exception{
	      int result = qnaService.setDelete(boardDTO);
	      
	      return "redirect:./list";
	      
	   }

}
