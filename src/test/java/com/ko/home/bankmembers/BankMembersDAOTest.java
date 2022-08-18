package com.ko.home.bankmembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;

public class BankMembersDAOTest extends MyAbstractTest{

	//객체 생성 후 주입시켜야 옴!
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	//@Test 어노테이션 꼭 줘야함!
	@Test
	public void setJoinTest()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("GD");
		bankMembersDTO.setPassWord("123");
		bankMembersDTO.setName("지용");
		bankMembersDTO.setEmail("GD@naver.com");
		bankMembersDTO.setPhone("010-2222-2222");
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		assertEquals(1, result);
	}

	@Test
	public void getLoginTest()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("GD");
		bankMembersDTO.setPassWord("123");
		bankMembersDTO = bankMembersDAO.getLogin(bankMembersDTO);
		assertNotNull(bankMembersDTO);
	}
	
	@Test
	public void getSearchByID()throws Exception{
		List<BankMembersDTO> ar = bankMembersDAO.getSearchByID("ad");
		assertNotEquals(0, 0);
	}
}
