'use strict';

let line; // 줄수
let nCnt; // 가장 큰 수

line = +prompt(`line 수`);
nCnt = String(line * line).length;

for (let i = 1, v = 1; i <= line; i++) {
    for (let j = 1; j <= i + (line - 1); j++) {
        if (j < (line + 1) - i) {
            // 열 공백
            for (let i = 1; i <= nCnt + 1; i++) {
                document.write(`&nbsp;`);
            }
        } else {
            // 숫자 옆 공백
            for (let i = 0; i < nCnt - String(v).length; i++) {
                document.write(`&nbsp;`);
            }
            document.write(`${v++} `);
        }
    }
    document.write('<br/>')
}