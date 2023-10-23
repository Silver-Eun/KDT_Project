package com.ncs.green;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.MemberDTO;
import service.MemberService;

// ** Bean 생성하는 @
// * Java : @Component
// * Spring 세분화 됨
// => @Controller,  @Service,  @Repository
//    스프링 프레임웤 이 역할별로 객체를 인식할 수 있도록
// => @Controller 
//  -> interface 없이도 Controller로 인식
//  -> 오버라이딩 의무가 없어짐 (메서드명, 매개변수, 리턴값 자유) 
//  -> 하나의 컨트롤러에 여러 개의 메서드를 작성할 수 있고,
//     메서드 단위로 매핑 ( @RequestMapping )
//  -> 일반적으로 Table 단위로 컨트롤러를 구현

@Controller
public class MemberController {

	@Autowired
	MemberService service;

	// ** MemberList Login & Logout
	@RequestMapping(value = "/mlist", method = RequestMethod.GET)
	public String mlist(Model model) {
		model.addAttribute("banana", service.selectList());
		return "member/memberList";
	}

	// ** MemberDetail
	@RequestMapping(value = "/mdetail", method = RequestMethod.GET)
	public String mdetail(Model model, MemberDTO dto) {
		// dto.setId("검색id");
		model.addAttribute("apple", service.selectOne(dto));
		return "member/memberDetail";
	}

	// ** Member Login....
	// => LoginForm : Get
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}

	// => Login 처리 : Post
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, Model model, MemberDTO dto) {
		// ** 로그인 Service 처리
		// 1. 요청분석
		// => request로 전달되는 id, password 처리:
		// 메소드 매개변수로 MemberDTO를 정의해주면 자동 처리
		// (Parameter name과 일치하는 setter를 찾아 값을 할당해줌)
		// => 전달된 password 보관
		String password = dto.getPassword();
		String uri = "redirect:home";
		// "home" : home.jsp (성공)
		// "redirect:home" -> home를 재요청

		// 2. Service 처리
		// => id 확인
		// => 존재하면 Password 확인
		// => 성공 : id, name은 session에 보관, home으로
		// => 실패 : 재로그인 유도
		dto = service.selectOne(dto);
		if (dto != null && dto.getPassword().equals(password)) {
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("loginName", dto.getName());
		} else {
			uri = "member/loginForm";
			model.addAttribute("message", "로그인 실패! 다시하세요");
		}

		System.out.println("** Login Post 처리 준비중 **");
		// return "member/loginForm";
		return uri;
	}

	// => Logout
	// => session 무효화, home으로
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpSession session, Model model, RedirectAttributes rttr) {
		session.invalidate();
		
		// model.addAttribute("message", "로그아웃 성공");

		// => 단, request에 보관한 값들은 사라지므로 위의 메세지 처리를 고려해야함
		// => session에 보관
		// => 그리고 session 무효화를 하지 않더라도 이 메세지는 사용 후 삭제를 해야함
		//	  session.setAttribute("message", "로그아웃 성공");
		// => 이렇게 redirect 하는경우 메시지처리 등을 편리하게 
	    //    지원해주는 객체가 RedirectAttributes
		rttr.addFlashAttribute("message", "로그아웃 성공");
		return "redirect:home";
	}
	
	// ** Join 기능
	// => joinForm : GET
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String memberJoin() {
		return "member/memberJoin";
	}
	// => Join Service 처리: POST
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(MemberDTO dto, Model model) {
		// 1. 요청분석 & Service
		// => 한글처리 필수 : web.xml에서 filter로 처리
		// => request Parameter 처리 : 매개변수로 MemberDTO 정의하면 자동으로 set
		// => 성공 : 로그인 유도 (LoginForm으로 member/loginForm.jsp)
		// => 실패 : 재가입 유도 (JoinForm으로 member/memberJoin.jsp)
		String uri = "member/loginForm";
		
		// 2. Service 처리
		if (service.insert(dto) > 0) {
			model.addAttribute("message", "회원가입 성공! 로그인 후 이용하세요");
		} else {
			uri ="member/memberJoin";
			model.addAttribute("message", "회원가입 실패! 다시 하세요");
		}
		
		// 3. View
		return uri;
	}
	
	// ** Member Update
	
	// ** Member Delete : 탈퇴
	// => 삭제대상 : Parameter로 전달, dto에 자동 set
	@RequestMapping(value = "/mdelete", method = RequestMethod.GET)
	public String mdelete(HttpSession session, MemberDTO dto, Model model, RedirectAttributes rttr) {
		
		// 1) 본인 탈퇴
		// 결과 : message(삭제 성공/실패), home.jsp, session 무효화
				
		// 2) 관리자에 의한 강제 탈퇴
		// 결과 : message(삭제 성공/실패), memberList.jsp
		
		// => 본인탈퇴 or 관리자에 의한 강제탈퇴 구분 필요
		//	  dto의 id와 session의 loginID가 같으면 본인탈퇴,
		//	  다르면서 session의 loginID 값이 'admin'이면 강제탈퇴
		String uri = "home";
		if (service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "탈퇴성공, 1개월 후 재가입 가능");
			if (((String)session.getAttribute("loginID")).equals("admin")) {
				// => 관리자에 의한 강제탈퇴
				uri = "redirect:mlist";
			} else {
				// => 본인탈퇴
				session.invalidate();
			}
		} else {
			rttr.addFlashAttribute("message", "탈퇴실패");
		}
		
		return uri;
	}
}
