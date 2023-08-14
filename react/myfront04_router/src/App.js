// ** Router 적용하기
// => 마치 Page가 이동하는것처럼 url에 의해
//    적당한 컴포넌트가 배치 되도록 해줌

// 1. 프로젝트 root 경로에 리액트 라우터 설치
// => npm install react-router-dom
// => package.json으로 버전확인 ( 6.x.x 인지 )
// => 구버전 제거 : npm uninstall react-router-dom
// => 최신버전 재설치 : npm install react-router-dom@6

// 2. Project 구성
// => src -> components, pages, images

// 3. 실습
// 1) BrowserRouter 컴포넌트
// => Router 적용하려는 최상위 컴포넌트를 감싸는 Rapper 컴포넌트
// => index.js의 App에 적용

// 2) Routes, Route 컴포넌트
// => Routes: Route 컴포넌트들을 감싸며 ( 6 이전버전의 Switch가 변경됨)
// => Route : path, element_path에 해당하는 컴포넌트
// => Link_to : Page 가 리로드 되지않도록 해줌 (SPA 구현에 적합)
// => NavLink_to
//    - 사용자가 어느 페이지에 위치하는지 알 수 있도록 해줌
//    - 개발자도구 elements Tab 에서 확인해보면 class="active" 속성 추가되어있음
//    - App.css 에 아래코드 추가후 확인
//      .active {
//          background-color: tomato;
//          text-decoration: none;
//       }

// 3) HashRouter 컴포넌트
// => url에 #을 추가해 어떤 Path 에서 접근 하더라도
//    동일한 웹Page를 제공할 수 있도록 해줌
// => BrowserRouter와 비교해본다

// 4) Nested Routing
// => Topics.jsx

// ** 버전 6 달라진점
// => Switch -> Routes
// => path 매칭 규칙
//    앞부분만 일치(exact 옵션사용) -> 정확히 일치 (exact 옵션사용불가)

import { Routes, Route, NavLink, Link } from "react-router-dom";
import "./App.css";
import Contact from "./pages/Contact";
import Home from "./pages/Home";
import Topics from "./pages/Topics";

function App() {
  return (
    <div className="App">
      <h2>** React Router Dom Test **</h2>
      {/* 1) 적용 전
      <Home />
      <Topics />
      <Contact /> */}
      {/* 2) a_href : page가 reload됨 
      <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/topics">Topics</a></li>
        <li><a href="/contact">Contact</a></li>
      </ul> */}
      {/* 3) Link to : page가 reload 되지않게 해줌
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/topics">Topics</Link></li>
        <li><Link to="/contact">Contact</Link></li>
      </ul> */}
      {/* 4) NavLink to : 사용자가 어느 페이지에 위치하는지 알 수 있게 해줌 */}
      <ul>
        <li><NavLink to="/">Home</NavLink></li>
        <li><NavLink to="/topics">Topics</NavLink></li>
        <li><NavLink to="/contact">Contact</NavLink></li>
      </ul>
      <Routes>
        <Route path="/" element={<Home />} />
        {/* <Route path="/topics" element={<Topics />} /> */}
        <Route path="/topics/*" element={<Topics />} />
        <Route path="/contact" element={<Contact />} />
      </Routes>
    </div>
  );
}

export default App;
