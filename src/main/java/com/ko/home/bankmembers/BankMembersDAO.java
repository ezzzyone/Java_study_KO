package com.ko.home.bankmembers;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BankMembersDAO {
	
	//로그인
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDTO;
	}
	
	//회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{
		return 0;
	}
	
	//아이디검색
	public List<BankMembersDTO> getSearchByID(String search)throws Exception{
		return null;
	}
	
}
