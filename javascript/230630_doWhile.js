'use strict';

/*
do {
    반복실행블럭
} while (조건식(반복));
*/

// 35 ~ 47
let i = 34;

do {
    i++;
    console.log(i);
} while (i < 47 );

// 61 ~ 99
let i = 60;

do {
    i++;
    if (i >= 100) break;
    console.log(i);
} while (1);

// 31 ~ 19
let i = 31;

do {
    console.log(i);
    i--;
} while (i > 18);

// -19 ~ -9
let i = -20;

do {
    i++;
    if (i >= -8 ) break;
    console.log(i);
} while (1);

// 87 ~ 64
let i = 87;

do {
    console.log(i);
    i--;
} while (i > 63);

// -11 ~ -37
let i = -10;

do {
    if (i <= -37) break;
    i--;
    console.log(i);
} while (1);


// 1 ~ 100
let i = 0 // 과거대상값
let tot = 0 // 최초가상누적합

do {
    i++; // 현재대상값 = 과거대상값 + 1
    tot = tot + i; // 현재누적합 = 과거누적합 + 현재대상값
} while (i < 100) // 현재대상값

console.log(tot);

// 1 ~ 100
let i = 1
let tot = 0

do {
    tot = tot + i
    i++
} while(i < 101)
console.log(tot);

//1 ~ 100
let i = 1  // 현재대상값
let tot = 0 // 최초가상누적합

while (i < 101) { // 미래대상값
    tot = tot + i; // 현재누적합 = 과거누적합 + 현재대상값
    i++; // 미래대상값 = 현재대상값 + 1
}
console.log(tot);

//1 ~ 100
let i = 0
let tot = 0

while (i < 101) {
    tot = tot + i
    i++
}
console.log(tot);