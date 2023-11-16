package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.GuestBookDTO;
import com.example.demo.entity.GuestBook;
import com.example.demo.service.GuestBookService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {

	GuestBookService service;

	@GetMapping("/home")
	public void home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
	} // home

	@GetMapping("/axtestform")
	public String axTestForm() {
		return "/axTest/axTestForm";
	}

	@GetMapping("/ginsert")
	public String ginsert() {

		GuestBookDTO dto = GuestBookDTO.builder().title("JPA Test").content("Spring Boot Jpa Test").writer("admin")
				.build();
		System.out.println("guest SAVE => " + service.register(dto));

		return "redirect:home";
	}

	@GetMapping("/guestlist")
	public String guestlist() {

		List<GuestBook> list = service.selectList();
		for (GuestBook g : list) {
			System.out.println(g+", regDate:"+g.getRegDate()
            					+", modDate:"+g.getModDate());
		}

		return "redirect:home";
	}

	@GetMapping("/gupdate")
	public String gupdate() {

		GuestBookDTO dto = GuestBookDTO.builder().gno(2l).title("JPA Update Test").content("스프링부트 Jpa Update Test")
				.writer("admin").build();
		System.out.println("guest Update => " + service.register(dto));

		return "redirect:home";
	}

	@GetMapping("/gdetail")
	// => 퀴리스트링으로 Test : /gdetail?gno=2
	public String gdetail(Long gno) {
		System.out.println("gdetail => " + service.selectOne(gno));
		return "redirect:home";
	}

	@GetMapping("/gdelete")
	// => 퀴리스트링으로 Test : /gdelete?gno=3
	public String gdelete(Long gno) {
		try {
			service.delete(gno);
			System.out.println("** gdelete 삭제성공 **");
		} catch (Exception e) {
			System.out.println("** gdelete Exception => " + e.toString());
			// 자료가 없으면 org.springframework.dao.EmptyResultDataAccessException 발생확인
		}

		return "redirect:home";

	}

}
// class
