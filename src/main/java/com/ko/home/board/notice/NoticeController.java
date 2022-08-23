package com.ko.home.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.board.impl.BoardDTO;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

   @Autowired
   private NoticeService noticeService;

   // 글목록
   @RequestMapping(value = "list", method = RequestMethod.GET)
   public ModelAndView getList() throws Exception {
      List<BoardDTO> ar = noticeService.getList();
      ModelAndView mv = new ModelAndView();
      
      mv.addObject("list", ar);
      mv.setViewName("notice/list");
      
      return mv;
      
   }
   
   // 상세보기
   @RequestMapping(value = "detail", method = RequestMethod.GET)
   public ModelAndView getDetail(BoardDTO boardDTO, Model model) throws Exception {
	   
	   ModelAndView mv = new ModelAndView();
      boardDTO = noticeService.getDetail(boardDTO);
      
      mv.setViewName("notice/detail");
      mv.addObject("detail", boardDTO);
      return mv;
            
   }
   
   // 글쓰기
   @RequestMapping(value = "add", method = RequestMethod.GET)
   public String setAdd() throws Exception {
      
      return "notice/add";
      
   }
   @RequestMapping(value = "add", method = RequestMethod.POST)
   public ModelAndView setAdd(BoardDTO boardDTO) throws Exception {
      ModelAndView mv = new ModelAndView();
   
      int result = noticeService.setAdd(boardDTO);
      
      mv.setViewName("redirect:./list");
      
      return mv;
      
   }
   
   // 글 수정
   @RequestMapping(value = "update", method = RequestMethod.GET)
   public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
      boardDTO = noticeService.getDetail(boardDTO);
      
      mv.addObject("boardDTO", boardDTO);
      mv.setViewName("notice/update");
      
      return mv;
      
   }
   @RequestMapping(value = "update", method = RequestMethod.POST)
   public String setUpdate(BoardDTO boardDTO) throws Exception{
      int result = noticeService.setUpdate(boardDTO);
      
      return "redirect:./detail?num="+boardDTO.getNum();
      
   }
   
   // 글 삭제
   @RequestMapping(value = "delete.", method = RequestMethod.GET)
   public String setDelete(BoardDTO boardDTO) throws Exception{
      int result = noticeService.setDelete(boardDTO);
      
      return "redirect:./list";
      
   }
}
