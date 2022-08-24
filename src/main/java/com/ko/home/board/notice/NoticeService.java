package com.ko.home.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ko.home.board.impl.BoardDTO;
import com.ko.home.board.impl.BoardService;
@Service
public class NoticeService implements BoardService{
	@Autowired
	private NoticeDAO noticeDAO;
	
	

	@Override
	public List<BoardDTO> getList(Long page) throws Exception {
		// TODO Auto-generated method stub
		
			Long perPage=10L;
		      Long startRow =(page-1)*perPage+1;
		      Long lastRow =page*perPage;
		      System.out.println("page" +page);
		      System.out.println("startRow:"+startRow);
		      System.out.println("lastRow:"+lastRow);
		      
		      Map<String, Long> map = new HashMap<String, Long>();
		      map.put("startRow", startRow);
		      map.put("lastRow", lastRow);
		      
		return noticeDAO.getList(map);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}

	
}
