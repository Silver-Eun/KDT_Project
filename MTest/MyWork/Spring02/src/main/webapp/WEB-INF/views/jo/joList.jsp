<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 JoList **</title>
<link rel="stylesheet" type="text/css" href="/green/resources/myStyle.css">
</head>
<body>
	<h2>** Spring_MVC2 JoList**</h2>
	<hr>
	<c:if test="${not empty requestScope.message}">
		=> ${requestScope.message}<br>
		<hr>
	</c:if>
	<table border="1" style="width: 90%; text-align: center">
		<tr bgcolor="orange">
			<th>Jno</th>
			<th>Jname</th>
			<th>Id</th>
			<th>Project</th>
			<th>Slogan</th>
		</tr>
		<c:if test="${not empty requestScope.banana}">
			<c:forEach var="s" items="${requestScope.banana}">
				<tr>
					<td>
						<c:if test="${not empty sessionScope.loginID}">
							<a href="jdetail?jno=${s.jno}">${s.jno}</a>
						</c:if>
						<c:if test="${empty sessionScope.loginID}">
							${s.jno}
						</c:if>
					</td>
					<td>${s.jname}</td>
					<td>${s.id}</td>
					<td>${s.project}</td>
					<td>${s.slogan}</td>
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
	&nbsp;<a href="joInsert">새 조 등록</a>&nbsp;
	</c:if>
	&nbsp;<a href="/green/home">Home</a>&nbsp;
</body>
</html>