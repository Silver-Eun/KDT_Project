package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcTest.StudentDTO;
import mvcTest.StudentService;

@WebServlet("/login")
public class Ex04_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex04_Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청분석
		// => 한글, request의 Parameter 처리
		request.setCharacterEncoding("UTF-8");

		int sno = 0;
		if (request.getParameter("sno") != null && request.getParameter("sno").length() > 0) {
			sno = Integer.parseInt(request.getParameter("sno"));
		}
		
		String name = request.getParameter("name");

		// 2. 서비스 처리
		// => Service, DTO 객체 생성
		// => sno로 확인 ( selectOne 메소드)
		// => 존재하면 name 확인 ( DTO의 name과 Parameter로 전달된 name과 )
		String uri = "index.jsp";
		StudentService service = new StudentService();
		StudentDTO dto = new StudentDTO();
		dto.setSno(sno);
		dto = service.selectOne(dto);
		if (dto != null && dto.getName().equals(name)) {
			// => dto 객체에는 해당 학생의 Detail 정보가 모두 담겨있음
			// => name의 일치 확인
			// 성공 : index.jsp로
			// => ~~ 님 : index 화면에 항상 이름이 표시되도록
			// => 그러므로 로그인 정보 보관 ( session에 )
			request.getSession().setAttribute("loginName", name);
			System.out.println("로그인 성공");
		} else {
			// => 실패 : loginForm으로 ( 재로그인 유도 )
			// => loginForm에 '로그인 실패!'
			// String message = "로그인 실패!";
			// => 이러한 값들을 다른 서블릿 또는 jsp 문서와 공유하기위한 방법이 Attribute
			//	  이 Attribute 값이 메모리에서 유지되는 시간이 4종류 -> scope
			// scope 4종류 : page < request < session < application
			request.setAttribute("message", "로그인 실패!");
			uri = "servletTestForm/flowEx04_LoginForm.jsp";
		}

		// 3. View (Response) : Forward
		request.getRequestDispatcher(uri).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
