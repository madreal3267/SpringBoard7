package com.itwillbs.controller;

import java.util.List;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// 서비스객체 주입
	@Inject
	private BoardService bService;	
	
	// http://localhost:8088/board/regist
	
	// 게시판 글쓰기 - GET
	@RequestMapping(value = "/regist",method = RequestMethod.GET)
	public void registGET() throws Exception{
		logger.debug(" 게시판 글쓰기 GET - 사용자의 정보 입력 ");
		logger.debug(" 연결된 view페이지 이동");
	}
	
	// 게시판 글쓰기 - POST
	@RequestMapping(value = "/regist",method = RequestMethod.POST)
	public String registPOST(BoardVO vo,RedirectAttributes rttr) throws Exception{
		logger.debug(" 게시판 글쓰기 POST - 입력된 데이터 처리");
		// 한글 인코딩(필터 처리)
		// 전달정보 저장
		logger.debug(" vo : "+vo);
		logger.debug(" vo : {} ",vo);
		
		// 서비스 -> DAO에 동작 호출
		bService.regist(vo);
		
		// 글쓰기 성공정보를 전달
		rttr.addFlashAttribute("msg", "createOk");
		
		// 페이지 이동		
		return "redirect:/board/listALL";
		//return "redirect:/board/listALL?msg=createOk";
//		return "/board/list";
	}
	
	// * 정보조회 동작, 사용자 정보 입력 => GET방식
	// * 정보를 처리하는 동작(UPDATE,DELETE,INSERT) => POST방식
	
	// http://localhost:8088/board/listALL
	// 게시판 글목록 조회 - GET
	//@RequestMapping(value = "/listALL",method = RequestMethod.GET)
	@GetMapping(value = "/listALL")
	public String listALLGET(Model model) throws Exception{
		logger.debug(" listALLGET() 실행 ");
		
		// 서비스 -> DB의 정보를 가져오기
		List<BoardVO> boardList = bService.listALL();
		logger.debug(" size : "+boardList.size());
		
		// 연결된 뷰페이지로 정보 전달
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	
	// http://localhost:8088/board/read?bno=9
	
	// 게시판 본문보기 - readGET
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public void readGET(Model model,@RequestParam("bno") int bno/* ,@ModelAttribute("bno") int bno */) throws Exception{
		// @ModelAttribute("bno") int bno
		// => 주소줄에 있는 데이터를 가져와서 사용, 연결된 뷰페이지로 이동 $ {bno}
		//   request.getParameter("bno") + request.setAttribute();
		// => 1:N 관계에서 사용 (N - bean(객체),collection)
		
		// @RequestParam("bno") int bno
		// => request.getParameter("bno") 동일함, 자동형변환 포함(문자,숫자,날짜)
		// => 1:1 관계에서 사용
		
		logger.debug(" readGET() 실행 ");
		
		// 전달정보 저장
		logger.debug(" bno : "+bno);
		
		// 글 조회(읽음) 카운트 증가 => 조회수 1증가
		bService.updateReadCnt(bno);
		
		// 서비스 - DAO 저장된 정보를 가져오기
		BoardVO resultVO = bService.getBoard(bno);
		logger.debug(" resultVO : {}",resultVO);
     
		// 전달할 정보를 저장(model)
		model.addAttribute("resultVO", resultVO);
		// 연결된 뷰페이지이동		
		
	}
	
	// 게시판 글 수정하기(기존의 글 정보 확인) - GET
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("bno") int bno, Model model/*@ModelAttribute*/) throws Exception {
		logger.debug(" modifyGET() 실행");
		
		// 전달정보 bno 저장
		logger.debug(" bno : " + bno);
		
		// 서비스 - DAO 글정보 조회 동작
		BoardVO resultVO = bService.getBoard(bno);
		logger.debug("resultVO : {}", resultVO);
		
		// /board/modify.jsp
		
		model.addAttribute("resultVO", resultVO);
		
		
		return "/board/modify";
	}
	
	// 게시판 글 수정하기(글정보 수정) - POST
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo, RedirectAttributes rttr) throws Exception{
		logger.debug("modifyPOST() 실행 ");
		// 한글처리 인코딩(필터)
		// 전달정보 저장
		logger.debug(" 수정할 내용, {}" , vo);
		
		// 서비스 - DAO 글 내용을 수정
		
		// 상태 정보 전달
		rttr.addFlashAttribute("msg", "updateOK");
		
		bService.updateBoard(vo);
		
		// 페이지 이동(listALL.jsp)
		
		return "redirect:/board/listALL";
	}
	
	// 게시판 글 삭제하기(글정보 삭제) - POST
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(RedirectAttributes rttr,/*@ModelAttribute */ /*@RequestParam("bno") */ int bno) throws Exception {
		logger.debug("deletePOST() 실행");
		
		
		logger.debug(" 삭제할 글 번호 : {}", bno);
		bService.deleteBoard(bno);
		
		rttr.addFlashAttribute("msg", "deleteOK");
		
		logger.debug("삭제 처리 완료	");
		return "redirect:/board/listALL";
	}
	

	
}//Controller
