package servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class Ex04_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int cno=1; // 생성자 메소드 호출 횟수
	int ino=1; // init 메소드 호출 횟수
	int dno=1; // destory 메소드 호출 횟수
	int gno=1; // doGet 메소드 호출 횟수
	
	// ** 생성자
	// => 서버스타트 이후 첫요청 들어오면 WAS 자동 생성
    public Ex04_LifeCycle() {
        super();
        System.out.println("** 생성자 메소드 호출 횟수 => " + cno++);
    }

    // ** init 메소드
    // => 인스턴스 생성 직후 자동 호출
	public void init(ServletConfig config) throws ServletException {
		System.out.println("** init 메소드 호출 횟수 => " + ino++);		
	}

	// ** destroy 메소드 : 메모리 소멸
	// => 서버종료시 (서버는 모든 자원을 close)
	public void destroy() {
		System.out.println("** destroy 메소드 호출 횟수 => " + dno++);		
	}

	// ** doGet 메소드 : 메모리 소멸
	// => 클라이언트로부터 Get 방식 요청시 들어오면 자동 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>** Servlet LifeCycle **</h2>");
		out.print("<pre><h3>");
		out.print("** 현재시간 : " + new Date());
		out.print("** destroy 메소드 호출 횟수 => " + gno);
		out.print("</h3></pre>");
		
		System.out.println("** doGet 메소드 호출 횟수 => " + gno++);
	}

}
