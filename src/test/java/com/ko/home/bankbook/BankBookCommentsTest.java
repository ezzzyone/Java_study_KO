package com.ko.home.bankbook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;
import com.ko.home.BankBook.BankBookCommentDAO;
import com.ko.home.BankBook.BankBookCommentDTO;
import com.ko.home.BankBook.BankBookDAO;
import com.ko.home.BankBook.BankBookDTO;

public class BankBookCommentsTest extends MyAbstractTest{
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;


	@Test
	public void setCommentAdd() throws Exception{
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(454646L);
		bankBookCommentDTO.setContents("gkgk");
		bankBookCommentDTO.setWriter("dd");
		
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		assertEquals(1, result);
	}

}
