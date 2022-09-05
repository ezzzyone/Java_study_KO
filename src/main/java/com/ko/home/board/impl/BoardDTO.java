package com.ko.home.board.impl;

import java.sql.Date;
import java.util.List;

public class BoardDTO extends CommentDTO{
	

	private String title;
	private Long hit;
	private List<BoardFileDTO> boardFileDTO;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	public List<BoardFileDTO> getBoardFileDTO() {
		return boardFileDTO;
	}
	public void setBoardFileDTO(List<BoardFileDTO> boardFileDTO) {
		this.boardFileDTO = boardFileDTO;
	}
}
	
