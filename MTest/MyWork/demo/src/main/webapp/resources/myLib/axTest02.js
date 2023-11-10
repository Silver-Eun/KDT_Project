"use strict"

// ** Ajax_REST API Join Test **

// 1) joinForm 요청
// => Request : jQuery Ajax, MemberController의 memberJoin 활용
// => Response : Page
// => window.jQuery 객체 -> 줄여서 window 생략하고 $ 기호로 표현

function rsJoinf() {
	let url = "/member/memberJoin";
	$.ajax({ 
		type: 'Get',
		url: url,
		success: function(resultPage) {
		// => success 익명함수의 인자값 
		// 	  서버에서 Page를 전송하면 Page를
		// 	  서버에서 Data를 전송하면 Data를
			document.getElementById('resultArea1').innerHTML=resultPage;
		},
		error:function() {
			document.getElementById('resultArea1').innerHTML="Ajax Error";
		}
	 });
	document.getElementById('resultArea2').innerHTML="";			
}

// 2) join Service 요청
// => form의 Data 처리방법
//   - 직접 입력 : uploadfilef를 처리할 수 없음
//   - Form 의 serialize()
//       -> input Tag의 name과 id 가 같아야 함  
//       -> 직렬화 : multipart 타입은 전송안됨
//           처리하지 못하는 값(예-> file Type)은 스스로 제외시킴
//   - 객체화 : uploadfilef를 처리할 수 없음
//   - FormData 객체 활용
//		-> append 메소드 : uploadfilef 처리 불편
//		-> 생성자 매개변수 이용 : uploadfilef 포함 간편한 처리가능
function rsJoin() {
	// 1) Data 준비
	// => JS의 내장객체 FormData에 담아서 전송
	let formData = new FormData(document.getElementById('myform'));
	
	// 2) ajax
	$.ajax({
		type: 'Post',
		url: 'rest/rsjoin',
		data: formData,
		processData: false,
		contentType: false,
		
		success: (resultData) => {
			// => 결과는 Text
			document.getElementById('resultArea1').innerHTML=resultData;
		},
		error: () => {
			document.getElementById('resultArea1').innerHTML="Ajax Error";
		}
	});
	document.getElementById('resultArea2').innerHTML="";
}
