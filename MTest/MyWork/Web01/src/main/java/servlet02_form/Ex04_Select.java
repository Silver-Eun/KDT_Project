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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석
		// => request Parameter 처리
		String job=request.getParameter("job");
		String[] interest=request.getParameterValues("interest");
		
		// 2) Service 처리
//		if (mailcheck.equals("Yes")) mailcheck = "수신동의";
//	    else mailcheck = "수신거절";
		
		// 3) 결과 (View) 처리
		// => 한글처리, 출력 객체 생성 & response에 담기
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>** Select Test **</h2>");
		if (job == "") {
			out.print("선택된 직업이 없음<br>");
		} else {
			out.print("<h3>직업</h3>");			
			out.print(job);
			}
		if (interest == null) {
			out.print("선택된 관심분야가 없음");
		} else {
			out.print("<h3>관심분야</h3>");
			for(String s:interest) {
				out.print(s+"<br>");
			}
		}
	}

}
