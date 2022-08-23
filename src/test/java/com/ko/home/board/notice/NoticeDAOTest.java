package com.ko.home.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;
import com.ko.home.BankBook.BankBookDAO;
import com.ko.home.BankBook.BankBookDTO;
import com.ko.home.board.impl.BoardDTO;
import com.ko.home.board.notice.NoticeDAO;



public class NoticeDAOTest extends MyAbstractTest{

	@Autowired
	private NoticeDAO noticeDAO;
	   @Test
	   public void getListTest() throws Exception{
	      
	      List<BoardDTO> ar = noticeDAO.getList();
	      assertNotEquals(0, ar.size());
	      
	      
	   }


}
