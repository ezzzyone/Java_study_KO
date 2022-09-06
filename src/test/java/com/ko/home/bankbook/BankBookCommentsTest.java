package com.ko.home.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;
import com.ko.home.BankBook.BankBookCommentDAO;
import com.ko.home.BankBook.BankBookCommentDTO;
import com.ko.home.BankBook.BankBookDAO;
import com.ko.home.BankBook.BankBookDTO;
import com.ko.home.util.CommentPager;

public class BankBookCommentsTest extends MyAbstractTest{
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;



//	@Test
//	public void setCommentAdd() throws Exception{
//		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
//		bankBookCommentDTO.setContents("gkgk");
//		bankBookCommentDTO.setWriter("dd");
//		
//		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
//		assertEquals(1, result);
//	}
	
		@Test 
		public void getListTest() throws Exception{
		  CommentPager commentPager= new CommentPager();
		  List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommentList(commentPager); 
		  commentPager.setBookNum(1660283804089L);
		  commentPager.setPage(1L);
		  commentPager.getRowNum();
		  assertNotEquals(0, ar.size());
		 
		 
		  }

}
