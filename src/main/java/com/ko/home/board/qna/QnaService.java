package com.ko.home.board.qna;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.board.impl.BoardDTO;
import com.ko.home.board.impl.BoardService;
import com.ko.home.board.notice.NoticeDAO;
import com.ko.home.util.Pager;
@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private ServletContext servletContext;

	   public int setReply(QnaDTO qnaDTO) throws Exception {
			
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
	      
	      qnaDTO.setRef(parent.getRef());
	      qnaDTO.setStep(parent.getStep()+1);
	      qnaDTO.setDepth(parent.getDepth()+1);
	      
	      qnaDAO.setStepUpdate(parent);
	      int result = qnaDAO.setReplyAdd(qnaDTO);
	      
	      return result;
	   }
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		
		Long totalCount = qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		System.out.println("getLastRow"+pager.getLastRow());
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		 int result =qnaDAO.setAdd(boardDTO);
			
			String realpath =servletContext.getRealPath("resources/upload/qna");
			
			File file = new File(realpath);
				if(!file.exists()) 
					file.mkdirs();
				
				Calendar ca = Calendar.getInstance();
				Long time = ca.getTimeInMillis();

				
				for (MultipartFile mf : files) {
					file = new File(realpath);
					String fileName =UUID.randomUUID().toString();
					fileName = fileName+"_"+mf.getOriginalFilename();
					file = new File(file, fileName);
					mf.transferTo(file);
					if(mf.isEmpty()) {
						continue;
					}	
					
					}
					
				
			
		
			return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(boardDTO);
	}
	
	
}
