package com.ko.home.util;

import java.util.HashMap;
import java.util.Map;

public class Pager {
	
	//멤버변수
	/**
	 * 파라미터를 담을 변수
	 * jsp에서 꺼내서 사용할 변수
	 * mapper에서 꺼내서 사용할 변수
	 * perPage : 한페이지에 출력할 글의 갯수
	 * perBlock: 한페이지에 출력할 번호의 갯수
	 * */
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long perBlock;
	
	private String search;
	private String kind;
	
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	//이전블럭의 유무- 이전 블럭있으면 true
	private boolean pre;
	//다음 블럭 유무
	private boolean next;
	
	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Pager() {
		this.perPage=5L;
		this.perBlock=5L;
	}
	
	//1. mapper에서 사용할 값 계산
	public void getRowNum()throws Exception{
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
		System.out.println("startRow"+startRow);
		System.out.println(lastRow);
		System.out.println(page);
	}
	
	//2. Jsp에서 사용할 값 계산
	public void getNum(Long totalCount)throws Exception{
		//2. totalCount로 totalPage구하기
		Long totalPage=totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		//totalpage보다 page가 더 클경우
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
		
		//3. totalPage로 totalBlock 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0) {
			totalBlock++;
		}
		
		//4. page로 curBlock 찾기
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum , lastNum 구하기
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		//6.curblock이 마지막 block (totalpage)
		if(curBlock==totalBlock) {
		this.lastNum=totalPage;	
		}
		
		//7.이전/다음블럭 유무
		if(curBlock>1) {
			pre = true;
		}
		
		if(curBlock<totalBlock) {
			next=true;
		}
		
	}
	
	
	
	
	
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}




	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}




	public Long getPerBlock() {
		return perBlock;
	}




	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}




	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return this.lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
	
	
	

}
