package com.ko.home.BankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO implements BookDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.ko.home.BankBook.BankBookDAO.";
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		
//		Connection con = DBConnector.getConnection();
//		String sql = "UPDATE BANKBOOK SET BOOKNAME=?, BOOKRATE=? where BOOKNUM=?";
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		st.setString(1, bankBookDTO.getBookName());
//		st.setDouble(2, bankBookDTO.getBookRate());
//		st.setLong(3, bankBookDTO.getBookNum());
//		
//		int result = st.executeUpdate();
//		
//		DBConnector.disConnect(st, con);
		
		return sqlSession.update(NAMESPACE+"setUpdate",bankBookDTO);
		
	}

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		
//		Connection con = DBConnector.getConnection();
//		String sql = "insert into BANKBOOK(BOOKNUM, BOOKNAME, BOOKRATE, BOOKSALE) values (?,?,?,?)";
//		PreparedStatement st = con.prepareStatement(sql);
//		Calendar ca = Calendar.getInstance();
//		
//		st.setLong(1, ca.getTimeInMillis());
//		st.setString(2, bankBookDTO.getBookName());
//		st.setDouble(3,bankBookDTO.getBookRate());
//		st.setInt(4, bankBookDTO.getBookSale());
//		
//		
//		int rs = st.executeUpdate();
//		
//		DBConnector.disConnect(st, con);
		
		return sqlSession.insert(NAMESPACE+"setBankBook", bankBookDTO);
				
	}

	@Override
	public List<BankBookDTO> getList() throws Exception {
		
//		ArrayList<BankBookDTO> bankBookDTOs = new ArrayList<BankBookDTO>();
//		
//		Connection con = DBConnector.getConnection();
//		String sql = "select * from BANKBOOK ORDER BY BOOKNUM DESC";
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		ResultSet rs = st.executeQuery();
//		
//		while(rs.next()) {
//			BankBookDTO bankBookDTO = new BankBookDTO();
//			bankBookDTO.setBookNum(rs.getLong("bookNum"));
//			bankBookDTO.setBookName(rs.getNString("bookName"));
//			bankBookDTO.setBookRate(rs.getDouble("bookRate"));
//			bankBookDTO.setBookSale(rs.getInt("bookSale"));
//			bankBookDTOs.add(bankBookDTO);
//		}
//		
//		DBConnector.disConnect(rs, st, con);
		
		return sqlSession.selectList(NAMESPACE+"getList", NAMESPACE);
	}

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		
//		Connection con = DBConnector.getConnection();
//		String sql = "update BANKBOOK set booksale= ? where booknum = ?";
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		st.setInt(1, bankBookDTO.getBookSale());
//		st.setLong(2, bankBookDTO.getBookNum());
//		
//		int result = st.executeUpdate();
//		
		return sqlSession.update(NAMESPACE+"setChangeSale", bankBookDTO);
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		
//		BankBookDTO bankBookDTO2 = null;
//	
//		Connection con  = DBConnector.getConnection();
//		String sql ="select * from BANKBOOK where BOOKNUM = ?";
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		
//		st.setLong(1, bankBookDTO.getBookNum());
//		
//		ResultSet rs = st.executeQuery();
//		
//		if(rs.next()) {
//			bankBookDTO2 = new BankBookDTO();
//			bankBookDTO2.setBookNum(rs.getLong("bookNum"));
//			bankBookDTO2.setBookName(rs.getNString("bookName"));
//			bankBookDTO2.setBookRate(rs.getDouble("bookRate"));
//			bankBookDTO2.setBookSale(rs.getInt("bookSale"));
//			
//		}
//		
//		DBConnector.disConnect(rs, st, con);
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
		
	}
	
		public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		
//		Connection con = DBConnector.getConnection();
//		String sql = "DELETE BANKBOOK WHERE BOOKNUM= ?";
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		st.setLong(1, bankBookDTO.getBookNum());
//		
//		
//		int rs = st.executeUpdate();
//		
//		DBConnector.disConnect(st, con);
		
		return sqlSession.delete(NAMESPACE+"setDelete", bankBookDTO);
				
	}

	
	
}