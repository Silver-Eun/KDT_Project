package j02_ifSwitch;

import java.util.Random;
import java.util.Scanner;

//** 숫자 맞추기 게임
//=> 1~10 범위에서 숫자 하나를 입력받아
//=> Random 함수의 결과와 일치하면 금메달
//=> 차이가 1 이면 은메달, 차이가 2면 동메달, 아니면 꽝
//=> Math 클래스를 이용하세요 ~~

public class Ex05_RandomGame {

	public static void main(String[] args) {
		// 1) Random Number 구하기
		Random rn = new Random();
		
		int happyNumber = rn.nextInt(10)+1; // 1 ~ 10
		
		// 2) myNumber 입력
		int myNumber = 0;
				
		// 3) 결과처리
		// => 차이 : happyNumber - myNumber의 절대값
		Scanner sc = new Scanner(System.in);
		// System.out.println("정답 : " + happyNumber);
		System.out.printf("숫자를 입력하세요 => ");
		myNumber = sc.nextInt();

		switch(Math.abs(happyNumber - myNumber)) {
		case 0:
			System.out.println("금메달"); break;
		case 1:
			System.out.println("은메달"); break;
		case 2:
			System.out.println("동메달"); break;
		default: System.out.println("꽝");
		}
		
		sc.close();
		 
	}

}
