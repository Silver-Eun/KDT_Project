'use strict';

/* 
let tot = 0,
    nNum = 0, n,
    a;

a = +prompt('입력할 정수의 개수')
if (n <= 0) {
        alert(`다시 입력하세요.`)
    }

while (nNum < a)
{
    n = +prompt('정수 : ');
    
    tot += n;
    
    nNum++;
}

alert(`누적합 : ${tot}`);
 */

let tot = 0,
    nNum = 0;
    
nNum = +prompt('입력할 정수의 개수')

while (nNum <= 0) {
    nNum = +prompt('다시 입력하세요.')
}

for (let i = 0; i < nNum; i++) {
    tot += +prompt(`정수${i + 1}`)
}

alert(`누적합 : ${tot}`);