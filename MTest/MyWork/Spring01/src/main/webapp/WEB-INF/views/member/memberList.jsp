<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web_MVC2 MemberList **</title>
</head>
<body>
	<h2>** Web_MVC2 MemberList **</h2>
	<hr>
	<c:if test="${not empty requestScope.message}">
		=> ${requestScope.message}<br>
		<hr>
	</c:if>
	<table border="1" style="width: 90%; text-align: center">
		<tr bgcolor="orange">
			<th>Id</th>
			<th>Password</th>
			<th>Name</th>
			<th>Age</th>
			<th>Jno</th>
			<th>Info</th>
			<th>Point</th>
			<th>Birthday</th>
			<th>Rid</th>
			<!-- 관리자 기능 추가 -->
			<c:if test="${sessionScope.loginId == 'silver'}">
				<th>Delete</th>
			</c:if>			
		</tr>
		<c:if test="${not empty requestScope.banana}">
			<c:forEach var="s" items="${requestScope.banana}">
				<tr>
					<td><a href="mdetailsp?id=${s.id}">${s.id}</a></td>
					<td>${s.password}</td>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td>${s.jno}</td>
					<td>${s.info}</td>
					<td>${s.point}</td>
					<td>${s.birthday}</td>
					<td>${s.rid}</td>
					<c:if test="${sessionScope.loginId == 'silver'}">
						<td><a href="/Web02/delete?id=${s.id}">삭제</a></td>
					</c:if>			
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.banana}">
			<tr>
				<td colspan="7">출력할 Data가 없습니다</td>
			</tr>
		</c:if>
	</table>
	<hr>
	&nbsp;<a href="/Web02/">Home</a> &nbsp;
</body>
</html>