package com.example.demo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/rest")
@Log4j2
@AllArgsConstructor
public class RTestController {
	MemberService memberservice;
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/checkdata")
	// => React Connect Test
	public String hello() {
		log.info("React Connect Test 중");
		return "Hello SpringxReact";
	}
}
