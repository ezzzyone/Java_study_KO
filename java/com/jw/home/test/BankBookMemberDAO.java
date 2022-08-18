package com.jw.home.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BankBookMemberDAO extends DBTest{

 @Autowired
 private BankBookMemberDAO bankBookMemberDAO;
 
 @Test
 public void setJoinTest() throws Exception{
	 int result = BankBookMemberDAO.setJoin("df");
	 assertEquals(1, result);
 }
 
 
	}


