package com.ko.home.board.qna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;


public class QnaDAOTest extends MyAbstractTest{

	@Autowired
	private QnaDAO qnaDAO;

	@Test 
	
	public void setAddTest() throws Exception{ for (int i =0; i<100;i++) {
		  QnaDTO qnaDTO = new QnaDTO(); qnaDTO.setTitle("Title"+i);
		  qnaDTO.setWriter("Writer"+i); qnaDTO.setContents("Contents"+i);
		  
		  int result = qnaDAO.setAdd(qnaDTO);
		  
		 if(i%10==0) { Thread.sleep(500);} } System.out.println("종료"); }
		 

	/*@Test
	public void setReply() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setContents("qna test");
		qnaDTO.setTitle("qna");
		qnaDTO.setWriter("jw");
		int result = qnaDAO.setReply(qnaDTO);
		assertEquals(1, result);}*/
	}

