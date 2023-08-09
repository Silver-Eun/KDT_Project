import "./App.css";
import Header from "./components/Header";
import TodoEditor from "./components/TodoEditor";
import TodoList from "./components/TodoList";
import { useReducer, useState, useRef } from "react";
import TestComp from "./components/testComp";

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

function reducer(state, action) {
  switch (action.type) {
    case "Create": {
      return [action.newItem, ...state];
    }
    case "Update": {
      return state.map((it) =>
        it.id === action.targetId ? { ...it, isDone: !it.isDone } : it
      );
    }
    case "Delete": {
      return state.filter((it) => it.id !== action.targetId);
    }
    default:
      return state;
  }
}

function App() {
  // 3.1) 배열을 리스트로 랜더링하기
  const [todo, dispath] = useReducer(reducer, mockTodo);
  // => useReducer로
  const idRef = useRef(mockTodo.length);
  // *** => dispatch_상태변화촉발(이벤트 감지)과 reducer()_상태값 변경함수로 나뉘어짐
  // 3.2) 일정추가 (create) 함수 생성
  // => 상대값 변경부분을 reducer()에게 맡기고, 이를 위해
  //    dispatch 호출해서 action(type, data) 값을 전달해줘야함
  const onCreate = (content) => {
    dispath({
      type: "Create",
      newItem: {
        id: idRef.current,
        isDone: false,
        content: content,
        createDate: new Date().getTime(),
      },
    });
    idRef.current += 1;
  };

  // 3.3) 일정 수정
  const onUpdate = (targetId) => {
    dispath({ type: "Update", targetId });
  };

  // 3.4) 일정 삭제
  const onDelete = (targetId) => {
    dispath({ type: "Delete", targetId });
  };

  return (
    <div className="App">
      <TestComp />
      <Header />
      <TodoEditor onCreate={onCreate} />
      <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
  );
}

export default App;
