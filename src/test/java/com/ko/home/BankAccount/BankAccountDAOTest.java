package com.ko.home.BankAccount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;
import com.ko.home.bankmembers.BankMembersDTO;

public class BankAccountDAOTest extends MyAbstractTest{

	@Autowired
private BankAccountDAO bankAccountDAO;

	@Test
public void getListTest()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("iu");
	List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
	assertNotEquals(0, ar.size());
	}


}
