"use strict"

// ** Ajax_REST API, Axios Test
// 1. axMemberList의 id를 클릭하면 본인이 쓴 글 목록 출력
//      -> resultArea2 에 출력하기
//
// => get요청 : /rest/idblist/apple -> apple은 id임
// => 성공: JSON 객체로 전달된 List 출력문 JS로 만들기
// => 실패: 오류 메시지 출력
//
// => 서버
// - RTestController로 요청받음, SQL구문은 mapper 작성하지 말고 ~mapperInterface에 @(어노테이션)으로 작성
// - @PathVariable 사용, response는 JSON


function idbList(id) {

	let url = "/rest/idblist/" + id; // 요청명은 모두 소문자
	let resultHtml = "";

	axios.get(
		url
	).then(response => {
		alert("** List 성공 **");
		console.log("** idBList **" + response.data);

		// JSON으로 전달된 Data 출력문 만들기 (반복문)
		let list = response.data;
		console.log("** list.length **" + list.length);
		console.log("** list **" + list);

		/*let list = JSON.stringify(response.data);
		console.log("** list.length **"+list.length); 
		console.log("** list **"+list); */

		resultHtml =
			`<table border = 1, style="width:100%; text-align:center">
	           <tr bgcolor="DodgerBlue">
	              <th>Seq</th>
	              <th>Title</th>
	              <th>I D</th>
	              <th>Regdate</th>
	              <th>Cnt</th>
	           </tr>
        `;

		for (let s of list) {
			resultHtml += `
              <tr>
                 <td>${s.seq}</td>
                 <td>${s.title}</td>
                 <td>${s.id}</td>
                 <td>${s.regdate}</td>
                 <td>${s.cnt}</td>
              </tr>
           `;
		}

		resultHtml += "</table>";

		document.getElementById('resultArea2').innerHTML = resultHtml;

	}).catch(err => {
		if (err.response.status == '502') alert("~~ 입력 오류 !! 다시하세요 ~~");
		else alert("~~ 시스템 오류, 잠시후 다시하세요 => " + err.message);
	});
}

// *** JoDetail
// 1) showJoDetail(${s.jno})
// => jno에 mouseover : jno의 detail을 content div에 출력
// => request : axios, get, RTestController에 jodetail 요청
// => response : JoDTO 객체
function showJoDetail(e, jno) {
	// ** 이벤트객체 활용
	// => 마우스포인터 위치 확인
	//		- event객체 (이벤트핸들러 첫번째 매개변수)가 제공
	//		- e.pageX, e.pageY : 전체 Page 기준
	//		- e.clientX, e.clientY : 보여지는 화면 기준-> page Scroll 시에 불편함
	console.log(`** e.pageX=${e.pageX}, e.clientY=${e.clientY}`);
	console.log(`** e.clientX=${e.clientX}, e.clientY=${e.clientY}`);

	let url = "/rest/jodetail?jno=" + jno;
	let mleft = e.pageX;
	let mtop = e.pageY;
	
	axios.get(url
	).then(response => {
		console.log("** response 성공 => " + response.data);
		let jo = response.data;
		console.log("** Data: jo.jno => " + jo.jno);
		let resultHtml = `
      <table>
         <tr height="20"><td>Jno</td><td>${jo.jno}</td></tr>
         <tr height="20"><td>JoName</td><td>${jo.jname}</td></tr>
         <tr height="20"><td>CaptainID</td><td>${jo.id}</td></tr>
         <tr height="20"><td>Project</td><td>${jo.project}</td></tr>
         <tr height="20"><td>Slogan</td><td>${jo.slogan}</td></tr>
      </table>`;
		document.getElementById('content').innerHTML = resultHtml;
		document.getElementById('content').style.display = 'block';
		document.getElementById('content').style.left = mleft + "px";
		document.getElementById('content').style.top = mtop + "px";

	}).catch(err => {
		if (err.response.status == '502') alert(err.response.data);
		else alert("~~ 시스템 오류, 잠시후 다시하세요 => " + err.message);
	});
}

// 2.2.2) MouseOut: hideJoDetail
// => 화면에 표시되어있는 content div가 사라짐
function hideJoDetail() {
	document.getElementById('content').style.display = 'none';
}