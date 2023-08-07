// => 클린업 함수
//    - useEffect 의 콜백함수에서 return 하는 함수
//    - 콜백함수를 재호출하기 전에 실행
import { useEffect } from "react"

export default function Even() {

    // => UnMount 제어하기
    // => useEffect의 콜백함수에서 콜백함수 return 하도록 작성
    // => 이 콜백함수를 클린업 함수라하고
    //    Even 컴포넌트가 리렌더링되기 직전에 호출
    useEffect(() => {
        return () => { console.log('** Even Component UnMount') };
    });

    return <div>현재 count 값은 짝수입니다</div>
}