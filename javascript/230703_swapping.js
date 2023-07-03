'use strict';

let n1 = 5, n2 = 10;

// 임의의 변수 선언
let t = 0;

t = n2;
n2 = n1;
n1 = t;

t = n1;
n1 = n2;
n2 = t;

/* 
정수1 : 100
정수2 : 1

1부터 100까지의 누적합 : 5500
*/

// 누적합, 작은 수, 큰 수 선언
let tot = 0,
    min, max;

// 작은 수, 큰 수 입력
min = +prompt('정수1 : ');
max = +prompt('정수2 : ');

// min이 max보다 클 경우 값 교환
if (min > max) {
    let t = min;

    min = max, max = t;
}


// 누적합 계산
for (let i = min; i <= max; i++) {
    tot += i;
}

// 출력
alert(`${min}부터 ${max}까지 누적합 : ${tot}`);

/* ------------------------------------------ */

let tot = 0, n;

while (1) {
    n = +prompt('정수 : ');

    if (n === 0) {
        break;
    }

    tot += n;
}

/* 
for (; ;) {
    n = +prompt('정수 : ');
    if( n === 0) break;
    tot += n;
}
*/

alert(`누적합 : ${tot}`);