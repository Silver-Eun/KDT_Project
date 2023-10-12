<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Jsp Object **</title>
</head>
<body>
	<h2>** Jsp Object **</h2>
	<pre>
	=> Web 애플리케이션 기본 객체(implicit object)
	=> JSP에서 별도의 인스턴스 선언 없이 사용 가능
	=> request, response, out, session, 
   	pageContext, application 등 9종류
	</pre>
	<h3>1. Request</h3>
	* ContextPath =>
	<%=request.getContextPath()%>
	* RealPath =>
	<%=request.getRealPath("/")%>
	* RequestURI =>
	<%=request.getRequestURI()%>

	<h3>2. Session</h3>
	* Session_ID =>
	<%=session.getId()%>

	<h3>3. out</h3>
	* out 출력 =>
	<%
	out.print("out 객체로 출력하기");
	%>

	<h3>4. PageContext</h3>
	=> JSP 페이지에 대한 정보를 저장한다.
	=> 기본 객체를 return 하는 메서드를 제공.
	-> request 객체와	메서드가 return하는 객체와 동일성 비교
	
	<%
		HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
	%>
		-> 비교결과 : <%=request == req %>
		-> pageContext가 제공하는 out 객체로 출력하기
		<% pageContext.getOut().print("pageContext가 제공하는 out 객체로 출력"); %>
		
	<h3>5. Application</h3>
	* 서버정보 => <%=application.getServerInfo() %><br>
	* Servlet MajorVersion => <%=application.getMajorVersion() %><br>
	* Servlet MinorVersion => <%=application.getMinorVersion() %><br>
	* RealPath1 => <%=application.getRealPath("") %> ("" 사용시에는 실행중인 현재 프로젝트의 RealPath Return)<br>
	* RealPath2 => <%=application.getRealPath("/jsp01") %> (지정한 경로의 RealPath)<br>
	* -> HDD 상의 소스 위치가 아님 주의
</body>
</html>