package com.ko.home.file;

public class FIleDTO {

	
	private Long fileNum;
	private String fileName;
	public Long getFileNum() {
		return fileNum;
	}
	public void setFileNum(Long fileNum) {
		
		this.fileNum = fileNum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	private String oriName;
}
