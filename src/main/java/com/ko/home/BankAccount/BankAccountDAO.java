package com.ko.home.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ko.home.bankmembers.BankMembersDTO;



@Repository
public class BankAccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.ko.home.BankAccount.BankAccountDAO.";

	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		/*
		 * //1. DB연결
		 * 
		 * 
		 * //2. SQL문 작성 String sql = "INSERT INTO BANKACCOUNT " +
		 * "VALUES(ACCOUNT_SEQ.NEXTVAL, ?, ?, sysdate)";
		 * 
		 * //3. 미리전송 PreparedStatement st = con.prepareStatement(sql);
		 * 
		 * //4. ?값 세팅 st.setString(1,bankAccountDTO.getUserName()); st.setLong(2,
		 * bankAccountDTO.getBookNum());
		 * 
		 * //5. 최종전송 int result = st.executeUpdate();
		 * 
		 * //6. 자원해제 DBConnector.disConnect(st, con);
		 */
		
		return sqlSession.update(NAMESPACE+"add",bankAccountDTO);
	}
	
	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getListByUserName", bankMembersDTO);
		
	}
	
}
