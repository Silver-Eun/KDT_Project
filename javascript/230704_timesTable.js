'use strict';

out:
for (let i = 1; i <= 9; i++) {
    // for : 증감식 부분으로 점핑
    // while, do-while : 조건식 부분으로 점핑
    // if (i >= 6) continue;

    
    for (let j = 1, result; j <= 9; j++) {
        if (j >= 6) break out; 
        result = i * j;
        
        document.write(`${i} x ${j} = ${result/10 >= 1 ? '' : '&nbsp;'}${result} `);
        // document.write(`${i} x ${j} = ${String(result).length >= 2 ? '' : '&nbsp;'}${result} `);
    }
    document.write(`<br/>`);
}

// 전역 변수
// - 해당 파일에서 변수 선언부터 끝날 때까지 적용
// 지역 변수
// - 해당 블럭 내에서만 적용, 블럭이 끝나면 소멸