// ** TodoList (일정관리 앱1)
// 1. UI
// 2. Mock Data 만들기
// => Mock Data: 모조 Data (개발중 테스트 목적으로 사용하는 Data)
// => 할 일 item(Data_set) 을 담을 배열 생성
// => 앞으로 데이터를 저장하고 관리할 배열, Data_Table 역할
// => 구조
//    id : 아이템 식별을 위한 고유키
//    isDone: 할일 완료 여부 ( boolean )
//    content: 해야 할 일정
//    createDate: 일정 생성(등록) 시간
// => new Date().getTime()
//    Date 값을 getTime 메서드를 이용해 타임스템프 값으로 변환
//    이렇게 하면 보관데이터 용량이 줄어듬

// ** Date 주요 메서드
// => toDateString() :  날짜를 문자열로
// => toLocaleDateString() : 지역별 맞는 포맷으로

// 3. 기능구현
// 3.1) 배열을 리스트로 랜더링하기
// => App.js
//  -> Mock Data mockTodo를 state 변수 todo로
//  -> todo를 Props 이용하여 TodoList 로 전달
// => TodoList
//  -> 전달받은 배열을 map 메서드로 1건씩 TodoItem 으로 전달
//     ( map 을 이용해 컴포넌트 반복하기 )

// => 조건 추가하기 (검색기능)

// 3.2) 입력 (할일 추가)
// => TodoEditor
//  -> 새 item 입력, 추가 버튼 클릭
//  -> 부모 App에게 이벤트 발생을 알리고 item 전달
// => App
//  -> 전달받은 새 item을 배열에 추가,
//  -> state 변수인 todo 값 수정
// => TodoEditor: 입력폼 초기화

// 3.3) 일정 수정

// 3.4) 일정 삭제

// ----------------------------------
import "./App.css";
import Header from "./components/Header";
import TodoEditor from "./components/TodoEditor";
import TodoList from "./components/TodoList";
import { useState, useRef } from "react";

// 2. Mock Data 만들기
const mockTodo = [
  {
    id: 0,
    isDone: false,
    content: "React 공부하기",
    createDate: new Date().getTime(),
  },
  {
    id: 1,
    isDone: true,
    content: "Javascript 공부하기",
    createDate: new Date().getTime(),
  },
  {
    id: 2,
    isDone: false,
    content: "Java 공부하기",
    createDate: new Date().getTime(),
  },
  {
    id: 3,
    isDone: false,
    content: "MySQL 예습하기",
    createDate: new Date().getTime(),
  },
  {
    id: 4,
    isDone: false,
    content: "Spring 예습하기",
    createDate: new Date().getTime(),
  },
];

function App() {
  // 3.1) 배열을 리스트로 랜더링하기
  // => App.js
  //  -> Mock Data mockTodo를 state 변수 todo로
  //  -> todo를 Props 이용하여 TodoList 로 전달
  // => TodoList
  //  -> 전달받은 배열을 map 메서드로 1건씩 TodoItem 으로 전달
  //     ( map 을 이용해 컴포넌트 반복하기 )

  const [todo, setTodo] = useState(mockTodo);
  const idRef = useRef(mockTodo.length);

  // 3.2) 일정추가 (create) 함수 생성
  // => 일정을 인자로 전달받아 배열에 저장
  // 생성된 함수 TodoEiditor로 전달
  const onCreate = (content) => {
    // -> 추가할 일정 객체
    const newItem = {
      id: idRef.current,
      isDone: false,
      content: content,
      createDate: new Date().getTime(),
    };
    // -> 생성한 객체를 state 변수 todo 배열에 적용
    //    (todo 배열 + newItem)
    //    단, 출력 순서 등을 고려해서 newItem을 index값이 0이 되도록 저장
    setTodo([newItem, ...todo]);
    idRef.current += 1;
  };

  // 3.3) 일정 수정
  // => todo 변경(수정된 자료로)
  // => todo.map()으로 id가 일치하는 item의 isDone 값 변경 후(토글방식) return
  // => 수정대상인 id를 인자로 전달 받음
  const onUpdate = (targetId) => {
    setTodo(todo.map((it) => it.id === targetId ? {...it, isDone: !it.isDone} : it));
  }
  
  // 3.4) 일정 삭제
  // => todo 변경(삭제 대상 제거)
  // => todo.filter()로 id가 일치하는 item만 제외시키고 return
  // => 삭제대상인 id를 인자로 전달 받음
  const onDelete = (targetId) => {
    setTodo(todo.filter((it) => it.id !== targetId ));
  }

  return (
    <div className="App">
      <Header />
      {/* 3.2) 입력 (할일 추가) 함수 전달 */}
      <TodoEditor onCreate={onCreate} />
      {/* 3.1) 배열을 리스트로 랜더링하기 */}
      <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
  );
}

export default App;
