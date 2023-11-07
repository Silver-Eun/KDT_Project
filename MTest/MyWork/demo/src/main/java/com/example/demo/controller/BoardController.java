package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.BoardDTO;
import com.example.demo.service.BoardService;

import criTest.PageMaker;
import criTest.SearchCriteria;
import lombok.AllArgsConstructor;


//@Log4j
@AllArgsConstructor // @Autowired 를 사용하지 않아도됨
@RequestMapping(value="/board") // "/board" 로 시작하는 모든 요청을 처리 
@Controller
public class BoardController {
	
	BoardService service;
	
	@GetMapping("/bcriList")
	 public void bcriList(Model model, SearchCriteria cri, PageMaker pageMaker) {
	    cri.setSnoEno();
	    
	    model.addAttribute("banana", service.bcriList(cri));
	    
	    pageMaker.setCri(cri);
	    pageMaker.setTotalRowsCount(service.criTotalCount(cri)); // 전체 rows 갯수: ver01
	    
	    model.addAttribute("pageMaker", pageMaker);
	 }
	
	@GetMapping(value="/replyInsert")
	public void replyInsert(BoardDTO dto) {
		// viewName 생략
	}
	
	@PostMapping(value="/rinsert")
	public String rinsert(BoardDTO dto, Model model, RedirectAttributes rttr) {
		String uri="redirect:boardList";
		
		dto.setStep(dto.getStep()+1);
		dto.setIndent(dto.getIndent()+1);
		if ( service.rinsert(dto) > 0 ) {
			rttr.addFlashAttribute("message", "답글 등록 성공");
		}else {
			uri="board/replyInsert";
			model.addAttribute("message", "답글 등록 실패! 다시하세요");
		}
		return uri;
	}
	
	// ** BoardList
	@GetMapping(value="/boardList")
	public void boardList(Model model) {
		model.addAttribute("banana", service.selectList());
	}
	
	@GetMapping(value ="/bdetail")
	public String bdetail(HttpServletRequest request, Model model, BoardDTO dto) {
		dto = service.selectOne(dto);
		
		String loginID = (String)request.getSession().getAttribute("loginID");
		
		if ( !"admin".equals(loginID) && 
			 !dto.getId().equals(loginID) &&
			 !"U".equals(request.getParameter("jCode")) ) {
			dto.setCnt(dto.getCnt()+1);
			service.update(dto);
		}
		
		model.addAttribute("apple", dto);
		if ( "U".equals(request.getParameter("jCode")) )
			 return "board/boardUpdate";
		else return "board/boardDetail";
	}

	// ** 새글등록: Insert 
	@GetMapping(value="/boardInsert")
	public void boardInsert() {
		// viewName 생략 -> 요청명이 viewName 이 됨
	}
	
	// => Insert Service 처리: POST
	@PostMapping(value="/binsert")
	public String binsert(BoardDTO dto, Model model, RedirectAttributes rttr) {
		String uri="redirect:boardList";
		
		if ( service.insert(dto) > 0 ) {
			rttr.addFlashAttribute("message", "새 글 등록 성공");
		}else {
			model.addAttribute("message", "새 글 등록 실패! 다시하세요");
			uri="board/boardInsert";
		}
				
		return uri;
	}
	
	// ** Board Update
	// => 성공: boardDetail
	// => 실패: boardUpdate
	@PostMapping(value="/bupdate")
	public String bupdate(BoardDTO dto, Model model) {
		
		model.addAttribute("apple", dto);
		String uri="board/boardDetail";
		
		if ( service.update(dto) > 0 ) {
			model.addAttribute("message", "글 수정 성공");
		}else {
			model.addAttribute("message", "글 수정 실패! 다시 하세요");
			uri="board/boardUpdate";
		}
		return uri;
	}
	
	// ** Board Delete
	@GetMapping(value="/bdelete")
	public String bdelete(BoardDTO dto, RedirectAttributes rttr) {
		
		String uri = "redirect:boardList";
		if ( service.delete(dto) > 0 ) {
			 rttr.addFlashAttribute("message", "글 삭제 성공") ;	
		}else {
			 rttr.addFlashAttribute("message", "글 삭제 실패!");
		}
		return uri;
	}
	
}
