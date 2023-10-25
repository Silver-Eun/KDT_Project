package com.ncs.green;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.BoardDTO;
import lombok.AllArgsConstructor;
import service.BoardService;

@AllArgsConstructor
@RequestMapping(value = "/board") // "/board"로 시작하는 모든 요청을 처리
@Controller
public class BoardController {

	BoardService service;

	// ** BoardList
	@GetMapping(value = "/boardList")
	public void boardList(Model model) {
		model.addAttribute("banana", service.selectList());
	}

	// ** MemberDetail
	@GetMapping(value = "/bdetail")
	public String bdetail(HttpServletRequest request, Model model, BoardDTO dto) {
		model.addAttribute("apple", service.selectOne(dto));
		// => 글 수정화면 요청인 경우 구분
		if ("U".equals(request.getParameter("jCode")))
			return "board/boardUpdate";		
		else return "board/boardDetail";
	}
	
	// ** 새 글 등록 : insert
	@GetMapping(value = "/boardInsert")
	public void boardInsert() {
		// viewName 생략 -> 요청명이 viewName이 됨
	}
	
	// => Insert Service 처리: POST
	@PostMapping(value = "/binsert")
	public String binsert(BoardDTO dto, Model model, RedirectAttributes rttr) {
		// 1. 요청분석 & Service
		// => 성공 : boardList
		// => 실패 : 재입력 유도 (입력으로 board/boardInsert.jsp)
		String uri = "redirect:boardList"; // 성공
		
		// 2. Service 처리
		if (service.insert(dto) > 0) {
			rttr.addFlashAttribute("message", "새 글 등록 성공!");
		} else {
			model.addAttribute("message", "새 글 등록 실패! 다시 하세요");
			uri ="board/boardInsert";
		}
		
		// 3. View
		return uri;
	}
	
	// ** Board Update
	// => 성공 : boardDetail
	// => 실패 : boardUpdate
	@PostMapping(value = "/bupdate")
	public String bUpdate(BoardDTO dto, Model model) {
		
		// => 처리결과에 따른 화면 출력을 위해서 dto의 값을 Attribute에 보관
		model.addAttribute("apple", dto);
		String uri = "board/boardDetail";
		
		// => Service 처리
		if (service.update(dto) > 0) {
			model.addAttribute("message", "회원정보 수정 성공");
		} else {
			model.addAttribute("message", "회원정보 수정 실패! 다시 하세요");
			uri = "board/boardUpdate";
		}
		return uri;
	}
	
	// ** Board Delete
	@GetMapping(value = "/bdelete")
	public String bdelete(BoardDTO dto, Model model, RedirectAttributes rttr) {

		String uri = "redirect:boardList";
		
		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "삭제 성공");
		} else {
			rttr.addFlashAttribute("message", "삭제 실패");
		}
		
		return uri;
	}
}
