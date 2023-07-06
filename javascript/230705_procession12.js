'use strict';

let v, line, m;

line = +prompt('줄 수');
m = (line + 1) / 2;

for (let i = 1, v = 1, st, ed; i <= line; i++) {
    
    if (i <= m) {
        st = (m + 1) - i;
        ed = i + (line - m);
    } else {
        st = i - (line - m);
        ed = (line + m) - i;
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