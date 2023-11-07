package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.MemberDTO;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/member")
@Log4j2 // @Log4j // Boot에서는 2015년 이후 지원중단
@AllArgsConstructor // 모든 맴버변수 생성자주입하므로 각각 @Autowired할 필요없음
public class MemberController {
	MemberService service;
	PasswordEncoder passwordEncoder;

	@GetMapping("/memberList")
	public void memberList(Model model) {
		model.addAttribute("banana", service.selectList());
		log.info("** MemberList **");
	}

	// ** MemberDetail
	@GetMapping(value = "/mdetail")
	public String mdetail(HttpServletRequest request, Model model, MemberDTO dto) {
		model.addAttribute("apple", service.selectOne(dto));

		if ("U".equals(request.getParameter("jCode")))
			return "member/memberUpdate";
		else
			return "member/memberDetail";
	}

	// ** Member Login
	@GetMapping(value = "/loginForm")
	public void loginForm() {
		// viewName 생략 -> 요청명이 viewName이 됨
	}

	// => Login 처리 : Post
	@PostMapping(value = "/login")
	public String login(HttpSession session, Model model, MemberDTO dto) {
		String password = dto.getPassword();
		String uri = "redirect:/";
		dto = service.selectOne(dto);

		if (dto != null && passwordEncoder.matches(password, dto.getPassword())) {
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("loginName", dto.getName());
		} else {
			uri = "member/loginForm";
			model.addAttribute("message", "로그인 실패! 다시하세요");
		}

		System.out.println("** Login Post 처리 준비중 **");
		return uri;
	}

	// => Logout
	@GetMapping(value = "/logout")
	public String logOut(HttpSession session, Model model, RedirectAttributes rttr) {
		session.invalidate();

		rttr.addFlashAttribute("message", "로그아웃 성공");
		return "redirect:/";
	}

	// ** Join 기능
	@GetMapping(value = "/memberJoin")
	public void memberJoin() {
		// viewName 생략 -> 요청명이 viewName이 됨
	}

	// => Join Service 처리: POST
	@PostMapping(value = "/join")
	public String join(HttpServletRequest request, MemberDTO dto, Model model) throws IOException {
		String uri = "member/loginForm";

		dto.setPassword(passwordEncoder.encode(dto.getPassword()));

		String realPath = request.getRealPath("/");
		System.out.println("** realPath => " + realPath);

		if (realPath.contains(".eclipse."))
			realPath = "D:\\kdt4_ehs\\MTest\\MyWork\\demo\\src\\main\\webapp\\resources\\uploadImages\\";
		else
			realPath += "resources\\uploadImages\\";

		File f1 = new File(realPath);
		if (!f1.exists()) {
			f1.mkdir();
		}

		f1 = new File(realPath + "basicman4.png");
		if (!f1.isFile()) {
			String basicImagePath = "D:\\kdt4_ehs\\MTest\\MyWork\\demo\\src\\main\\webapp\\resources\\images\\basicman4.png";
			FileInputStream fi = new FileInputStream(new File(basicImagePath));
			FileOutputStream fo = new FileOutputStream(f1);
			FileCopyUtils.copy(fi, fo);
		}

		String file1, file2 = "resources/uploadImages/basicman4.png";

		MultipartFile uploadfilef = dto.getUploadfilef();
		if (uploadfilef != null && !uploadfilef.isEmpty()) {
			file1 = realPath + uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(file1));

			file2 = "resources/uploadImages/" + uploadfilef.getOriginalFilename();
		}

		dto.setUploadfile(file2);

		if (service.insert(dto) > 0) {
			model.addAttribute("message", "회원가입 성공! 로그인 후 이용하세요");
		} else {
			model.addAttribute("message", "회원가입 실패! 다시 하세요");
			uri = "member/memberJoin";
		}

		return uri;
	}

	// ** File Download
	@GetMapping("/download")
	public String download(HttpServletRequest request, Model model, @RequestParam("dnfile") String dnfile) {
		String realPath = request.getRealPath("/");
		String fileName = dnfile.substring(dnfile.lastIndexOf("/") + 1);

		if (realPath.contains(".eclipse."))
			realPath = "D:\\kdt4_ehs\\MTest\\MyWork\\demo\\src\\main\\webapp\\resources\\uploadImages\\";
		else
			realPath += "resources\\uploadImages\\";
		realPath += fileName;

		File file = new File(realPath);
		model.addAttribute("downloadFile", file);

		return "downloadView";
	}

	// ** Member Update
	@PostMapping(value = "/mupdate")
	public String memberUpdate(HttpServletRequest request, MemberDTO dto, Model model) throws IOException {
		model.addAttribute("apple", dto);
		String uri = "member/memberDetail";

		MultipartFile uploadfilef = dto.getUploadfilef();
		if (uploadfilef != null && !uploadfilef.isEmpty()) {
			String realPath = request.getRealPath("/");

			if (realPath.contains(".eclipse."))
				realPath = "D:\\kdt4_ehs\\MTest\\MyWork\\demo\\src\\main\\webapp\\resources\\uploadImages\\";
			else
				realPath += "resources\\uploadImages\\";

			String file1 = realPath + uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(file1));
			String file2 = "resources/uploadImages/" + uploadfilef.getOriginalFilename();
			dto.setUploadfile(file2);
		} // Image 선택

		if (service.update(dto) > 0) {
			model.addAttribute("message", "회원정보 수정 성공");
		} else {
			model.addAttribute("message", "회원정보 수정 실패! 다시 하세요");
			uri = "member/memberUpdate";
		}
		return uri;
	}

	// ** Password Update
	@GetMapping(value = "/pUpdateForm")
	public void pUpdateForm() {

	}

	// ** Password Update
	@PostMapping(value = "/passwordUpdate")
	public String passwordUpdate(HttpServletRequest request, Model model, MemberDTO dto) {
		String id = (String) request.getSession().getAttribute("loginID");
		if (id == null) {
			model.addAttribute("message", "로그인 정보가 없습니다. 로그인하세요");
			return "member/loginForm";
		}

		dto.setId(id);
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));

		String uri = "member/loginForm";
		if (service.update(dto) > 0) {
			request.getSession().invalidate();
			model.addAttribute("message", "비밀번호 수정 성공");
		} else {
			model.addAttribute("message", "비밀번호 수정 실패! 다시 하세요");
			uri = "member/pUpdateForm";
		}

		return uri;
	}

	// ** Member Delete : 탈퇴
	@GetMapping(value = "/mdelete")
	public String mdelete(HttpSession session, MemberDTO dto, Model model, RedirectAttributes rttr) {
		String uri = "redirect:/";
		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "탈퇴성공, 1개월 후 재가입 가능");
			if (((String) session.getAttribute("loginID")).equals("admin")) {
				uri = "redirect:memberList";
			} else {
				session.invalidate();
			}
		} else {
			rttr.addFlashAttribute("message", "탈퇴실패");
		}

		return uri;
	}

	// ** ID 중복확인
	@GetMapping("/idDupCheck")
	public String idDupCheck(MemberDTO dto, Model model) {
		if (service.selectOne(dto) != null) {
			model.addAttribute("idUse", "F");
		} else {
			model.addAttribute("idUse", "T");
		}
		return "member/idDupCheck";
	}
}
