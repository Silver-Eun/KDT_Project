// ** Props와 State
// => State도 값이므로 Props로 전달 가능
// => Body에 Child 컴포넌트 만들고 전달 Test
// => 전달된 부모 State 값이 변하면 Child 컴포넌트도 리랜더링됨.
// => state를 전달하지않은 경우와 비교
//    부모가 리랜더링 되면 Child 컴포넌트도 리랜더링됨

import { useState } from "react";
import "./Body.css";

// ** Child component 만들기
// => 부모로부터 전달받은 값이 짝수/홀수인지 출력
function Viewer_old(props) {
  return (
    <div>
      <p>child component</p>
      {props.number % 2 == 0 ? <h3>짝수</h3> : <h3>홀수</h3>}
    </div>
  );
}

// => 객체 구조분해 적용
function Viewer({ number }) {
  return (
    <div>
      <p>child component</p>
      {number % 2 == 0 ? <h3>짝수</h3> : <h3>홀수</h3>}
    </div>
  );
}

function Body() {
  const [number, setNumber] = useState(0);
  const onIncrease = () => {
    setNumber(number + 1);
  };
  const onDecrease = () => {
    setNumber(number - 1);
  };

  return (
    <div className="body">
      <h2>** Props와 State Test : 객체로 관리 **</h2>
      <h3>state 변수 number = {number}</h3>
      <p>Props로 number 값을 child component에 전달</p>
      <Viewer number={number} />
      <div>
        <button onClick={onIncrease}>+</button>
        <button onClick={onDecrease}>-</button>
      </div>
    </div>
  ); //return
}

export default Body;
