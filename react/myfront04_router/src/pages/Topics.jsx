// ** Nested Routing
// 1) 자식 page 1,2,3 추가 ( Topics01 )
// => App.js의 라우트 path "/topics/*" 로 수정
import { Link, NavLink, Route, Routes } from "react-router-dom";

export default function Topics() {
  return (
    <div>
      <h2>Topics</h2>
      {/* 1) 자식 page 1,2,3 추가 */}
      <ul>
        <li><NavLink to="/topics/1">html</NavLink></li>
        <li><NavLink to="/topics/2">javascript</NavLink></li>
        <li><NavLink to="/topics/3">React</NavLink></li>
      </ul>
      <div>
        <Routes>
          <Route path="/1" element={"html"} />
          <Route path="/2" element={"js"} />
          <Route path="/3" element={"React"} />
        </Routes>
      </div>
    </div>
  );
}
