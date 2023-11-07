<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Board CriList Mybatis **</title>
<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
<script>
function searchDB() {
	self.location='bcriList'
				+'${pageMaker.makeQuery(1)}'
				+'&searchType='+document.getElementById('searchType').value
				+'&keyword='+document.getElementById('keyword').value;
}

function keywordClear(){
	if ( document.getElementById('searchType').value=='all' )
		document.getElementById('keyword').value='';	
} 
</script>

</head>
<body>
<h2>** Board CriList Mybatis **</h2>
<hr>
<c:if test="${not empty requestScope.message}">
	=> ${requestScope.message}<br><hr>
</c:if>
<hr>
<div id="searchBar">
	<select name="searchType" id="searchType" onchange="keywordClear()">
		<option value="all" ${pageMaker.cri.searchType=='all' ? 'selected' : ''}>전체</option>
		<option value="title" ${pageMaker.cri.searchType=='title' ? 'selected' : ''}>Title</option>
		<option value="content" ${pageMaker.cri.searchType=='content' ? 'selected' : ''}>Content</option>
		<option value="id" ${pageMaker.cri.searchType=='id' ? 'selected' : ''}>ID(글쓴이)</option>
		<option value="regdate" ${pageMaker.cri.searchType=='regdate' ? 'selected' : ''}>RegDate</option>
	</select>
	<input type="text" name="keyword" id="keyword" value="${pageMaker.cri.keyword}">
	<button id="searchBtn" onclick="searchDB()">Search</button>
</div>
<br><hr>
<table style="width:100%">
	<tr bgcolor="LimeGreen">
		<th>Seq</th><th>Title</th><th>ID</th><th>Regdate</th><th>조회수</th>
	</tr>
	<c:if test="${not empty requestScope.banana}">
		<c:forEach var="s" items="${requestScope.banana}">
		<tr><td>${s.seq}</td>
			<td>
				<c:if test="${s.indent>0}">
					<c:forEach begin="1" end="${s.indent}">
						<span>&nbsp;&nbsp;</span>
					</c:forEach>
					<span style="color:blue;">re..</span>
				</c:if>
				
				<c:if test="${not empty sessionScope.loginID}">
					<a href="bdetail?seq=${s.seq}">${s.title}</a>
			 	</c:if>    
				<c:if test="${empty sessionScope.loginID}">
					${s.title}
			 	</c:if>
			</td>
			<td>${s.id}</td><td>${s.regdate}</td><td>${s.cnt}</td>
		</tr>	
		</c:forEach>
	</c:if>
	<c:if test="${empty requestScope.banana}">
		<tr><td colspan="5">출력할 Data가 1건도 없습니다 ~~</td>
		</tr>
	</c:if>
</table>
<hr>
<div align="center">
	<c:choose>
		<c:when test="${pageMaker.prev && pageMaker.spageNo>1}">
		  	<a href="bcriList${pageMaker.searchQuery(1)}">FP</a>&nbsp;
		  	<a href="bcriList${pageMaker.searchQuery(pageMaker.spageNo-1)}">&LT;</a>&nbsp;&nbsp;
		</c:when>
		<c:otherwise>
		  	<font color="Gray">FP&nbsp;&LT;&nbsp;&nbsp;</font>
		</c:otherwise>
	</c:choose> 	 
	 
	<!-- 2) Display PageNo -->
	<c:forEach var="i" begin="${pageMaker.spageNo}" end="${pageMaker.epageNo}">
		<c:if test="${i==pageMaker.cri.currPage}">
			<font color="Orange" size="5"><b>${i}</b></font>&nbsp;
		</c:if>
		<c:if test="${i!=pageMaker.cri.currPage}">
			<a href="bcriList${pageMaker.searchQuery(i)}">${i}</a>&nbsp;
		</c:if>
	</c:forEach>
	 
	<!-- 3) Next, LastPage 
		=> ver01: makeQuery() 메서드 사용
		=> ver02: searchQuery() 메서드 사용 -->
	<c:choose>
		<c:when test="${pageMaker.next && pageMaker.epageNo>0}">
			&nbsp;<a href="bcriList${pageMaker.searchQuery(pageMaker.epageNo+1)}">&GT;</a>
			&nbsp;<a href="bcriList${pageMaker.searchQuery(pageMaker.lastPageNo)}">LP</a>
		</c:when>
		<c:otherwise>
			<font color="Gray">&nbsp;&GT;&nbsp;LP</font>
		</c:otherwise>
	</c:choose>
</div>
<hr>
<!-- 로그인 한 경우에만 새글등록 가능 -->
<c:if test="${not empty sessionScope.loginID}">
	&nbsp;<a href="boardInsert">새글등록</a>&nbsp;
</c:if>	
&nbsp;<a href="/home">Home</a>&nbsp;

</body>
</html>