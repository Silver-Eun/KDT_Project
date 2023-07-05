'use strict';

let v, line, nCnt, st, ed, m;
nCnt = String(line * line).length;

line = +prompt('줄 수');

for (let i = 1, v = 1; i <= line; i++) {
    m = (line + 1) / 2;

    if (i < m) {
        st = i;
        ed = (line + 1) - i;
    } else {
        st = (line + 1) - i;
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