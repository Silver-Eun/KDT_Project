<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** SpringBoot MemberList **</title>
<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
</head>
<body>
<h2>** SpringBoot Axios_MemberList **</h2>

<hr>
<c:if test="${not empty requestScope.message}">
	=> ${requestScope.message}<br><hr>
</c:if>
<table border="1" style="width:100%">
	<tr bgcolor="skyblue">
		<th>ID</th><th>Name</th><th>Age</th><th>Jno</th><th>Info</th>
		<th>Point</th><th>Birthday</th><th>Rid</th><th>Image</th>
		<!-- <th>Download</th> -->
		<!-- 관리자 기능 추가 -->
		<c:if test="${sessionScope.loginID=='admin'}">
			<th>Delete</th>
		</c:if>
	</tr>
	<c:if test="${not empty requestScope.banana}">
		<c:forEach var="s" items="${requestScope.banana}">
		<tr><td><a href="mdetail?id=${s.id}">${s.id}</a></td>
			
			<td>${s.name}</td><td>${s.age}</td><td>${s.jno}</td>
			<td>${s.info}</td><td>${s.point}</td><td>${s.birthday}</td><td>${s.rid}</td>
			<!-- Image 추가 -->
			<td align="center"><img alt="MyImage" src="/${s.uploadfile}" width="50" height="70"></td>
			
			<!-- File Download -->
			<%-- <td> <a href="download?dnfile=${s.uploadfile}">${s.uploadfile}</a></td> --%>
			<!-- 관리자 기능 : axios로 처리하기
				=> 삭제할 대상을 function에 전달 : 매개변수 활용
				axiDelete('banana') -> axi~(${s.id}) -> axiDelete(banana) -->
			<c:if test="${sessionScope.loginID=='admin'}">
				<td align="center">
					<span class="textlink" onclick="axiDelete('${s.id}')" id="${s.id}">Delete</span>
				</td>
			</c:if>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty requestScope.banana}">
		<tr><td colspan="7">출력할 Data가 1건도 없습니다 ~~</td>
		</tr>
	</c:if>
</table>
<hr>
&nbsp;<a href="/home">Home</a>&nbsp;
</body>
</html>