package com.itwillbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// 서비스객체 주입
	@Inject
	BoardService bService;
	
	// 게시판 글쓰기 - GET
	@GetMapping(value = "/regist")
	public void registGET() throws Exception {
		logger.debug("게시판 글쓰기 GET - 사용자의 정보 입력 ");
		logger.debug("연결된 view 페이지 이동");
		
		
	}
	
	// 게시판 글쓰기 - POST
	@PostMapping(value = "/regist")
	public String registPOST(BoardVO vo) throws Exception {
		logger.debug("게시판 글쓰기 POST - 입력된 데이터 처리");
		// 한글 인코딩(web.xml 필터 처리)
		// 전달정보 저장
		logger.debug("vo : " + vo);
		// 서비스 - DAO 에 동작 호출
		bService.regist(vo);
		// 페이지 이동
		return "redirect:/board/list";
	}
	
	
	
	
}
