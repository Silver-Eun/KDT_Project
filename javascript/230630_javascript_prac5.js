'use strict';

let n1, n2;

n1 = +prompt('정수1 :');
n2 = +prompt('정수2 :');

alert(`${n1}과(와) ${n2}의 차이는  ${(n1 > n2 ? n1 - n2 : n2 - n1)} 입니다.`);

if (confirm('창을 닫을 까요?')) {
    close();
}