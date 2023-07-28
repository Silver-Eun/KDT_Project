// ** State
// => 값을 저장하거나 변경 할 수 있는 객체로 이벤트와 함께 주로 사용됨.
//   - 즉, 버튼 클릭시 버튼의 컬러를 변경할때 등에 사용됨
//   - 이벤트 발생 -> 이로 인하여 화면의 리렌더링이 필요한 경우 리렌더링이 자동으로 실행되도록 함
//    -> state 변수로 지정된 변수의 값에 변화가 일어나면 react에서는 리렌더링
// => useState 생성자함수로 State 생성
//    const [text_State변수, setText_set함수] = useState("초기값");
// => useState를 호출하면 현재상태값과 이 State변수의 값을 변경하는 set함수를 담은 배열을 return
// => 이후 State 변수값이 변하면 이를 반영하기 위해 component를 리렌더링함(component의 update)

// ** State로 사용자 입력 관리하기
// => 사용자가 Text를 입력할 때마다 console 출력하기

import "./Body.css";
import { useState } from "react";

function Body(props) {
  // ** state Text1
  const [count, setCount] = useState(0);
  const onIncrease = () => {
    if (count + 1 > 100) {
      alert("더이상 올라갈 수 없습니다.");
      setCount(0);
    } else {
      setCount(count + 1);
    }
  };
  const onDecrease = () => {
    if (count - 1 < 0) {
      alert("더이상 내려갈 수 없습니다.");
    } else {
      setCount(count - 1);
    }
  };

  // ** state Text2
  // => text(textarea도 동일)
  const [text, setText] = useState("");
  const textChange = (e) => {
    setText(e.target.value);
    console.log(e.target.value);
  };

  // ** state Text3
  const [date, setDate] = useState("");
  const dateChange = (e) => {
    setDate(e.target.value);
    console.log(`${e.target.value}`);
  };

  // ** state Text4
  // => select
  // -> html과 차이점
  //    selected 대신 value를 사용해 기본값 할당. (아래코드에서는 애플)
  //    선택된 option 값을 가져오려면, onChange를 사용해야하며,
  //    option 의 컨텐츠가 select 의 value 에 전달됨.
  const [option, setOption] = useState("애플");
  const jobChange = (e) => {
    console.log("** select : value=" + e.target.value);
    // => select option 의 컨텐츠 값이 자동으로 value 속성에 전달됨.
    setOption(e.target.value);
  };

  return (
    <div className="body">
      <h1>** Body **</h1>
      <p>** State Test **</p>
      <button onClick={onIncrease}>+</button>
      <button onClick={onDecrease}>-</button>&nbsp;
      <span>count = {count}</span>
      <div>
        <input value={text} onChange={textChange} />
        <p>{text}</p>
        <p>[연습]input Tag의 type date를 활용하여 값이 변경될 때마다 출력</p>
        <input type="date" value={date} onChange={dateChange} />
        <select value={option} onChange={jobChange}>
          <option key={"구글"}>구글</option>
          <option key={"삼성"}>삼성</option>
          <option key={"애플"}>애플</option>
          <option key={"네이버"}>네이버</option>
          <option key={"카카오"}>카카오</option>
        </select>
      </div>
    </div>
  ); //return
}

export default Body;
