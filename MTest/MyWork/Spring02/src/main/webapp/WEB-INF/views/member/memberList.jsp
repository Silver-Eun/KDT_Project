<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 MemberList **</title>
<link rel="stylesheet" type="text/css" href="/green/resources/myStyle.css">
</head>
<body>
	<h2>** Spring_MVC2 MemberList **</h2>
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
			<th>Image</th>
			<!-- 관리자 기능 추가 -->
			<c:if test="${sessionScope.loginID == 'admin'}">
				<th>Delete</th>
			</c:if>			
		</tr>
		<c:if test="${not empty requestScope.banana}">
			<c:forEach var="s" items="${requestScope.banana}">
				<tr>
					<td><a href="mdetail?id=${s.id}">${s.id}</a></td>
					<td>${s.password}</td>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td>${s.jno}</td>
					<td>${s.info}</td>
					<td>${s.point}</td>
					<td>${s.birthday}</td>
					<td>${s.rid}</td>
					<c:if test="${sessionScope.loginID == 'admin'}">
						<td><a href="mdelete?id=${s.id}">삭제</a></td>
					</c:if>
					<!-- image 추가 -->
					<td><img alt="MyImage" src="/green/${s.uploadfile}" width="50" height="60"></td>	
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
	&nbsp;<a href="/green/home">Home</a>&nbsp;
</body>
</html>