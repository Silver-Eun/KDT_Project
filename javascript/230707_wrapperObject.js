/*
< 래퍼 객체(Wrapper Object) >
- number, string, boolean, symbol, bigint등의 원시 타입의 값을 감싸는 형태로 각각의 데이터
  타입에 대응하는  Number, String, Boolean, Symbol , BigInt등의 객체가 제공되어  원시 값에
  대한  체이닝(Chaining) 연산자(멤버연산자) .를 통한  속성(Property)이나  메서드에 접근 시
  자동으로 생성되어 참조가 끝나면 소멸.

< Number >
- 래퍼(Wrapper) 객체로써 숫자 형태의 문자열 값을 숫자 타입으로 변환한 참조 및 값 반환.

형식 : new Number( 숫자 형태의 문자열 ) - 인수를 Number 타입의 참조형 객체로 저장 후 참조를
                                          반환하되,  참조에 대한 연산을 적용 시 자동 언박싱
                                          (Unboxing)을 통한 원시 숫자 타입으로 변환되어 처리.

       Number( 숫자 형태의 문자열 )     - 함수 호출 형태로써 변환된 원시 숫자 값을 직접 반환.

- 객체 생성 및 함수 호출 형식의 인수에 숫자 형태가 아닌 문자열을 전달하면 NaN(Not-a-Number)
  반환.

*/

'use strict';

// 원시 값에 대한 속성 또는 메서드로 접근시 자동으로 래퍼 객체 생성.
// charAt : 인수로 문자열에 대한 인덱스를 지정함으로써 해당 위치의 문자값 반환.
console.log('string'.charAt(5));
console.log();


// Number객체의 참조 반환.
const n1 = new Number('5');
// 함수 호출을 통한 형변환된 값을 직접 반환.
const n2 = Number('5');

console.log(n1);
console.log(n2);
// Number객체(n1)에 대한 산술 연산을 적용하여 자동 언박싱된 number로 변환되어 연산 처리.
console.log(n1 + 5);
console.log(n2 + 5);
console.log();


console.log(n1 == 5);     // true
console.log(n2 == 5);     // true
console.log(n1 === 5);    // false
console.log(n2 === 5);    // true
// typeof 연산자 : typeof 연산자 우변에 타입 측정 대상을 명시함으로써 문자열 형태로
// 타입 정보를 반환.
console.log(typeof n1);   // object
console.log(typeof n2);   // number

// typeof 연산자를 활용한 타입체크.
if (typeof n1 === 'object') {
    console.log('타입 일치');
} else {
    console.log('타입 불일치');
}
console.log();


// 인수 값이 숫자 형태가 아닌 경우에는 NaN 저장.
const n3 = new Number('a');
// 인수 값이 숫자 형태가 아닌 경우에는 NaN 반환.
const n4 = Number('a');

console.log(n3);
console.log(n4);
console.log();


/* 숫자 형태의 문자열에 대한 Number함수를 통한 숫자 타입으로 변환 연산. */
const n5 = '8';
const n6 = '10';

console.log(n5 + n6);
// n5는 number타입으로 변환되었지만 문자열(n6)에 대한 + 연산자에 의해 결과적으로 문자열 결합 연산 적용.
console.log(Number(n5) + n6);
console.log(Number(n5) + Number(n6));
console.log(+n5 + +n6);
console.log();


// Infinity : 양의 무한대
console.log(8 / 0);
// -Infinity : NEGATIVE_INFINITY(음의 무한대)
console.log(-8 / 0);
// NaN : Not-a-Number
console.log('string' / 0);
console.log();


/*
< NaN의 특성과 타입 체크 시 주의점 >
*/
// NaN은 다른 NaN과 일치하지 않는 특성.
console.log(NaN === NaN);
// NaN에 대한 직접적인 타입 체크 시 typeof 또한 연산자이므로 자동
// number타입(0)으로 형변환됨에 주의.
console.log(typeof NaN);
// 문자열에 부호(+) 연산을 적용하였으므로 결과는
// NaN으로 평가되지만 다시 typeof연산자를 적용함
// 으로써 0으로 변환 연산이 적용된 상태에서 타입
// 평가를 함으로써 비교 연산의 결과는 true가 반환.
console.log(typeof +'1234' === 'number');
console.log(typeof +'string' === 'number');

// isNaN : 인수의 대상이 NaN인지의 여부를 평가하여 boolean값 반환.
console.log(isNaN(NaN));
console.log();


// undefined는 비교 연산 시 false로 평가되지만
// number 형식으로 변환은 불가.
console.log(Number(undefined));   // NaN
console.log(Number(null));        // 0
console.log(Number(true));        // 1
console.log(Number(false));       // 0
// 양쪽 끝의 공백을 제거한 후 변환된 number타입 값으로 반환.
console.log(Number('  123  '));
// 양쪽 끝이 아닌 중간에 공백이나 숫자 형태가 아닌 값이 포함된 경우, 변환에 실패하여 NaN 반환.
console.log(Number('  12 3  '));
// 공백이나 빈 문자열은 0으로 변환하여 반환.
console.log(Number('  '));
console.log();


let n7;
let n8 = null;
let n9 = true;

// n7은 초기화되지 않았으므로 undefined로 평가되며, undefined는 연산 시
// 숫자형식으로 변환이 불가하므로 NaN 반환.
console.log(n7 + 5);
console.log(n8 + 5);
console.log(n9 + 5);

// 공백은 래퍼 객체를 통한 명시적 변환인 경우에는 0이 반환되지만,
// 이와 같이 연산 시에는 자동 형변환되지 않음.
console.log(' ' + 5);
console.log();


const n10 = 4;
const n11 = 10;

console.log(String(n10) + String(n11));   // String 래퍼 객체를 통한 문자열 변환.
console.log(String(n7) + String(n8));     // String 래퍼 객체를 통한 문자열 변환.