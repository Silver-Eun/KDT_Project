<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 BoardList **</title>
<link rel="stylesheet" type="text/css" href="/Spring02/resources/myLib/myStyle.css">
</head>
<body>
	<h2>** Spring_MVC2 Board**</h2>
	<hr>
	<c:if test="${not empty requestScope.message}">
		=> ${requestScope.message}<br>
		<hr>
	</c:if>
	<table border="1" style="width: 100%; text-align: center">
		<tr bgcolor="orange">
			<th>Seq</th>
			<th>Title</th>
			<th>Id</th>
			<th>Regdate</th>
			<th>조회수</th>
		</tr>
		<c:if test="${not empty requestScope.banana}">
			<c:forEach var="s" items="${requestScope.banana}">
				<tr>
					<td>${s.seq}</td>
					<!-- Title
						=> 로그인 한 경우에만 글내용을 볼 수 있도록 Link 추가
						=> 댓글 작성 후에는 indent 값에 따른 들여쓰기 기능 -->
					<td style="text-align: left">
						<c:if test="${s.indent > 0}">
							<c:forEach begin="1" end="${s.indent}">
								<span>&nbsp;&nbsp;</span>
							</c:forEach>
							<span style="color:blue;">re..</span>
						</c:if>
						
						<c:if test="${not empty sessionScope.loginID}">
							<a href="bdetail?seq=${s.seq}">${s.title}</a>
						</c:if>
						<c:if test="${empty sessionScope.loginID}">
							${s.title}
						</c:if>
					</td>
					<td>${s.id}</td>
					<td>${s.regdate}</td>
					<td>${s.cnt}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.banana}">
			<tr>
				<td colspan="5">출력할 Data가 없습니다</td>
			</tr>
		</c:if>
	</table>
	<hr>
	<c:if test="${not empty sessionScope.loginID}">
	&nbsp;<a href="boardInsert">새 글 등록</a>&nbsp;
	</c:if>
	&nbsp;<a href="/Spring02/home">Home</a>&nbsp;
</body>
</html>