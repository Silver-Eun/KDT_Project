'use strict';

let tot = 0, n1, n2;

do {
    n1 = +prompt('정수1');
    n2 = +prompt('정수2');
} while (n1 > n2)

for (let i = n1; i <= n2; i++) {
        tot += i;
    }

alert(`${n1}부터 ${n2}까지 누적합 : ${tot}`);