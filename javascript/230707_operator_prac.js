/* 
< 문제 >
- 두 수를 입력받아 합을 산출하여 출력하는 프로그램 구현.
  숫자 입력 시 입력없이 "확인" 버튼을 누르거나 "취소" 버튼을 누르는
  상황에 대한 예외 처리는 제외.
*/

'use strict';

let n1, n2;

n1 = prompt('정수1');
n2 = prompt('정수2');

if (!isNaN(n1) && !isNaN(n2)) {
    alert(`${ n1 } + ${ n2 } = ${+n1 + +n2}`);
} else {
    alert('두수 중 하나는 숫자가 아닙니다.');
}
/*  */
/* let tot;

n1 = +prompt('정수1');
n2 = +prompt('정수2');

tot = n1 + n2;

if (isNaN(tot)) {
  alert('두수 중 하나는 숫자가 아닙니다.');
} else {
  alert(`${ n1 } + ${ n2 } = ${tot}`);
} */
