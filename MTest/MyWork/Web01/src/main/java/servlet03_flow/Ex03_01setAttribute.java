package servlet03_flow;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/01set")
public class Ex03_01setAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex03_01setAttribute() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. request 처리
		// => 한글처리, Parameter 처리
		// => form 없이 쿼리스트링으로 Test
		//	~~/01set?id=banana&name=홍길동&age=22
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		String age = request.getParameter("age");
		//int age = Integer.parseInt(request.getParameter("age"));
		// => 간편한 Test를 위해 String으로 처리
		
		System.out.println("** setAttribute Test **");
		System.out.printf("** Parameter : id = %s, name = %s, age = %s \n **", id, name, age);

		// 2. setAttribute로 보관
		// => 보관 가능한 Scope : Page < Request < Session < Application
		// => Request
		request.setAttribute("rid", id);
		request.setAttribute("rname", name);
		request.setAttribute("rage", age);

		// => Session
		request.getSession().setAttribute("sid", id);
		request.getSession().setAttribute("sname", name);
		request.getSession().setAttribute("sage", age);

		// 3. 이동 후 setAttribute
		// => Forward / Redirect
		String uri = "01get";
		// 3.1) Forward
		//request.getRequestDispatcher(uri).forward(request, response);
		// 3.2) Redirect
		response.sendRedirect(uri);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
