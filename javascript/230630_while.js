'use strict';

/*
반복(회전수) 결정 조건 : 1) 처음 2) 끝 3) 일정한규칙

 while (조건식(반복)) {
     반복실행블럭;
}
 */

// 23 ~ 37
let i = 22;

while (i < 37) {
    i++;
    console.log(i);
}

// 79 ~ 58
let i = 79;

while (i > 57) {
    console.log(i);
    i--;
}

// -12 ~ 9
let i = -12;

while (1) {
    console.log(i);
    i++;
    if (i >= 10 ) break;
}

// 36 ~ 68
let i = 35;

while (1) {
    i++;
    if (i >= 69 ) break;
    console.log(i);
}

// -23 ~ -9
let i = -23;

while (1) {
    console.log(i);
    if (i >= -9) break;
    i++;
}
