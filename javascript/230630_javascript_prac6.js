let username, score1, score2, score3, avg, rank;

username = prompt('이름은 : ');
score1 = +prompt('국어 점수 :');
score2 = +prompt('영어 점수 :');
score3 = +prompt('수학 점수 :');

avg = (score1 + score2 + score3) / 3;

if (avg >= 90) {
    rank = 'A'
} else if (avg >= 80) {
    rank = 'B'
} else if (avg >= 70) {
    rank = 'C'
} else {
    rank = 'F'
}

alert(`<성적>\n 학생명 : ${username}, 학점 : ${rank}, 평균 : ${avg}`)