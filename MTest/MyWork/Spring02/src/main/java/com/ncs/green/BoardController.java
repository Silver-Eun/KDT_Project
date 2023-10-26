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
//import lombok.extern.log4j.Log4j;
import service.BoardService;


//@Log4j
@AllArgsConstructor // @Autowired 를 사용하지 않아도됨
@RequestMapping(value="/board") // "/board" 로 시작하는 모든 요청을 처리 
@Controller
public class BoardController {
	
	BoardService service;
	
	// ** replyInsert
	// => replyInsert Form 출력 메서드
	//    bdetail 화면에서 요청시 퀴리스트링으로 보낸 부모글의 root, step, indent 를 
	//    replyInsert Form 으로 전달
	// => replyInsert Form 에서는 이값들을 hidden 으로 숨겨놓음 (rinsert 위해 필요함)
	
	// => 매핑메서드의 인자로 정의된 dto 는 request.setAttribute 와 동일 scope
	//    그러므로 response 출력 전까지는 사용가능
	//    단, 클래스명의 첫글자를 소문자로 ...  ${boardDTO.root}
	// 	  그러므로 아래와같은 구문은 필요없음.
	//	  model.addAttribute("apple", dto);
	@GetMapping(value="/replyInsert")
	public void replyInsert(BoardDTO dto) {
		// viewName 생략
	}
	@PostMapping(value="/rinsert")
	public String rinsert(BoardDTO dto, Model model, RedirectAttributes rttr) {
		// ** 답글등록
		// => SQL구문 : reply_insert, step_update
		// => 성공 : boardList
		//    실패 : replyInsert 입력폼으로
		String uri="redirect:boardList";
		
		// => dto 의 값
		//	-> id, title, content : 사용가능
		//	-> 부모글의 root : 동일 
		//	-> 부모글의 step, indent : 1씩 증가 
		dto.setStep(dto.getStep()+1);
		dto.setIndent(dto.getIndent()+1);
		if ( service.rinsert(dto) > 0 ) {
			rttr.addFlashAttribute("message", "답글 등록 성공");
		}else {
			uri="board/replyInsert";
			model.addAttribute("message", "답글 등록 실패! 다시하세요");
		}
		return uri;
	} //rinsert
	
	// ** BoardList
	@GetMapping(value="/boardList")
	public void boardList(Model model) {
		model.addAttribute("banana", service.selectList());
	}
	
	// ** BoardDetail
	// => 조회수 증가 조건
	//	-> 글보는이(loginID)와 글쓴이가 다를때 
	//	-> 글보는이(loginID)가 "admin"이 아닌경우 
	//	-> 수정요청이 아닌경우
	// => 조회수 증가 처리 
	//	-> Table 의 cnt=cnt+1
	//	-> Update 메서드 활용
	//		- mapper 의 xml 수정 (Mybatis)
	//		- bUpdateForm 에서 cnt값 전달 가능하도록 수정
	@GetMapping(value ="/bdetail")
	public String bdetail(HttpServletRequest request, Model model, BoardDTO dto) {
		// 1) Detail Service 처리
		dto = service.selectOne(dto);
		
		// 2) 조회수 증가
		// => get loginID 
		String loginID = (String)request.getSession().getAttribute("loginID");
		// => 조회수 증가 조건
		if ( !"admin".equals(loginID) && 
			 !dto.getId().equals(loginID) &&
			 !"U".equals(request.getParameter("jCode")) ) {
			// => 조회수 증가 처리
			dto.setCnt(dto.getCnt()+1);
			service.update(dto);
		}
		
		// 3) model & view 처리
		// => 글 수정화면 요청인 경우 구분 
		
		model.addAttribute("apple", dto);
		if ( "U".equals(request.getParameter("jCode")) )
			 return "board/boardUpdate";
		else return "board/boardDetail";
	} //bdetail

	// ** 새글등록: Insert 
	@GetMapping(value="/boardInsert")
	public void boardInsert() {
		// viewName 생략 -> 요청명이 viewName 이 됨
	}
	// => Insert Service 처리: POST
	@PostMapping(value="/binsert")
	public String binsert(BoardDTO dto, Model model, RedirectAttributes rttr) {
		// 1. 요청분석 & Service
		// => 성공: boardList
		// => 실패: 재입력 유도 (입력폼 으로, board/boardInsert.jsp)
		String uri="redirect:boardList"; // 성공
		
		// 2. Service 처리
		if ( service.insert(dto) > 0 ) {
			rttr.addFlashAttribute("message", "새 글 등록 성공");
		}else {
			model.addAttribute("message", "새 글 등록 실패! 다시하세요");
			uri="board/boardInsert";
		}
		
		// 3. View 
		return uri;
	} // binsert
	
	// ** Board Update
	// => 성공: boardDetail
	// => 실패: boardUpdate
	@PostMapping(value="/bupdate")
	public String bupdate(BoardDTO dto, Model model) {
		
		// => 처리결과에 따른 화면 출력을 위해서 dto 의 값을 Attribute에 보관
		model.addAttribute("apple", dto);
		String uri="board/boardDetail";
		
		// => Service 처리
		if ( service.update(dto) > 0 ) {
			model.addAttribute("message", "글 수정 성공");
		}else {
			model.addAttribute("message", "글 수정 실패! 다시 하세요");
			uri="board/boardUpdate";
		}
		return uri;
	} //bupdate
	
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
	} // bdelete
	
} //class
