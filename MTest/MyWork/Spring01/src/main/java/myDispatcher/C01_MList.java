package myDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

public class C01_MList implements MyController {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// MemberList
		MemberService service = new MemberService();
		request.setAttribute("banana", service.selectList());
		return "member/memberList";
	}

}
