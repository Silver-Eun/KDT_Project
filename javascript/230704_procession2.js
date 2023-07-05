'use strict';

let v = 1;

for (let i = 1, v = 1, ed = 1; i <= 5; i++){
    for (let j = 1; j <= ed; j++) {
        document.write(`${String(v).length >= 2 ? '' : '&nbsp;'}${v++} `);
    }
    document.write('<br/>')

    ed++;
}