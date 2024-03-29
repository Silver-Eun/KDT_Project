package contollerF;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** FrontController 패턴 2.
//=> Factory 패턴 적용
// - ServiceFactory
// - 개별컨트롤러(일반클래스) : 일관성을 위해 강제성 부여 ( interface 사용 )

@WebServlet(urlPatterns={"*.do"})
//=> @, web.xml 방식
public class Ex02_FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex02_FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청(request) 분석
    	// => url 또는 uri 분석해서 요청명 확인
    	// => 한글처리
		request.setCharacterEncoding("UTF-8");
		String uri=request.getRequestURI();
		String mappingName = uri.substring(uri.lastIndexOf("/"));
		uri="index.jsp";
		
		// 2. 해당 서비스 실행
		// => ServiceFactory 에 요청
		// => uri 를 전달하면 해당 서비스컨트롤러 를 생성해서 인스턴스를 제공 
		// Ex03_ServiceFactory sf = new Ex03_ServiceFactory(); -> 불가능
		// ** 싱글턴 패턴 적용
		Ex03_ServiceFactory sf = Ex03_ServiceFactory.getInstance();
		// => 싱글턴 패턴 Test
		Ex03_ServiceFactory sf1 = Ex03_ServiceFactory.getInstance();
		Ex03_ServiceFactory sf2 = Ex03_ServiceFactory.getInstance();
		System.out.printf("** 싱글턴 패턴 Test: sf=%s, sf1=%s, sf2=%s \n",sf, sf1, sf2);
		
		// => ServiceFactory 에 서비스컨트롤러 요청
		Ex04_Controller controller = sf.getController(mappingName);
		
		if ( controller!=null ) {
			uri = controller.doUser(request, response);
		}else  {
			request.setAttribute("message", "없는 요청입니다");
		}
		
		// 3. View 처리
		request.getRequestDispatcher(uri).forward(request, response);
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} //doPost

} //class
