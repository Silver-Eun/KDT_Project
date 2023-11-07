package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.JoDTO;
import com.example.demo.service.JoService;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;

@RequestMapping(value="/jo")
@AllArgsConstructor
@Controller
public class JoController {
	JoService service;
	MemberService mservice;
	 
	// ** JoList
	@GetMapping(value="/joList")
	public void joList(Model model) {
		model.addAttribute("banana", service.selectList());
	}
	
	// ** JoDetail
	@GetMapping(value="/jdetail")
	public String jdetail(HttpServletRequest request, Model model, JoDTO dto) {
		
		String uri = "jo/joDetail";
		model.addAttribute("apple", service.selectOne(dto));
		if ( "U".equals(request.getParameter("jCode")) )
			uri = "jo/joUpdate";
		
		model.addAttribute("banana", mservice.joList(dto.getJno()));
		
		return uri;
	}
	
	// ** Jo_Insert
	@GetMapping(value="/joInsert")
	public void joInsert() {
		// viewName 생략
	}
	
	// => jo_insert 처리
	@PostMapping(value="/jinsert")
	public String jinsert(Model model, JoDTO dto, RedirectAttributes rttr) {
		String uri="redirect:joList";
		
		if ( service.insert(dto)>0 ) {
			rttr.addFlashAttribute("message", "Jo_Insert 성공");
		}else {
			model.addAttribute("message", "Jo_Insert 실패, 다시 하세요");
			uri="jo/joInsert";
		}
		
		return uri;
	}
	
	// ** Update
	@PostMapping(value="/jupdate")
	public String jupdate(HttpServletRequest request, Model model, JoDTO dto, RedirectAttributes rttr) {
		model.addAttribute("apple", dto);
		String uri="redirect:joList";
		
		if ( service.update(dto)>0 ) {
			rttr.addFlashAttribute("message", "~~ Jo 정보 수정 성공 ~~");
		}else {
			model.addAttribute("message", "~~ Jo 정보 수정 실패 , 다시 하세요 ~~");
			uri="jo/joUpdate";
		}
		
		return uri;
	}
	
	// ** Delete
	@GetMapping(value="/jdelete")
	public String jdelete(JoDTO dto, RedirectAttributes rttr) {
		String uri="redirect:joList";
		if ( service.delete(dto)>0 ) {
			rttr.addFlashAttribute("message", "Jo 삭제 성공");
		}else {
			rttr.addFlashAttribute("message", "Jo 삭제 실패");
		}
		
		return uri;
	}
	
}

