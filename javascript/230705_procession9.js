'use strict';

let v, line, nCnt, st, ed;
nCnt = String(line * line).length;

line = +prompt('줄 수');

for (let i = 1, v = 1; i <= line; i++) {
    if (i < 3) {
        st = i;
        ed = 6 - i;
    } else {
        st = 6 - i;
        ed = i;
    }
    
    for (let j = 1; j <= ed; j++) {
        if (j < st) {
            document.write('&nbsp;&nbsp;&nbsp;');
        } else {
            document.write(`${String(v).length >= 2 ? '' : '&nbsp;'}${v++} `);
        }
    }
    document.write('<br/>');
}