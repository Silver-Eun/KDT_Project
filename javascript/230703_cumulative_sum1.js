'use strict';

/* 
작은 수 : 1
큰 수 : 10

1부터 10까지의 누적합 : 55
*/

// 누적합, 작은 수, 큰 수 변수 선언
let tot = 0, min, max;

// 작은 수, 큰 수 입력
// (문자열에서 숫자로 변환)
min = +prompt('작은 수 : ');
max = +prompt('큰 수 : ');

// 누적합 반복문
// i = min ~ max
for (let i = min; i <= max; i++) {
    tot = tot + i;
}

//결과 출력
alert(`${min}부터 ${max}까지의 누적합 : ${tot}`);

// ---------------------------------------------

/* 
정수1 : 100
정수2 : 1

1부터 100까지의 누적합 : 5500
*/

// 누적합, 정수1, 정수2, 작은 수, 큰 수 변수 선언
let tot1 = 0,
    n1, n2,
    min1, max1;

// 정수1, 정수2 입력
n1 = +prompt('정수1');
n2 = +prompt('정수1');

// 작은 수, 큰 수 판단
if (n1 < n2) {
    min = n1, max = n2;
} else {
    min = n2, max = n1;
}

// 누적합 계산
for (let i = min; i <= max; i++) {
    tot += i;
}

// 출력
alert(`${min}부터 ${max}까지의 누적합 : ${tot}`);