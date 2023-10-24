<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 Member Update **</title>
<link rel="stylesheet" type="text/css"
	href="/green/resources/myStyle.css">
</head>
<body>
	<h2>** Spring_MVC2 Member Update **</h2>
	<form action="mupdate" method="Post">
		<table>
			<c:if test="${not empty requestScope.apple}">
				<tr height="40">
					<th bgcolor="khaki">I D</th>
					<td><input type="text" name="id"
						value="${requestScope.apple.id}" placeholder="영어, 10글자 이내"
						size="20" readonly="readonly"></td>
				</tr>
				<!-- id : 화면출력, 서버로 전송, 수정은 불가(즉, 입력 차단)
					-> readonly : 서버로 전송(권장)
					-> disabled : 서버로 전송되지 않음
					
					password 수정: 기본적으로 복호화불가능한 방식으로 암호화되어있기 때문에 별도로 처리
                    -> 암호수정: 별도의 수정화면에서 재입력후 교체됨
                    -> 암호찾기: 본인 재인증 후, 새암호를 발송 -> 새암호로 본인이 로그인후 수정  
      			<tr height="40"><th bgcolor="Khaki">Password</th>
      			<td><input type="password" name="password" value=${requestScope.apple.password} size="20"></td></tr>   
      			-->
				<tr height="40">
					<th bgcolor="khaki">Name</th>
					<td><input type="text" name="name"
						value="${requestScope.apple.name}" placeholder="한글 또는 영어"
						size="20"></td>
				</tr>
				<tr height="40">
					<th bgcolor="khaki">Age</th>
					<td><input type="text" name="age"
						value="${requestScope.apple.age}" placeholder="숫자입력" size="20"></td>
				</tr>

				<tr height="40">
					<th bgcolor="khaki">Jno</th>
					<td><select name="jno">
							<option value="1" ${requestScope.apple.jno == 1 ? "selected" : "" }>1조 : 119조</option>
							<option value="2" ${requestScope.apple.jno == 2 ? "selected" : "" }>2조 : 여우조</option>
							<option value="3" ${requestScope.apple.jno == 3 ? "selected" : "" }>3조 : 최고조</option>
							<option value="4" ${requestScope.apple.jno == 4 ? "selected" : "" }>4조 : i4</option>
							<option value="5" ${requestScope.apple.jno == 5 ? "selected" : "" }>5조 : 오조</option>
							<option value="7" ${requestScope.apple.jno == 7 ? "selected" : "" }>7조 : 관리팀</option>
					</select></td>
				</tr>

				<tr height="40">
					<th bgcolor="khaki">Info</th>
					<td><input type="text" name="info"
						value="${requestScope.apple.info}" placeholder="반드시 입력하세요"
						size="20"></td>
				</tr>
				<tr height="40">
					<th bgcolor="khaki">Point</th>
					<td><input type="text" name="point"
						value="${requestScope.apple.point}" placeholder="실수입력" size="20"></td>
				</tr>
				<tr height="40">
					<th bgcolor="khaki">Birthday</th>
					<td><input type="date" name="birthday"
						value="${requestScope.apple.birthday}" size="20"></td>
				</tr>
				<tr height="40">
					<th bgcolor="khaki">추천인</th>
					<td><input type="text" name="rid"
						value="${requestScope.apple.rid}" size="20"></td>
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