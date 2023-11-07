<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** ID 중복확인 **</title>
<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
<script src="/resources/myLib/inCheck.js"></script>
<script>
// ** idOK : 사용자가 입력한 id를 사용가능하도록 해주고, 현재(this)창은 close
// 1) this 창의 id를 부모창의 id로
// 2) 부모창의 ID 중복확인 버튼은 disable & submit은 enable
// 3) 부모창의 id는 수정불가(readonly), password에 focus
// 4) 현재(this)창은 close
function idOK() {
	opener.document.getElementById('id').value='${param.id}';
	
	opener.document.getElementById('idDup').disabled = 'disabled';
	opener.document.getElementById('submitTag').disabled = '';
	
	opener.document.getElementById('id').readOnly = true;
	opener.document.getElementById('password').focus();
	
	close();
	}
</script>
<style>
   body {
      background-color: LightYellow;
      font-family: 맑은고딕;
   }
   #wrap {
      margin-left: 0;
      text-align: center;
   }
   h3 { color: navy; }   
</style>
</head>
<body>
	<div id="wrap">
		<h3>** ID 중복확인 **</h3>
		<h4>Parameter id값 확인</h4>
		=> Parameter_ID : ${param.id}<br>
		=> MemberDTO_ID : ${memberDTO.id}<br>
		<form action="idDupCheck" method="get">
			User_ID :
			<input type="text" name="id" id="id" value="${param.id}">
			<input type="submit" value="ID중복확인" onclick="return idCheck()">
			<!-- inCheck.js의 idCheck()의 결과에 따라 submit 결정 -->
			<span id="iMessage" class="eMessage"></span>
		</form>
		<br><br>
		<div id="msgBlock">
			<c:if test="${idUse == 'T'}">
				${memberDTO.id}는(은) 사용 가능합니다. &nsbp;&nsbp;
				<button onclick="idOK()">ID 선택</button>
			</c:if>
			<c:if test="${idUse == 'F'}">
				${memberDTO.id}는(은) 사용 불가능합니다.(사용중)<br>
				다시 입력하세요.<br>
			</c:if>
			<script>
				document.getElementById('id').focus();
				opener.document.getElementById('id').value='';
			</script>
		</div>
	</div>	
</body>
</html>