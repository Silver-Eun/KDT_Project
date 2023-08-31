package j03_forWhile;
// ** 숫자 맞추기 게임
// => 1~10 범위에서 숫자 하나를 입력받아
// => Random 함수의 결과와 일치하면 금메달
// => 차이가 1 이면 은메달, 차이가 2면 동메달, 아니면 꽝
// => Math 클래스를 이용

// => 반복문 적용 : 당첨될 때까지

import java.util.Random;
import java.util.Scanner;

public class Ex04_RandomGame {

	public static void main(String[] args) {
		// 1) Random Number 구하기
		Random rn = new Random();
		int happyNumber = rn.nextInt(10) + 1; // 1 ~ 10

		// 2) myNumber 입력
		Scanner sc = new Scanner(System.in);
		int myNumber = 0;
		int abs = 0; // 차이값
		int count = 0;
		while (true) {
			// 2.1) myNumber 입력 받기
			System.out.printf("숫자를 입력하세요 => ", count++);
			myNumber = sc.nextInt();
			
			// 2.2) 확인
			// => 일치, 차이가 1 or 2 : 반복문 탈출
			// 아니면 계속 진행
			abs = Math.abs(happyNumber - myNumber);
			
			if(abs <= 2) break;
		}
		sc.close();

		// 3) 결과처리
		String medal = "꽝";
		switch(abs) {
		case 0:
			medal = "금메달"; break;
		case 1:
			medal = "은메달"; break;
		case 2:
			medal = "동메달"; break;
		default: medal = "꽝";
		}
		
		System.out.printf("medal = %s, 횟수 = %d", medal, count );
		
	}

}
