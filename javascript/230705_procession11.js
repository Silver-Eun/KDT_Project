'use strict';

let v, line, m;

line = +prompt('줄 수');
m = (line + 1) / 2;

for (let i = 1, v = 1, st, ed; i <= line; i++) {
    
    if (i <= m) {
        st = 4 - i;
        ed = i + 2;
    } else {
        st = i - 2;
        ed = 8 - i;
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