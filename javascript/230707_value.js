/*
< 자바스크립트의 자료 표현 형식 >
- boolean, null, undefined, number, bigint, string, symbol 이상의 기본 자료형(Primitive : 원시 타입)과
  참조형  Object로 구성되며 변수의 타입이 아님에 유의.   Object를 제외한 기본 자료형은 더 이상 쪼갤수
  없는 값을 의미하고 이러한 값을 원시값(Primitive value)이라 지칭하며 설정 및 쓰기가 불가한 값(상수)을
  의미.

boolean : null, NaN(Not a Number), Undefined, ""(빈문자열), 0 은  false와 같진 않지만  조건식이나 산술
          연산 시 상호 변환하여 평가 가능하며, 그 외의 값에 대해서는 연산 시 true로 변환하여 평가 가능.
          논리 연산자 !(not)을 이용하여 확인 가능.

undefined : 값을 할당하지 않은 변수(미 초기화)는 브라우저가 undefined값 할당.
            또한 명시적 반환(return)을 하지않는 함수도 undefined값을 반환.

null : null은 사용자가 명시적으로 할당.

bigint : number보다 더 큰 정수를 표현하기 위한 타입. 숫자 상수에 접미사 n을 붙여 표현.

symbol : ECMAScript 6에서 추가된 타입으로 열거형과 유사한 고유한 식별자로써의 기능을 담당하며 객체의
         속성 key값으로도 사용 가능.    다른 래퍼(Wrapper) 객체와는 달리 new연산자를 통한 Symbol객체
         생성은 불가.

< 변수의 자료형 >
- 자바스크립트에서 변수의 타입은 느슨한 타입(loosely typed) 또는 동적 타입(dynamic typed)이한
  적용되어 별도의 변수의 타입을 구분하지 않으며 대입되는 값에 의해 그 타입이 동적으로 결정.
  따라서 하나의 변수에 여러 타입의 값을 저장 가능.
*/

'use strict';

let value;

value = 15;
value = null;
value = false;
// Dynamic typing.
value = 'string';

console.log(value);
console.log();


// boolean 타입의 값이 대상이 되는 논리연산자(!)에 다른 타입의 값을
// 대상으로 함으로써 자동으로 boolean 타입의 값으로 변환하여 연산.
console.log(!null);
console.log(!undefined);
console.log(!NaN);
console.log(!'');
console.log(!0);
console.log();


// n은 명시적 선언을 하였지만, 초기화하지 않았으므로 undefined값으로 평가.
let n;
console.log(n);
console.log();

// 명시적 반환을 하지 않는 함수도 undefined값을 반환.
function test1() {
    let n = 5;
}
function test2() {
    return 10;
}
console.log(test1());
console.log(test2());