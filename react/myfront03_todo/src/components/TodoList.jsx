// ** Context 적용
// => immport: useContext, TodoContext
// => useContext() 로 Data 전달받음
//    TodoList 컴포넌트 인자로 전달받은 Props Data는 필요 없으므로 삭제

import "./TodoList.css";
import TodoItem from "./TodoItem";
import { useMemo, useState, useContext } from "react";
import { TodoContext } from "../App";

const TodoList = () => {
  // ** Context 적용
  // => 구조분해 적용
  //    onUpdate, onDelete 는 TodoItem 으로 전달하기 위해 필요했지만,
  //    이제는 필요없으므로 todo 만 정의함
  const { todo } = useContext(TodoContext);

  // ** 검색 기능
  const [search, setSearch] = useState("");
  const onChangeSearch = (e) => {
    setSearch(e.target.value);
  };

  const getSearchResult = () => {
    return search === ""
      ? todo
      : todo.filter((it) =>
          it.content.toLowerCase().includes(search.toLowerCase())
        );
  };
  // ------------------------------------------------
  // ** 분석 기능 추가
  // 1) 분석 함수 추가
  // => 배열 todo 의 아이템 총갯수, 완료갯수, 미완료갯수를 객체에 담아 return
  //   const analyzeTodo = () => {
  //     console.log("** analyzeTodo 호출 **");
  //     const totalCount = todo.length;
  //     // => 배열 todo의 isDone의 값이 true인 item의 개수
  //     const doneCount = todo.filter((it) => it.isDone).length;
  //     const notDoneCount = totalCount - doneCount;
  //     return { totalCount, doneCount, notDoneCount };
  //   };

  // 2) 분석 함수 호출
  // => analyzeTodo() 호출하고 return 값을 구조분해 할당
  //   const { totalCount, doneCount, notDoneCount } = analyzeTodo();

  // 3) 분석 결과
  // => analyzeTodo()는 todo에 저장 아이템이 많아질수록
  //    연산량이 많이지며, 성능에 영향을 줄수있음
  // => 불필요한 호출이 있는지 확인 위해 analyzeTodo()에 콘솔 메시지 추가
  //   ( 마운트시 1 + 검색어 단어 입력시마다 호출됨 을 확인 )
  // => 재연산이 필요없는 경우에도 호출됨을 알 수 있다.
  //   ( 컴포넌트 내부의 함수는 리랜더링 할때 마다 호출되기 때문 )
  // => 해결 위해 useMemo() 적용.

  // 4) useMemo() 적용 최적화
  // => const value = useMemo(callback, [의존성배열]);
  //    의존성배열 의 값이 바뀌면 callback 함수를 실행하고 결과값 return
  // Code1.
  const returnObj = useMemo(() => {
    console.log("** analyzeTodo 호출 **");
    const totalCount = todo.length;
    // => 배열 todo의 isDone의 값이 true인 item의 개수
    const doneCount = todo.filter((it) => it.isDone).length;
    const notDoneCount = totalCount - doneCount;
    return { totalCount, doneCount, notDoneCount };
  }, [todo]);
  const { totalCount, doneCount, notDoneCount } = returnObj;
  // => 이때의  returnObj 는 callback 함수의 return 값을 가지고있는 객체
  // => todo 배열의 값에 변경사항이 있을 때에만 analyzeTodo 함수 호출
  // => Code2.
  //    위 analyzeTodo() 를 useMemo 의 콜백함수로 사용하고,
  //    useMemo 의 return 값을 바로 할당.
  //  const {totalCount, doneCount, notDoneCount} = useMemo(analyzeTodo, [todo]);

  return (
    <div className="TodoList">
      <h3>TodoList 📋</h3>
      <div>
        <div>* 총일정 갯수: {totalCount}</div>
        <div>* 완료된 일정: {doneCount}</div>
        <div>* 미완료 일정: {notDoneCount}</div>
      </div>
      <input
        className="searchbar"
        value={search}
        onChange={onChangeSearch}
        placeholder="검색어를 입력하세요"
      />
      <div className="list_wrapper">
        {/* ** 검색기능 : 배열(todo) 에  filter() 적용   
            ** TodoItem Context 적용  
            => Context에서 직접 전달받는 Props는 필요 없으므로 삭제한다.
               그러나 해당하는 Item 은 Props 로 전달해야하므로 그냥둔다.  */}
        {getSearchResult().map((it) => ( <TodoItem key={it.id} {...it} /> ))}
      </div>
    </div>
  );
};

export default TodoList;
