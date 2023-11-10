<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Join **</title>
<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
<script src="/resources/myLib/jquery-3.2.1.min.js"></script>
<script src="/resources/myLib/inCheck.js"></script>
<script>
function idDupCheck() {
	if ( iCheck == false ) iCheck = idCheck();
	else {
		let url = "idDupCheck?id=" + document.getElementById('id').value;
		window.open(url, '_blank', 'width=400, height=300, resizable=yes, scrollbars=yes, toolbar=no, menubar=yes');
	}
}

  let iCheck=false; 
  let pCheck=false;
  let p2Check=false;
  let nCheck=false;
  let aCheck=false; // 정수
  let bCheck=false;
  let oCheck=false;

onload=function() {
	document.getElementById('id').focus();
	document.getElementById('id').addEventListener('keydown', 
		(e) => { 
			if ( e.which==13 ) {
				e.preventDefault();
				document.getElementById('password').focus();
			}
		});
	document.getElementById('id').addEventListener('focusout',
			()=>{ iCheck=idCheck(); }); 

	document.getElementById('password').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('password2').focus();
				} //if 		
			});
	document.getElementById('password').addEventListener("focusout",
			()=> { pCheck=pwCheck(); });
	
	// => Password2
	document.getElementById('password2').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('name').focus();
				} //if 		
			});
	document.getElementById('password2').addEventListener("focusout",
			()=> { p2Check=pw2Check(); });
	
	// => Name
	document.getElementById('name').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('age').focus();
				} //if 		
			});
	document.getElementById('name').addEventListener("focusout",
			()=> { nCheck=nmCheck(); });
	
	// => Age
	document.getElementById('age').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('jno').focus();
				} //if 		
			});
	document.getElementById('age').addEventListener("focusout",
			()=> { aCheck=agCheck(); });
	
	// => Point
	document.getElementById('point').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('birthday').focus();
				} //if 		
			});
	document.getElementById('point').addEventListener("focusout",
			()=> { oCheck=poCheck(); });
	
	// => Birthday
	document.getElementById('birthday').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('rid').focus();
				} //if 		
			});
	document.getElementById('birthday').addEventListener("focusout",
			()=> { bCheck=bdCheck(); });
	
	// => Jno, Info, Rid, Image 는 EnterKey 처리(선택사항)
	document.getElementById('jno').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('info').focus();
				} //if 		
			});
	document.getElementById('info').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('point').focus();
				} //if 		
			});	
	document.getElementById('rid').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('uploadfilef').focus();
				} //if 		
			});
	document.getElementById('uploadfilef').addEventListener("keydown",
			(e)=> {
				if ( e.which==13 ) {
					e.preventDefault();
					document.getElementById('submitTag').focus();
				} //if 		
			});
	
}; //onload 
	
// 3) submit 실행 여부 판단 & 실행
// => 모든항목의 무결성을 확인
// => 오류가 없으면 : return true
// => 오류가 1항목이라도 있으면 : return false 
function inCheck() {
	if (iCheck == false) { document.getElementById('iMessage').innerHTML = '필수입력, id를 확인하세요'; }
	if (pCheck == false) { document.getElementById('pMessage').innerHTML = '필수입력, password를 확인하세요'; }
	if (p2Check == false) { document.getElementById('p2Message').innerHTML='필수입력, password 재입력을 확인하세요'; }
	if (nCheck == false) { document.getElementById('nMessage').innerHTML = '필수입력, name을 확인하세요'; }
	if (aCheck == false) { document.getElementById('aMessage').innerHTML = '필수입력, age를 확인하세요'; }
	if (oCheck == false) { document.getElementById('oMessage').innerHTML = '필수입력, point를 확인하세요'; }
	if (bCheck == false) { document.getElementById('bMessage').innerHTML = '필수입력, birthday를 확인하세요'; }
	
	if (iCheck && pCheck && p2Check && nCheck 
			   && aCheck && oCheck && bCheck ) {
		// => submit 확인
		if ( confirm("가입하시겠습니까? (Yes:확인 / No:취소)") ) {
			// => submit 진행
			return true
		}else {
			alert("가입이 취소되었습니다");
			return false;
		} //alert
	}else {
		return false;
	}
} //inCheck
	
