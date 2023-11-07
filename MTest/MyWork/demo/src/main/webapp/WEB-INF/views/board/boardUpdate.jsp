<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Board Update **</title>
<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
</head>
<body>
	<h2>** Spring_MVC2 Board Update **</h2>
	<form action="bupdate" method="Post">
		<table>
			<c:if test="${not empty requestScope.apple}">
				<tr height="40">
					<th bgcolor="Chocolate">seq</th>
					<td><input type="text" name="seq"
						value="${requestScope.apple.seq}" size="20" readonly></td>
				</tr>
				<tr height="40">
					<th bgcolor="Chocolate">I D</th>
					<td><input type="text" name="id"
						value="${requestScope.apple.id}" size="20" readonly></td>
				</tr>
				<tr height="40">
					<th bgcolor="orange">Title</th>
					<td><input type="text" name="title"
						value="${requestScope.apple.title}" size="20"></td>
				</tr>
				<tr height="40">
					<th bgcolor="orange">Content</th>
					<td><textarea rows="5" cols="50" name="content">${requestScope.apple.content}</textarea>
					</td>
				</tr>
				<tr height="40">
					<th bgcolor="orange">RegDate</th>
					<td><input type="text" name="regdate"
						value="${requestScope.apple.regdate}" size="20" readonly></td>
				</tr>
				<tr height="40">
					<th bgcolor="orange">조회수</th>
					<td><input type="text" name="cnt"
						value="${requestScope.apple.cnt}" size="20" readonly></td>
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
	<a href="/home">Home</a>&nbsp;
</body>
</html>