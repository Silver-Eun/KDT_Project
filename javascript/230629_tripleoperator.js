'use strict';

/* 
< 삼항조건 연산자 >
형식 : 조건식 ? true : false
false = 0, true = 1
*/

let gender = 1;

console.log(`당신의 성별은 ${gender ? '남자' : '여자'  } 입니다`);

let genderText;

gender ? genderText = '남자' : genderText = '여자';

console.log(genderText);