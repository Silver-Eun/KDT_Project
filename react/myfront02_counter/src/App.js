// ** component LifeCycle
// => component는 개념적으로 props를 input으로 하고
//    UI가 어떻게 보여야 하는지 정의하는 React Element를 output으로 하는 함수.
// => UI를 구성하기 위해서는 화면에 component를
//    그리고(Mounting), 갱신하고(Updating), 지워야(Unmounting) 함.
// => component는 이 과정에서 각 프로세스 진행단계 별로 Lifecycle 함수로 불리는 특별한 함수가 실행됨.
//    개발자는 이를 재정의하여 component를 제어할 수 있음.(class component)

// => Mounting : component를 페이지에 처음 랜더링 할때
// => Updating : State, Props 값이 바뀌거나 부모component가 리랜더하면서 자신도 리랜더 될때
// => Unmounting : component가 페이지에서 제거될때 (더이상 랜더링하지않음)

// => 함수 component에서는 useEffect를 이용하여 제어함.

// ** useEffect
// => 어떤 값이 변경될때 마다 특정코드를 실행하는 리액트훅이며
//    이것을 "특정값을 검사한다"라고 표현함
// => 예를 들면 State 값이 바뀔때 마다 변경된 값을 콘솔에 출력하게 할 수 있음

// => useEffect(callback_함수, [deps]_의존성 배열)
//    두번쨰 인자인 의존성 배열요소의 값이 변경되면 첫번째 인자인 콜백함수를 실행함

// ** Test
// => 1) State 변수인 count 값이 바뀌면 바뀐값을 콘솔로 출력한다.
// => 2) State 변수 text 추가후 확인하기.
// => 3) LifeCycle 제어
// => 4) Mount 제어
// => 5) Update(리랜더링)시에만 호출하도록 변경
// => 6) UnMount 제어
//    6.1) 클린업 이해 (setInterval 활용)
//    6.2) 클린업을 이용한 언마운트 제어하기

import "./App.css";
import { useState, useEffect, useRef } from "react";
import Controller from "./component/Controller";
import Viewer from "./component/Viewer";
import Even from "./component/Even";

