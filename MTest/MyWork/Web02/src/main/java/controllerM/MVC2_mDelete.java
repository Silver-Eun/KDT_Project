package controllerM;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

@WebServlet("/delete")
public class MVC2_mDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MVC2_mDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청분석 & Service
		// => 삭제할 대상 (request의 Parameter로 전달됨)		
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		dto.setId(request.getParameter("loginId"));
		
		// 2. 결과
		// => 삭제 성공 / 실패 -> list 출력 ("list2"로 Forward)
		// => message 출력
		if (service.delete(dto) > 0) {
			// 성공
			request.setAttribute("message", dto.getId() + "님 삭제성공");
		} else {
			// 실패
			request.setAttribute("message", dto.getId() + "님 삭제실패");
		}
		
		request.getRequestDispatcher("list").forward(request, response);
	}

}
