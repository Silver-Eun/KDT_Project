/*
< confirm > - 확인/취소 버튼이 있는 prompt
- 확인, 취소 버튼을 누를 때까지 prompt 창이 뜨고
  확인 버튼을 누르면 true를, 취소 버튼이나 Esc를 누르면 false를 반환.
형식 : confirm( message? : string ) : boolean
*/

'use strict';

const id = 'hsng12';
for (let inputId; ;) {
    inputId = prompt('아이디 입력');

    if (confirm('아이디가 정확합니까?')) {
        if (inputId === id) {
            alert('입력한 아이디가 일치합니다.');
            break;
        } else {
            alert('아이디가 일치하지 않습니다. 다시 입력해주세요.');
        }
    }
}

// close();


const pw = '1234'
for (let inputPW; ;){
    inputPW = prompt('비밀번호 입력');

    if (confirm('비밀번호가 정확합니까?')) {
        if (inputPW === pw) {
            alert('입력한 비밀번호가 일치합니다.');
            break;
        } else {
            alert('일치하지 않습니다. 다시 입력해주세요.');
        }
    }
}

const ipin = 'abc';

for (let inputIpin; ;){
    inputIpin = prompt('아이핀 입력');

    if (confirm('아이핀이 정확합니까?')) {
        if (inputIpin === ipin) {
            alert('아이핀이 일치합니다.');
            break;
        } else {
            alert('다시 입력해주세요.');
        }
    }
}