function App() {
  const [count, setCount] = useState(0); // deStructuring, 비구조할당
  const onChangeState = (num) => {
    setCount(count + num);
  };

  // 1) useEffect 적용
  // => state 변수인 count값이 바뀌면 바뀐 값을 콘솔로 출력
  // => count 값 초기화도 감지
  useEffect(() => {
    console.log(`** useEffect test1) count => ` + count);
  }, [count]);

  // 2) State 변수 text 추가후 확인하기.
  const [text, setText] = useState("");
  const onChangeText = (e) => {
    setText(e.target.value);
  };
  useEffect(() => {
    console.log(`** useEffect test2) text => ` + count + text);
  }, [text]);
  // => [text] : count 값 변경시 출력안됨
  // => [count] : text 값 변경시 출력안됨
  // => [count, text] : text 또는 count 값 변경시 출력

  // 3) 두번째 인수가 없는 useEffect 정의 후 비교
  // => 콜백함수를 실행시켜주는 조건값이 없는 경우
  // => 렌더링 할 때마다 호출
  useEffect(() => {
    console.log(`** useEffect test3) 배열없음 count => ` + count);
  });

  // 4) Mount 제어
  // => useEffect를 추가하고 두번째인자는 빈 배열을 전달
  // => useEffect 에 빈 배열을 전달하면 마운트 시점에만 콜백함수 실행
  //    ( 처음 한번만 실행됨 확인 → 그러므로 Mount 제어에 이용 )
  useEffect(() => {
    // alert('Hello useEffect');
    console.log(`** useEffect test4) 빈 배열 count => ` + count);
  }, []);

  // => 5) Update(리랜더링)시에 호출하도록 변경
  // => 위 3) 렌더링에서 최소 렌더링만 제외시켜주면 됨
  // => 최초의 렌더링(마운트)인지 확인 후 아닌 경우 출력
  // => 그러므로 최초 렌더링(마운트)인지 판별하는 변수를 정의하고 초기값은 false
  //    Ref 객체로 생성
  //    ( Ref 객체는 DOM요소 참조 뿐만아니라 컴포넌트의 변수로도 활용됨 )
  const didMountRef = useRef(false);

  useEffect(() => {
    if (!didMountRef.current) {
      // 최초 렌더링(마운트) 시점 -> 출력하지 않고 return_callBack함수 종료
      didMountRef.current = true;
      return;
    } else {
      console.log(`** useEffect test5) Update => ` + count + text);
    }
  });
  /* const isUpdateRef = useRef(false);
  //let isUpdateRef = false ;
  // => boolean Type은 const 정의 불가능 (오류)
  //    const 로 정의하기위해 useRef 사용 ( )
  //    변수의 중요성에 따라 const 로 정의
  useEffect(() => {
    if (!isUpdateRef.current) {
      // if ( isUpdateRef.current==false ) {
      // if ( !isUpdateRef.current )  ->  isUpdateRef.current==false
      // 최초 랜더링(마운트) 시점 -> 출력하지않고 return_콜백함수종료
      isUpdateRef.current = true;
      return;
    } else {
      console.log("** useEffect test5) Update => " + count + ", " + text);
    }
  }); //useEffect */
  // => 위 3)과 같이 의존성배열을 전달하지 않았으므로 마운트시점에도 콜백함수는 실행되어야 하지만,
  // => 조건문에서 didMountRef의 초기값 false인 마운트(처음 랜더링) 시점에는 if 구문을 실행하므로
  //    콘솔출력을 하지않고 return되며, 이후 Update(리랜더링) 시점에만 출력

  // 6) UnMount 제어
  // => 클린업(CleanUp)
  //    특정함수가 실행되고 종료된 후 미처 정리하지못한 사항을 정리하는것
  // => 클린업 필요성 Test : useEffect (setInterval 사용하고 배열 없는) 추가
  // useEffect(() => { setInterval(() => { console.log('**') }, 1000) })
  // 렌더링할 때마다 호출, 클린업(cleanup) 기능이 없는 코드

  // => 두번째 인자 배열이 없으므로 랜더링 할때마다 콜백함수 실행됨
  // => 콜백함수에서 호출한 setInterval에 의해 1초마다 콘솔출력됨
  // => 그러나 + , - 클릭으로 리랜더링이 일어나면, 1초 상관없이 출력됨
  // => 콜백함수에서 호출한 setInterval에 의해 1초마다 콘솔출력됨
  // => 이유 : setInterval을 계속 호출하므로 복수의 setInterval 이 계속 생성되기때문
  //           호출한 setInterval을 종료시켜주지 않았기 때문
  //          (setInterval 은 clearInterval 을 호출해서 종료시켜야 멈춤)
  // => 해결 : useEffect의 클린업 기능

  // 6.1)
  // => 클린업 함수
  //    - useEffect의 콜백함수에서 return하는 함수
  //    - 콜백함수를 재호출하기 전에 실행됨,
  // => 그러므로 이를 이용하여 리랜더링 할때마다 새 setInterval을 생성하고
  //    기존 setInterval은 삭제하도록 할 수 있다.

  // => 클린업 함수 추가
  // useEffect(() => {
  //   const intervalId = setInterval(() => { console.log('**') }, 1000);
  //     return () => {
  //       console.log(`클린업 함수`);
  //       clearInterval(intervalId);
  //   }});

  // 6.2) 클린업을 이용한 UnMount 제어하기
  // => count 값이 짝수면
  //    "짝수 입니다" 를 출력하는 component(Even.jsx)를 생성
  // => 이를 이용하여 조건부 랜더링 구현
  //    ( import, <Even /> 랜더링코드 추가 )
  // => Even에 useEffect를 추가해서 UnMount 메시지 출력

  return (
    <div className="App">
      <h2>* Simple Counter *</h2>
      <section>
        <input value={text} onChange={onChangeText} />
      </section>
      <section>
        <Viewer count={count} />
        {count % 2 === 0 && <Even />}
        {/* && : 앞쪽의 조건식이 참이면 뒤쪽 리턴값 랜더링
                 ( 거짓이면 아무것도 랜더링하지않음 ) */}
      </section>
      <section>
        <Controller onChangeState={onChangeState} />
      </section>
    </div>
  );
}

export default App;
