<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Board Detail **</title>
<link rel="stylesheet" type="text/css" href="/Spring02/resources/myLib/myStyle.css">
</head>
<body>
	<h2>** Spring_MVC2 Board Detail **</h2>
	<table style="text-align: center;" >
		<c:if test="${not empty requestScope.apple}">
			<tr height="40">
				<th bgcolor="plum">SEQ</th>
				<td>${requestScope.apple.seq}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">I D</th>
				<td>${requestScope.apple.id}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">Title</th>
				<td>${requestScope.apple.title}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">Content</th>
				<td>${requestScope.apple.content}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">RegDate</th>
				<td>${requestScope.apple.regdate}</td>
			</tr>
			<tr height="40">
				<th bgcolor="plum">조회수</th>
				<td>${requestScope.apple.cnt}</td>
			</tr>
		</c:if>
		<c:if test="${empty requestScope.apple}">
			<tr height="40">
				<th colspan="2">출력할 Data가 없습니다</th>
			</tr>
		</c:if>
	</table>
	<hr>
	<c:if test="${not empty requestScope.message}">
		=> ${message}
	</c:if>
	<hr>
	<!-- 로그인 한 경우에는 새 글 등록, 답글 등록 -->
	&nbsp;<a href="boardInsert">새 글 등록</a>&nbsp;
	<!-- 댓글등록을 위해 부모글의 root, step, indent 값이 필요하기 때문에
    	 서버로 보내주어야 함(쿼리스트링으로 작성) -->
	&nbsp;<a href="replyInsert?root=${apple.root}&step=${apple.step}&indent=${apple.indent}">답글 등록</a>&nbsp;
	<!-- 로그인id와 글쓴이id가 동일하면 수정, 삭제 가능 -->
	<c:if test="${sessionScope.loginID == requestScope.apple.id}">
		&nbsp;<a href="bdetail?jCode=U&seq=${requestScope.apple.seq}">글 수정</a>&nbsp;	
		&nbsp;<a href="bdelete?seq=${requestScope.apple.seq}&root=${apple.root}">글 삭제</a>&nbsp;	
	</c:if>
	
	<hr>
	&nbsp;<a href="javascript:history.go(-1)">이전으로</a> &nbsp;
	&nbsp;<a href="/Spring02/home">Home</a>&nbsp;
</body>
</html>