<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello Spring!</h1>

	<P>The time on the server is ${serverTime}</P>
	<hr>
	<c:if test="${not empty requestScope.message}">
		=> ${requestScope.message}<br>
	</c:if>
	<hr>
	<a href="mlist">MList</a><br>
	<a href="mlistsp">MListSP</a>
</body>
</html>