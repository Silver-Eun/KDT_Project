package contollerF;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

public class Ex05_MList implements Ex04_Controller {
	
	@Override
	public String doUser(HttpServletRequest request, HttpServletResponse response) {

		// MemberList
		MemberService service = new MemberService();
		request.setAttribute("banana", service.selectList());
		return "member/memberList.jsp";
	} //doUser

} //class
