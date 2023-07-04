'use strict';

// 중첩루프 특징 : 외곽구조변수값이 항상 고정되어 있는 상태에서 안쪽구조변수값이 변하는 특성

for (let i = 1; i < 5; i++) {
    for (let j = 1; j < 5; j++) {
        console.log(`i = ${i} j = ${j}`)
    }
}