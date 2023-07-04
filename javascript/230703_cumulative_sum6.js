'use strict';

// 최초현재거듭제근곱 = 2
// 최초과거거듭제근곱 = 1
// 현재거듭제근곱 = 과거거듭제곤급 * 밑수

// 지수, 밑수
let upN, downN, num = 1;

while (1) {
    downN = +prompt('밑수');
    if (downN >= 0) {
        upN = +prompt('지수');
        if (upN >= 0) {
            break;
        }
    }
    alert(`음수가 입력되어있습니다. 재입력 하세요.`);
}

for (let i = 0; i < upN; i++) {
    num *= downN;
}

alert(`${downN}의 ${upN}승은 ${num}입니다.`);

// downN = +prompt('밑수');
// while (downN < 0) {
//     alert(`음수가 입력되어있습니다. 재입력 하세요.`);
//     downN = +prompt('밑수');
// }

// upN = +prompt('지수');
// while (upN < 0) {
//     alert(`음수가 입력되어있습니다. 재입력 하세요.`);
//     upN = +prompt('지수');
// }

/* ----------------------------- */
/* 
let upN, downN, num = 1;

for (; ;) {
    downN = +prompt('밑수');
    if (downN >= 0) {
        upN = +prompt('지수');
        if (upN >= 0) break;
    }
    alert(`음수가 입력되어있습니다. 재입력 하세요.`);
}

for (let i = 0; i < upN; i++) {
    num *= downN;
}

alert(`${downN}의 ${upN}승은 ${num}입니다.`);
*/