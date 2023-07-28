// ** 1component 1file
// => 그러므로 export default를 많이 사용
export default function Header(props) {
  
  return (
    <header>
      <h1>** Header **</h1>
      <h3>props.person.name = {props.person.name}</h3>
      <h3>props.person.age = {props.person.age}</h3>
      {/* <h3>props.person = {props.person}</h3> : 오류 */}
    </header>
  );
}
