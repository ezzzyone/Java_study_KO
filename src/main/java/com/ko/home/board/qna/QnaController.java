package com.ko.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.BankBook.BankBookDTO;
import com.ko.home.board.impl.BoardDTO;
import com.ko.home.util.Pager;


@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	
	@Autowired
	   private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		
		return "QNA";
	}
	
	@GetMapping("reply")
	   public ModelAndView setReply(BoardDTO boardDTO,ModelAndView mv) throws Exception {
		 mv.addObject("boardDTO", boardDTO);
		 mv.setViewName("board/reply");
	      
	      return mv;
	      
	   }
	
	@PostMapping("reply")
	   public String setReply(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setReply(qnaDTO);

	      return "redirect:./list";
	      
	   }
	

	   // 글목록
	   @RequestMapping(value = "list", method = RequestMethod.GET)
	   //파라미터의 이름과 매개변수명이 일치 않는 경우 
	   //@RequestParam(value="파라미터이름")  매개변수데이터타입 매개변수명
	   //파라미터 값 안넘어갈때 자동세팅값 설정
	   //public ModelAndView getList(@RequestParam(defaultValue = "1")Long page) throws Exception {
	   
	   public ModelAndView getList(Pager pager) throws Exception {
		  //public ModelAndView getList() throws Exception {
	      List<BoardDTO> ar = qnaService.getList(pager);
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
	      boardDTO = qnaService.getDetail(boardDTO);
	      
	      mv.setViewName("board/detail");
	      mv.addObject("detail", boardDTO);
	      
	      return mv;
	            
	   }
	   
	   // 글쓰기
	   @RequestMapping(value = "add", method = RequestMethod.GET)
	   public String setAdd() throws Exception {
	      
	      return "board/add";
	      
	   }
	   @RequestMapping(value = "add", method = RequestMethod.POST)
	   public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
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
	      mv.setViewName("board/update");
	      
	      return mv;
	      
	   }
	   @RequestMapping(value = "update", method = RequestMethod.POST)
	   public String setUpdate(BoardDTO boardDTO) throws Exception{
	      int result = qnaService.setUpdate(boardDTO);
	      
	      return "redirect:./detail?num="+boardDTO.getNum();
	      
	   }
	   
	   // 글 삭제
	   @RequestMapping(value = "delete", method = RequestMethod.GET)
	   public String setDelete(BoardDTO boardDTO) throws Exception{
	      int result = qnaService.setDelete(boardDTO);
	      
	      return "redirect:./list";
	      
	   }
	   
}