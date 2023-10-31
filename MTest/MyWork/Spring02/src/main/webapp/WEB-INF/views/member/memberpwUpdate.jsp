<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Update **</title>
<link rel="stylesheet" type="text/css" href="/Spring02/resources/myStyle.css">
<script src="/Spring02/resources/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h2>** Spring_MVC2 Member Update **</h2>
	<form action="pupdateForm" method="post" enctype="multipart/form-data">
		<table>
			<c:if test="${not empty requestScope.apple}">
				<tr height="40">
					<th bgcolor="khaki">Password</th>
					<td><input type="Password" name="Password"
						placeholder="영어, 10글자 이내"
						value="${requestScope.apple.password}"size="20" ></td>
				</tr>
				<tr height="40">
					<th bgcolor="khaki"> 재 확 인</th>
					<td><input type="Password" name="Password"
						placeholder="영어, 10글자 이내"	size="20" ></td>
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
	<c:if test="${not empty requestScope.message}">
		=> ${message}
	</c:if>
	<hr>
	&nbsp;
	<a href="javascript:history.go(-1)">이전으로</a> &nbsp; &nbsp;
	<a href="/green/home">Home</a>&nbsp;
</body>
</html>