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
	              <th>Otaku</th>
	              <th>캐릭터이름</th>
	              <th>Regdate</th>
	              <th>오타쿠력</th>
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