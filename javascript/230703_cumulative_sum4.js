'use strict';

let tot = 0;

for (let i = 1; i < 40;) {
    tot += i;
    i += 2;
}

alert(`1, 3, 5, 7, 9 ~ 20번째 항의 누적합 : ${tot}`);

/* */
// let tot = 0,
//     n = -1;

// for (let i = 0; i < 20; i++) {
//     n += 2;
//     tot += n;
// }
//
// console.log(tot);

/* */
// let tot = 0,
//     n = 1;

// for (let i = 0; i < 20; i++) {
//     tot += n;
//     n += 2;
// }
// console.log(tot);

/* */
// let tot = 1,
//     n = 1;

// for (let i = 1; i < 20; i++) {
//     n += 2;
//     tot += n;
// }
// console.log(tot);