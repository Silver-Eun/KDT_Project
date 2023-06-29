'use strict';

/* if (조건식) {
    true;
} else {
    false;
} */

let score, grade;

score = +prompt('점수 : ');

if (score >= 90) {
    grade = 'A'
} else if (score >= 80) {
    grade = 'B'
} else if (score >= 70) {
    grade = 'C'
} else if (score >= 60) {
    grade = 'D'
} else {
    grade = 'F'
}

alert(`이번 학기 학점은 ${grade}`);

//======================
if (score >= 90 && grade == 'A') {
    console.log('장학금');
}