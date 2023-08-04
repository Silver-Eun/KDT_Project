import "./App.css";
import Controller from "./component/Controller";
import Viewer from "./component/Viewer";
import LifecycleExample from "./component/LifecycleExample";
import { useState } from "react";

function App() {
  const [count, setCount] = useState(0); // deStructuring, 비구조할당
  // => Controller,  Viewer 모두 필요하므로 부모에 정의
  // => State Lifting (끌어올리기) : State를 여러 컴포넌트에서 사용하도록 하기위해 부모에 정의하는것

  // ** 결론 (React 앱의 특징)
  // => State : 자식 컴포넌트와 데이터, 이벤트 공유
  // => 데이터 (Props) : 부모 -> 자식
  // => 이벤트 (함수)  : 자식 -> 부모
  // => 이러한 점을 고려해서 앱을 설계한다

  // ** 이벤트핸들러
  // => Data의 한종류이므로 자식 컴포넌트에 전달가능
  const onChangeState = (num) => {
    setCount(count + num);
  };

  console.log(`App Update`);
  return (
    <div className="App">
      <h2>* Simple Counter *</h2>
      <Viewer count={count} />
      <Controller onChangeState={onChangeState} />
      {/* <h2>* Lifecycle Test *</h2> */}
      {/* <LifecycleExample /> */}
    </div>
  );
}

export default App;
