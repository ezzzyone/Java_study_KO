package com.ko.home.board.impl;

import java.util.List;
import java.util.Map;

import com.ko.home.util.Pager;

public interface BoardDAO {
	
	
	//글목록
	 public List<BoardDTO> getList(Pager pager)throws Exception;
	
	//글상세
	public BoardDTO getDetail(BoardDTO boardDTO ) throws Exception;
	
	//글쓰기
	public int setAdd(BoardDTO boardDTO) throws Exception;
	//글수정
	public int setUpdate(BoardDTO boardDTO ) throws Exception;
	//글삭제
	public int setDelete(BoardDTO boardDTO ) throws Exception;
	
	public Long getCount(Pager pager) throws Exception;
}
