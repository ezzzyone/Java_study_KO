package com.ko.home.bankmembers;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ko.home.BankAccount.BankAccountDAO;
import com.ko.home.BankAccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private BankAccountDAO bankAccountDAO;

	
	//로그인
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	//회원가입
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext)throws Exception{
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);

		//파일 저장시에 파일의 경로는 톰캣기준X, 운영체제OS기준으로 설정
		
		//1.파일 저장위치
		//    /resources/upload/member
		
		//2.저장할 폴더의 실제 경로 반환(OS기준)
		String realpath =  servletContext.getRealPath("resources/upload/member");
		System.out.println("파일경로" + realpath);
		
		
		//3.저장할 폴더의 정보를 가지는 자바 객체 생성
		File file = new File(realpath);
		
		
		//if(photo.getSize()!=0) {}
		if(!photo.isEmpty()) {
		if(!file.exists()) {
			file.mkdirs();
			};
		
		
		//4.중복되지 않는 파일명 생성
		// --시간, 자바 클래스 (java api)이용
		
		String fileName = UUID.randomUUID().toString();
		//System.out.println("fileName: "+fileName);
		
		Calendar ca = Calendar.getInstance();
		Long time = ca.getTimeInMillis();
		System.out.println(time);
		//저장된 파일 정보를 DB에 저장
		
		fileName = fileName+"_"+photo.getOriginalFilename(); //확장자만 뽑아옴
		System.out.println("fileName+확장자: "+fileName);
		
		//5.HDD에 파일 저장
		//사전준비 : 어느 폴더에 어떤 이름을 저장할 파일 객체 생성
		file = new File(file, fileName); //경로이름, 저장할 이름
	
		//1)MultipartFile 클래스의 transferInTo 메서드 이용
		photo.transferTo(file);
		
		//2)FileCopyUtils 클래스의 copy 메서드 이용
		BankMemberFileDTO bankMemberFileDTO = new BankMemberFileDTO();
		bankMemberFileDTO.setFileName(fileName);
		bankMemberFileDTO.setFileNum(time);
		bankMemberFileDTO.setOriName(photo.getOriginalFilename());
		bankMemberFileDTO.setUserName(bankMembersDTO.getUserName());
		bankMembersDAO.setAddFile(bankMemberFileDTO);
		
		}//isEmpty끝
		
		return result;
	}
	
	//아이디검색
	public List<BankMembersDTO> getSearchByID(String search)throws Exception{
		return bankMembersDAO.getSearchByID(search);
		
	
	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
		
	}
	/*
	 * public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO)throws
	 * Exception{ Map<String, Object> map = new HashMap<String, Object>();
	 * 
	 * List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
	 * bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO); map.put("list",
	 * ar); map.put("dto", bankMembersDTO); return map;
	 * 
	 * 
	 * }
	 */
}
