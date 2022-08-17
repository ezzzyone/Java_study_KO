package com.ko.home.bankmembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BankMembersDAO {
	
	//멤버변수 SqlSession 선언 후 주입
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ko.home.bankmembers.BankMembersDAO.";
	
	//로그인
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
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
