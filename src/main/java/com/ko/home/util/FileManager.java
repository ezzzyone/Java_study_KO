package com.ko.home.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	//servletContext 선언방법들. 1.멤버변수 선언/주입 2.매개변수로 받아오기
	
	//@Autowired
	//private ServletContext servletContext;
	
	public String saveFile(ServletContext servletContext, String path, MultipartFile multipartFile)throws Exception{
		//realpath에서 꺼내쓰기 위해 path 매개변수로 받아옴
		
		String realPath = servletContext.getRealPath(path);
		
	//폴더(directory) 경로 체크
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
	
	//저장할 파일명 생성 
		
		String fileName = UUID.randomUUID().toString();
		//확장자 붙이기
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
	//	HDD저장 
		
		file = new File(file, fileName);
		multipartFile.transferTo(file);
		
		return fileName;
	
	}
	

}
