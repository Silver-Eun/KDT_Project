'use strict';

let num1, num2;

// +를 붙여서 문자열을 숫자로 변경
num1 = +prompt('첫번째 정수 입력 : ');
num2 = +prompt('두번째 정수 입력 : ');

alert(num1 == num2 ? '같음' : '큰 수는 ' + (num1 > num2 ? num1 : num2));
// alert(num1 > num2 ? '큰 수는 ' + num1 : num1 == num2 ? '같음' : '큰 수는 ' + num2);