package com.ko.home.BankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ko.home.util.CommentPager;
@Repository
public class BankBookCommentDAO {
		
		@Autowired
		private SqlSession sqlSession;
		private final String NAMESPACE = "com.ko.home.BankBook.BankBookCommentDAO.";
		
		public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception {
			
			return sqlSession.update(NAMESPACE+"setCommentUpdate", bankBookCommentDTO);
			
		}
		
		
		public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
			
			return sqlSession.delete(NAMESPACE+"setCommentDelete", bankBookCommentDTO);
			
		}
		
		
		
		public Long getCommentListTotalCount(CommentPager commentPager) throws Exception {
			
			return sqlSession.selectOne(NAMESPACE+"getCommentListTotalCount", commentPager);
			
		}
		
		
		
		public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
			
			return sqlSession.insert(NAMESPACE+"setCommentAdd",bankBookCommentDTO);
			
		}
		
		public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception {
			
			return sqlSession.selectList(NAMESPACE+"getCommentList", commentPager);
			
		}

}
