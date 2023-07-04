'use strict';

let Y = 1;

for (let i = 1, Y = 1; i <= 5; i++){ // i : 행
    for (let j = 1; j <= 5; j++) {   // j : 열
        document.write(`${String(Y).length >= 2 ? '' : '&nbsp;'}${Y++} `);
    }
    document.write('<br/>')
}