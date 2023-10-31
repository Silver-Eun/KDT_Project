<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Board Update **</title>
<link rel="stylesheet" type="text/css"
	href="/Spring02/resources/myStyle.css">
</head>
<body>
	<h2>** Spring_MVC2 Board Update **</h2>
	<form action="jupdate" method="Post">
		<table>
			<c:if test="${not empty requestScope.apple}">
				<tr height="40">
					<th bgcolor="Chocolate">jno</th>
					<td><input type="text" name="jno"
						value="${requestScope.apple.jno}" readonly size="20"></td>
				</tr>
				<tr height="40">
					<th bgcolor="Chocolate">Jname</th>
					<td><input type="text" name="jname"
						value="${requestScope.apple.jname}" size="20"></td>
				</tr>
				<tr height="40">
					<th bgcolor="orange">I D</th>
					<td><input type="text" name="id"
						value="${requestScope.apple.id}" size="20"></td>
				</tr>
				<tr height="40">
					<th bgcolor="orange">Project</th>
					<td><input type="text" name="project"
						value="${requestScope.apple.project}" size="20"></td>
				</tr>
				<tr height="40">
					<th bgcolor="orange">Slogan</th>
					<td><textarea rows="5" cols="50" name="slogan">${requestScope.apple.slogan}</textarea>
					</td>
				</tr>
				<tr height="40">
					<th></th>
					<td><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="취소"></td>
				</tr>
			</c:if>
			<c:if test="${empty requestScope.apple}">
				<tr>
					<td height="40">수정할 정보가 존재하지 않습니다</td>
				</tr>
			</c:if>
		</table>
	</form>
	<hr>
	&nbsp;
	<a href="javascript:history.go(-1)">이전으로</a> &nbsp; &nbsp;
	<a href="/green/home">Home</a>&nbsp;
</body>
</html>