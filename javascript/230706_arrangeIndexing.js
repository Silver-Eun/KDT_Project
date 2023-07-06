'use strict';

let str = '@ Javascript &';

// 문자열에 대한 배열 인덱싱 제공.
for (let i = 0; i < str.length; i++) {
    console.log(str[i]);
}
console.log('--------');

// 문자열 자체에 대한 배열 인덱싱도 가능.
console.log('@ Javascript &'[0]);
console.log('@ Javascript &'[str.length - 1]);