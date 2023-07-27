import logo from "./logo.svg";
import "./App.css";
import MyHeader from "./component/Header";
import Body from "./component/Body";
import Footer from "./component/Footer";
// ** import
// => component는 MyComp from 'real_file_path';
//    내부 코드에서 MyComp로 인식
// => css는 경로만 지정

function App() {
  const name = "GreenComputer";
  // => 객체를 정의하고 Header Component로 전달, 출력

  const person = {
    name: 'kim',
    age: 30
  }
  
  return (
    <div className="App">
      <MyHeader person = {person} name = {person.name} age = {person.age} />
      <Body name = {name} country = {'경기도 성남시'} />
      <Footer />
    </div>
  );
}

export default App;

{/* <header className="App-header">
  <img src={logo} className="App-logo" alt="logo" />
  <p>
    Edit <code>src/App.js</code> and save to reload.
  </p>
  <a
    className="App-link"
    href="https://reactjs.org"
    target="_blank"
    rel="noopener noreferrer"
  >
    Learn React
  </a>
</header> */}