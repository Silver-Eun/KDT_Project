// ** JSX 컴포넌트 기본규칙
// => 컴포넌트명은 대문자로 시작(1component 1file)
// => 기본자료형, 산술식,..객체, 배열 등
// => 단, 객체, 배열명 직접사용은 불허
// => class는 JS 예약어이므로 className 으로 사용
// => 모든 Tag는 닫힘 규칙
// => 최상위 Tag 규칙 (필요시 <div> 또는 <React.Fragment> Tag 로 감싸줌)
// => 조건부 랜더링 : 삼항식, 조건문(JSX 에서는 사용불가능)

// ** CSS, 스타일 적용하기
// => 인라인 스타일링 : style={{스타일...}}
// => 스타일파일 분리 : Body.css(component 파일명과 동일) , import './Body.css'
// => css는 경로만 지정

// ** Props, 컴포넌트에 값 전달하기
// => Props(properties) 객체 : 부모에서 자식으로 값 전달
// => 그러므로 Body Component에 Props로 값을 전달하기 위해
//    App Component에서 전달(name 값을 body로 전달)
// ** Event
// ** State

import "./Body.css";
import img1 from './images/aaa.gif';
import React from "react";

function Body(props) {
  // => 부모로부터 전달받은 매개변수명은 자유롭게 사용 가능하지만 일반적으로 props로 사용
  let n1 = 10, n2 = 20;
  let s1 = "Hello", s2 = " React & JSX";
  let b1 = true, b2 = false;
  let obj = { id: "banana", name: "바나나" };

  // ** 부모로부터 전달된 props 확인
  // console.log(`${props}`);

  // ** 이벤트 핸들러
  function clickTest() {
    alert('hello');
  }

  // ** 조건문 : jsx에서는 사용 불가능하지만 component에서는 가능
  if (b2) {
    return (
      <div className="body">
        <h1>** Body: JSX Test **</h1>
        <p>props.name = {props.name}, props.country = {props.country}</p>
        <p>산술식 : n1 + n2 = {n1 + n2}</p>
        <p>문자식 : s1 + s2 = {s1 + s2}</p>
        <p>논리식_나중에 : OR = {b1 || b2}, AND = {b2 && b2}</p>
        {/* <p>Object : obj = {obj}  </p>
        => Uncaught Error: Objects are not valid as a React child
      => 단, 객체, 배열명 직접사용은 불허 */}
        <p>Object : obj.id = {obj.id}, obj.name = {obj.name}</p>
        <p>삼항식으로 n1 + n2의 값이 짝수이면 '짝수' 아니면 '홀수' 출력</p>
        <p> {(n1 + n2) % 2 === 0 ? "짝수" : "홀수"} </p>
      </div>
    );
  } else {
    return (
      <React.Fragment>
        <div>
          <h1 style={{ color: "black", backgroundColor: "orange" }}>** Body : JSX Test **</h1>
          <p>if 조건문 Test 중...</p>
          <img src={ img1 } width={"300px"} height={"300px"}  />
          <button onClick={clickTest}>클릭하세요</button>
          <img src={ img1 } width={"300px"} height={"300px"}  />
        </div>
        <div>{"최상위 Tag 규칙 필요시 <div> 또는 <React.Fragment> Tag 로 감싸줌"}</div>
      </React.Fragment>
    );
  }
}

export default Body;
