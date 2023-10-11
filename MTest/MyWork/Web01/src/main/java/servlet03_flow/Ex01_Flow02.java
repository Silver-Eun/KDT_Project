package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ** PageFlow 실습
// => testForm: servletTestForm/flow02_TestForm.jsp

@WebServlet("/flow02")
public class Ex01_Flow02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex01_Flow02() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청(request) 분석
		// => select의 선택된 value의 값에 따라 uri 결정
		// 	  radio의 선택값에 따라 Forward or Redirect 결정
		String page = request.getParameter("page");
		String uri = "";
		if ( page.equals("1") ){
			uri = "helloS";
		} else if ( page.equals("2") ) {
			uri = "lifecycle";
		} else if ( page.equals("3") ) {
			uri = "servletTestForm/form03_Check.jsp";
		} else if ( page.equals("4") ) {
			uri = "servletTestForm/form04_Select.jsp";
		}

		// => console로 확인
		System.out.println("** flow02 Test **");

		// => Forward or Redirect
		if ( request.getParameter("send").equals("f") ) {
			request.getRequestDispatcher(uri).forward(request, response);
		} else if ( request.getParameter("send").equals("r")) {
			response.sendRedirect(uri);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
