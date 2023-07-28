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
// => 스타일파일 분리
//    Body.css(component 파일명과 동일),
//    import './Body.css'
// => css는 경로만 지정

// ** Props, 컴포넌트에 값 전달하기
// => Props(properties) 객체 : 부모에서 자식으로 값 전달
// => 그러므로 Body Component에 Props로 값을 전달하기 위해
//    App Component에서 전달(name 값을 body로 전달)

// ** React Event (Html 과 차이점)
// => 이벤트 핸들러 카멜표기
// => 콜백함수처럼 함수 그자체를 전달
// => onClick={onClickHandler}
// => 기본이벤트 제거 ( return false 대신 e.preventDefault() 명시적으로 호출해야함 )

// ** 이벤트객체 활용 실습

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
  // ** 매개변수 구조분해 적용
  const { name, country } = props;

  // ** 이벤트 핸들러
  // function clickTest() {...}
  const clickTest = (e) => {
    alert('hello => ' + e.target.name);
    console.log(`e 개체 확인 => ${e.type}`);
  }

  // ** 조건문 : jsx에서는 사용 불가능하지만 component에서는 가능
  if (b2) {
    return (
      <div className="body">
        <h1>** Body: JSX Test **</h1>
        <p>props.name = {props.name}, props.country = {props.country}</p>
        <p>props 구조분해적용 name = {name}, country = {country}</p>
        <p>산술식 : n1 + n2 = {n1 + n2}</p>
        <p>문자식 : s1 + s2 = {s1 + s2}</p>
        <p>논리식_Test : b1 = {b1}, AND = {b2 && b2}, 관계식 = {n1 === n2}</p>
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
        {/* react import 필요 */}
        <div>
          <h1 style={{ color: "black", backgroundColor: "orange" }}>** Body : JSX Test **</h1>
          <p>if 조건문 Test 중...</p>
          <img src={ img1 } width={"300px"} height={"300px"}  />
          <button onClick={clickTest} name="apple">클릭하세요</button>
          <button onClick={clickTest} name="banana">클릭하세요</button>
          <img src={img1} width={"300px"} height={"300px"} />
          <p>** HTML과 비교 : onclick = clickTest</p>
        </div>
        <div>{"최상위 Tag 규칙 필요시 <div> 또는 <React.Fragment> Tag로 감싸줌"}, 랜더링 되지 않으므로 div 대신 사용</div>
      </React.Fragment>
    );
  }
}

export default Body;
