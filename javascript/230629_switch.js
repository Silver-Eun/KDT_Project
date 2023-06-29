// if : 연속적이면서 넓은 범위
// switch : 비연속적이거나 좁은 범위

/* 
switch (평가할 변수 or 상수) {
    case 선택값1:(변수, 상수(숫자, 문자열), 식)
    실행문;
    break;
    case 선택값2:
    실행문;
    break;
    case 선택값3:
    실행문;
    break;
    default:(생략가능)
    실행문;
    break;
}
*/

let rank;
let grade;

rank = +prompt('등수 : ');

switch (rank) {
    case 1:
        grade = 'A';
        break;
    case 2:
        grade = 'B';
        break;
    case 3:
        grade = 'C';
        break;
    default:
        grade = 'F';
        break;
}

switch (rank) {
    case 1:
    case 2:
        grade = 'A';
        break;
    case 3:
    case 4:
        grade = 'B';
        break;
    case 5:
    case 6:
        grade = 'C';
        break;
    default:
        grade = 'F';
        break;
}