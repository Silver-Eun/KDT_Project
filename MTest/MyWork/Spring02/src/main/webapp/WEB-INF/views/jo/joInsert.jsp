<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Join **</title>
<link rel="stylesheet" type="text/css" href="/Spring02/resources/myLib/myStyle.css">
</head>
<body>
	<h2>** Spring_MVC2 Member Join **</h2>
	<form action="jinsert" method="Post">
		<table>
			<tr height="40">
				<th bgcolor="violet">Jno</th>
				<td><input type="text" name="jno" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="violet">Jname</th>
				<td><input type="text" name="jname" size="50"></td>
			</tr>
			<tr height="40">
				<th bgcolor="violet">I D</th>
				<td><input type="text" name="id" size="50"></td>
			</tr>
			<tr height="40">
				<th bgcolor="violet">Project</th>
				<td><input type="text" name="project" size="50"></td>
			</tr>
			<tr height="40">
				<th bgcolor="violet">Slogan</th>
				<td><textarea rows="5" cols="50" name="slogan"></textarea></td>
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