'use strict';

let v, line, nCnt;
nCnt = String(line * line).length;

line = +prompt('줄 수');

for (let i = 1, v = 1; i <= line; i++) {
    for (let j = 1; j <= 2*line - i; j++) {
        if (j < i) {
            document.write('&nbsp;&nbsp;&nbsp;');
        } else {
            document.write(`${String(v).length >= 2 ? '' : '&nbsp;'}${v++} `);
         }
    }
    document.write('<br/>');
}