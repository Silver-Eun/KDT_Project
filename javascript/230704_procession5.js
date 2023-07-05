'use strict';

let Y = 1;

for (let i = 1, Y = 1; i <= 3; i++){
    for (let j = 1; j <= i + 2; j++) {
        if (j < 4 - i) {
            document.write('&nbsp; &nbsp;');
        } else {
            document.write(`${String(Y).length >= 2 ? '' : '&nbsp;'}${Y++} `);
        }
    }
    document.write('<br/>');
}