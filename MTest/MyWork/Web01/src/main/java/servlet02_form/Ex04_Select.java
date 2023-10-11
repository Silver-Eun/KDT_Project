package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class Ex04_Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex04_Select() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) 요청분석
		// => 한글처리, Parameter처리 (Get 방식은 생략가능)
		request.setCharacterEncoding("UTF-8");

		// => job 단일선택 select
		String job = request.getParameter("job");

		// => interest 복수선택 select
		String[] interest = request.getParameterValues("interest");

		// 2) Service 처리
		// 3) 결과 (View) 처리
		// => 한글처리, 출력 객체 생성 & response에 담기
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>** Select Test **</h2>");
		out.print("<h3>직업</h3>");
		if (job == "") {
			out.print("선택된 직업이 없음<br>");
		} else {
			out.print(job);
		}
		out.print("<h3>관심분야</h3>");
		if (interest == null) {
			out.print("선택된 관심분야가 없음");
		} else {
			for (String s : interest) {
				out.print(s + "<br>");
			}
		}
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 선택하기</a></h2><br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("* Post Test **");
		doGet(request, response);
	}

}
