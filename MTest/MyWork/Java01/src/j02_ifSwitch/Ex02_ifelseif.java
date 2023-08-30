package j02_ifSwitch;

//import java.util.Scanner;

public class Ex02_ifelseif {

	public static void main(String[] args) {
		// ** 등급 처리
		// => score 90이상:A , 80이상:B, 70이상:C, 60이상:D, 아니면 "F" 출력
		// => 이상 / 이하 (포함)
		// => 초과 / 미만 (불포함)

		int score = 91;
		char grade = 'A';
		// => grade 확인
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		// => grade 출력
		System.out.printf("** score = %d, grade = %s\n", score, grade);
		
		// ** 비교1
		if (score >= 90) grade = 'A';
		if (score >= 80) grade = 'B';
		if (score >= 70) grade = 'C';
		if (score >= 60) grade = 'D';
		else grade = 'F';
		System.out.printf("** 비교1 : score = %d, grade = %s\n", score, grade);
		
		// ** 중점 if
		if(score >= 90) {
			if(score == 100) System.out.println("장학금");
			grade = 'A';
		} else {
			if(score >= 80) {
				grade = 'B';
			} else {
				if(score >= 70) {
					grade = 'C';
				} else {
					if(score >= 60)
						grade = 'D';
					else
						System.out.println("학사경고");
						grade = 'F';
				}
			}
		}
		System.out.printf("** 중첩 if : score = %d, grade = %s\n", score, grade);
		
		// ** switch 구문으로 변경해보기
	    switch (score/10) {
	    case 10:
	    case 9: grade = 'A'; break;
	    case 8: grade = 'B'; break;
	    case 7: grade = 'C'; break;
	    case 6: grade = 'D'; break;
	    default: grade = 'F'; break;
	    }
	    System.out.println(grade);
		
	}

}
