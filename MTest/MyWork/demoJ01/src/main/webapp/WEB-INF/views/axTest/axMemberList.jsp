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
<table border="1" style="width:100%; text-align:center">
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
		<tr><td><span class="textlink" onclick="idbList('${s.id}')">${s.id}</span></td>
			<td>${s.name}</td><td>${s.age}</td>
			<td><span class="textlink" onmouseover="showJoDetail(event, ${s.jno})"
									   onmouseout="hideJoDetail()">${s.jno}</span></td>
			<!--       ** function에 이벤트객체 전달
						=> 이벤트핸들러의 첫번째 매개변수에 event라는 이름으로 전달함
						=> a Tag와 span 사용시 e.target 값 비교
							-> a Tag : "javascript:;"
							-> span  : [object HTMLSpanElement]  -->
			<td>${s.info}</td><td>${s.point}</td><td>${s.birthday}</td><td>${s.rid}</td>
			<!-- Image 추가 -->
			<td><img alt="MyImage" src="/${s.uploadfile}" width="50" height="70"></td>
			
			<!-- File Download -->
			<%-- <td> <a href="download?dnfile=${s.uploadfile}">${s.uploadfile}</a></td> --%>
			<!-- 관리자 기능 : axios로 처리하기
				=> 삭제할 대상을 function에 전달 : 매개변수 활용
				axiDelete('banana') -> axi~(${s.id}) -> axiDelete(banana) -->
			<c:if test="${sessionScope.loginID=='admin'}">
				<td>
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
<div id="content"></div>
<hr>
&nbsp;<a href="/home">Home</a>&nbsp;
</body>
</html>