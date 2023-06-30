'use strict';

let n1, n2

n1 = +prompt('첫번째 정수 입력 : ');
n2 = +prompt('두번째 정수 입력 : ');

if (n1 === n2) {
    alert('두 수는 같음');
} else {
    alert('큰 수는 ' + (n1 > n2 ? n1 : n2));
    //alert(`큰 수는 ${(n1 > n2 ? n1 : n2)}`);
}