</script>

</head>
<body>
<h2>** Spring_MVC2 Member Join **</h2>
<form action="join" method="Post" enctype="multipart/form-data" id="myform">
<table>
	<tr height="40"><th bgcolor="aqua">I D</th>
		<td><input type="text" name="id" id="id" placeholder="영어, 10글자이내" size="20">
		<button type="button" id="idDup" onclick="idDupCheck()">중복확인</button><br>
		<span id="iMessage" class="eMessage"></span>
		</td></tr>
	<tr height="40"><th bgcolor="aqua">Password</th>
		<td><input type="password" name="password" id="password" placeholder="영어, 숫자, 특수문자" size="20"><br>
			<span id="pMessage" class="eMessage"></span>
		</td></tr>	
	<tr height="40"><th bgcolor="aqua">Pw 확인</th>
      	<td><input type="password" id="password2" placeholder="재입력 확인"><br>
        	<span id="p2Message" class="eMessage"></span>
        </td></tr>	
	<tr height="40"><th bgcolor="aqua">Name</th>
		<td><input type="text" name="name" id="name" placeholder="한글 또는 영어" size="20"><br>
			<span id="nMessage" class="eMessage"></span>
		</td></tr>
	<tr height="40"><th bgcolor="aqua">Age</th>
		<td><input type="text" name="age" id="age" placeholder="숫자입력" size="20"><br>
			<span id="aMessage" class="eMessage"></span>
		</td></tr>
	<tr height="40"><th bgcolor="aqua">Jno</th>
		<td><select name="jno" id="jno">
				<option value="1">1조: 119조</option>
				<option value="2">2조: 여우조</option>
				<option value="3">3조: i4조</option>
				<option value="4">4조: 최고조</option>
				<option value="5">5조: 오조</option>
				<option value="7">7조: 관리팀</option>
				<option value="7">9조: 오타쿠팀</option>
		</select></td></tr>
	<tr height="40"><th bgcolor="aqua">여친유무</th>
		<td><select name="jno" id="jno">
				<option value="1">없음</option>
		
		</select></td></tr>
	<tr height="40"><th bgcolor="aqua">Info</th>
		<td><input type="text" name="info" id="info" placeholder="자기소개 & 희망사항" size="20"></td></tr>
	<tr height="40"><th bgcolor="aqua">Point</th>
		<td><input type="text" name="point" id="point" placeholder="실수 입력" size="20"><br>
			<span id="oMessage" class="eMessage"></span>
		</td></tr>
	<tr height="40"><th bgcolor="aqua">Birthday</th>
		<td><input type="date" name="birthday" id="birthday" size="20"><br>
			<span id="bMessage" class="eMessage"></span>
		</td></tr>	
	<tr height="40"><th bgcolor="aqua">추천인</th>
		<td><input type="text" name="rid" id="rid" size="20"></td></tr>	
		
	<tr height="40"><th bgcolor="aqua">Image</th>
		<td><img src="" class="select_img"><br>
			<input type="file" name="uploadfilef" id="uploadfilef" size="20"></td>
	</tr>		
	<script>
	window.document.getElementById('uploadfilef').onchange=function(e){
		if(this.files && this.files[0]) {
			let reader = new FileReader;
			reader.readAsDataURL(this.files[0]);
 			reader.onload = function(e) {
					$(".select_img").attr("src", e.target.result)
									.width(70).height(90); 
				} // onload_function
 		} // if	
	}; //change  -> }); JQ 사용시	
	</script>		
				
	<tr height="40"><th></th>
		<td>
			<input type="submit" id="submitTag" value="가입" onclick="return inCheck()">
			&nbsp;&nbsp;
			<input type="reset" value="취소">&nbsp;&nbsp;
			<span class="textlink" onclick="rsJoin()">rsJoin</span>	
		</td>
	</tr>					
</table>
</form>
<hr>
<c:if test="${not empty requestScope.message}">
=> ${requestScope.message}
</c:if>
<hr>
&nbsp;<a href="javascript:history.go(-1)">이전으로</a>&nbsp;
&nbsp;<a href="/home">Home</a>&nbsp;
</body>
</html>