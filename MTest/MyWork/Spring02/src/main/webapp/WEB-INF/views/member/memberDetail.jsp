<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Detail **</title>
<link rel="stylesheet" type="text/css" href="/green/resources/myStyle.css">
</head>
<body>
	<h2>** Spring_MVC2 Member Detail **</h2>
	<table style="text-align: center;" >
		<c:if test="${not empty requestScope.apple}">
			<tr height="40">
				<th bgcolor="pink">Id</th>
				<td>${requestScope.apple.id}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Password</th>
				<td>${requestScope.apple.password}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Name</th>
				<td>${requestScope.apple.name}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Age</th>
				<td>${requestScope.apple.age}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Jno</th>
				<td>${requestScope.apple.jno}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Info</th>
				<td>${requestScope.apple.info}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Point</th>
				<td>${requestScope.apple.point}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Birthday</th>
				<td>${requestScope.apple.birthday}</td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">추천인</th>
				<td>${requestScope.apple.rid}</td>
			</tr>
		</c:if>
		<c:if test="${empty requestScope.apple}">
			<tr height="40">
				<th colspan="2">출력할 Data가 없습니다</th>
			</tr>
		</c:if>
	</table>
	<hr>
	&nbsp;<a href="javascript:history.go(-1)">이전으로</a> &nbsp;
	&nbsp;<a href="/green/home">Home</a> &nbsp;
</body>
</html>