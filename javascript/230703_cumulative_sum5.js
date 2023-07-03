'use strict';

let n1 = 1, n2 = 1, n3 = 0, tot = 0;

for (let i = 3; i <= 100; i++) {
    n3 = n1 + n2;
    tot += n3;

    n1 = n2;
    n2 = n3;
}
alert(`1,1,2,3,5,8,13,...100번째 항까지의 합 ${tot}`);

/* ---------------------------------------------------- */
// 최초전전항값 = 1;
first = 1;
// 최초전항값 = 1;
second = 1;
// 최초현재항값;
current;
// 과거누적합 = 2;
tot = first + second;

for (let i = 0; i < 98; i++) {
    // 현재항값 = 전전항값 + 전항값;
    current = first + second;
    
    // 현재누적합 = 과거누적합 + 현재항값;
    tot = tot + current

    // 전전항값 = 전항값;
    first = second
    
    // 전항값 = 현재항값;
    second = current;
}