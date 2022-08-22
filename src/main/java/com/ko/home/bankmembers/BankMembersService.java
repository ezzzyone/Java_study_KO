package com.ko.home.bankmembers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ko.home.BankAccount.BankAccountDAO;
import com.ko.home.BankAccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	//로그인
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	//회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.setJoin(bankMembersDTO);
	}
	
	//아이디검색
	public List<BankMembersDTO> getSearchByID(String search)throws Exception{
		return bankMembersDAO.getSearchByID(search);
		
	
	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
		
	}
	/*
	 * public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO)throws
	 * Exception{ Map<String, Object> map = new HashMap<String, Object>();
	 * 
	 * List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
	 * bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO); map.put("list",
	 * ar); map.put("dto", bankMembersDTO); return map;
	 * 
	 * 
	 * }
	 */
}
