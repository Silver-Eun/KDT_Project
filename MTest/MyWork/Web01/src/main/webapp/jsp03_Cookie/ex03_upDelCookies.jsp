<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>** Update, Delete, 유효시간 **</h2>
<pre>
=> request의 쿠키목록을 확인해서
   수정.삭제하려는 쿠키를 찾아
   수정.삭제 후 재전송함
   
=> 쿠키의 유효시간 설정
   -> setMaxAge(10) -> 초단위 (1시간: 60*60)
   -> 유효시간 0을 주면 삭제됨
   -> 음수 사용시 오류는 없지만 삭제 안됨

=> 실습
   -> MyCookie1 value 수정 후, MaxAge 10초 : 수정 & 자동삭제
   -> MyCookie2 MaxAge 0으로 삭제
<%
	Cookie[] ck = request.getCookies();
	if ( ck != null && ck.length > 0) {
		for ( Cookie c:ck ) {
			if ( c.getName().equals("MyCookie1") ) {
				c.setValue("YellowCom");
				c.setMaxAge(10); // 단위 : 초
				response.addCookie(c);
			} else if ( c.getName().equals("MyCookie2") ) {
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
	} else {
		out.print("** Cookie NotFound **");
	}
%>
<hr>
=> <a href="ex01_viewCookies.jsp">ViewCookies</a>
=> <a href="ex02_makeCookies.jsp">MakeCookies</a>
</pre>
</body>
</html>