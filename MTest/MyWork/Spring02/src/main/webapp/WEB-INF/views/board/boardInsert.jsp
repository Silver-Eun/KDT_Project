<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Board Insert **</title>
<link rel="stylesheet" type="text/css" href="/Spring02/resources/myLib/myStyle.css">
</head>
<body>
	<h2>** Spring_MVC2 Board Insert **</h2>
	<form action="binsert" method="Post">
		<table>
			<tr height="40">
				<th bgcolor="violet">I D</th>
				<td><input type="text" name="id" value="${sessionScope.loginID}" readonly size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="violet">Title</th>
				<td><input type="text" name="title" size="50"></td>
			</tr>
			<tr height="40">
				<th bgcolor="violet">Content</th>
				<td><textarea rows="5" cols="50" name="content"></textarea></td>
			</tr>
			<tr height="40">
				<th></th>
				<td>
					<input type="submit" value="등록">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<c:if test="${not empty requestScope.message}">
		=> ${message}
	</c:if>
	<hr>
	&nbsp;<a href="javascript:history.go(-1)">이전으로</a> &nbsp;
	&nbsp;<a href="/Spring02/home">Home</a>&nbsp;
</body>
</html>