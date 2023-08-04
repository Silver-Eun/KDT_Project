// const Viewer_old = (props) => {

//     return (
//         <div>
//             <h2>현재 Count는 </h2>
//             <h2>{props.count}</h2>
//         </div>
//     );
// }

// 객체 구조분해 적용
const Viewer = ({ count }) => {
    return (
        <div>
            <h2>현재 Count는 </h2>
            <h2>{count}</h2>
        </div>
    );
}

export default Viewer;