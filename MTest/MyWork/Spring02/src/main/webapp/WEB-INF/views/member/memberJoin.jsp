<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Join **</title>
<link rel="stylesheet" type="text/css" href="/green/resources/myStyle.css">
</head>
<body>
	<h2>** Spring_MVC2 Member Join **</h2>
	<form action="join" method="Post">
		<table>
			<tr height="40">
				<th bgcolor="pink">I D</th>
				<td><input type="text" name="id" placeholder="영어, 10글자 이내"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Password</th>
				<td><input type="password" name="password" placeholder="영어, 숫자, 특수문자"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Name</th>
				<td><input type="text" name="name" placeholder="한글 또는 영어"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Age</th>
				<td><input type="text" name="age" placeholder="숫자입력" size="20"></td>
			</tr>

			<tr height="40">
				<th bgcolor="pink">Jno</th>
				<td>
					<select name="jno">
						<option value="1">1조 : 119조</option>
						<option value="2">2조 : 여우조</option>
						<option value="3">3조 : 최고조</option>
						<option value="4">4조 : i4</option>
						<option value="5">5조 : 오조</option>
						<option value="5">7조 : 관리팀</option>
					</select>
				</td>
			</tr>

			<tr height="40">
				<th bgcolor="pink">Info</th>
				<td><input type="text" name="info" placeholder="반드시 입력하세요"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Point</th>
				<td><input type="text" name="point" placeholder="실수입력"
					size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Birthday</th>
				<td><input type="date" name="birthday" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">추천인</th>
				<td><input type="text" name="rid" size="20"></td>
			</tr>
			<tr height="40">
				<th></th>
				<td>
					<input type="submit" value="가입">&nbsp;&nbsp;&nbsp;
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
	&nbsp;<a href="home">Home</a>&nbsp;
</body>
</html>