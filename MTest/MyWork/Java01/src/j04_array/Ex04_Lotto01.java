package j04_array;

import java.util.Arrays;
import java.util.Random;

// ** Lotto 번호 생성기 만들기1
// => int를 6개 담을 수 있는 배열 생성 : lotto
// => Random으로 1 ~ 45 범위의 숫자를 생성해서 배열 초기화 하기
//    (추가: 단, 중복은 허용하지 않음)
// => 출력

public class Ex04_Lotto01 {

	public static void main(String[] args) {
		// 1) 배열정의
		int Lotto[] = new int[6];

		// 2) Random으로 숫자추출 & 배열에 담기
		// => Random, for 구문
		Random rn = new Random();
		
		for (int i = 0; i < Lotto.length; i++) {
			Lotto[i] = rn.nextInt(45)+1;
			
			// ** 중복확인
			// => 숫자추출 후, Lotto에 담기 전 확인
			//	  -> 임시변수 필요, 중복 존재하면 안담고, 존재 안하면 담음
			// => 숫자추출 후, Lotto에 담기 후
			//	  -> 중복이 존재하면 i값을 후진시켜 다시 담도록
			// ** 중복확인 방법
			// => 이미 Lotto 배열에 담겨있는 Data와 비교
			// 	  (그러므로 반복문 필요)
			
			for(int j = 0; j < i; j++) {
				if(Lotto[i] == Lotto[j]) {
					--i; 
					break; 
				}
			}
		}
		
		// 3) 출력
		System.out.println(Arrays.toString(Lotto));
		
		// 4) 최대값 & 최소값 출력하기
		int max = Lotto[0], min = Lotto[0];
		for(int i = 0; i < Lotto.length; i++) {
			if(max < Lotto[i]) {
				max = Lotto[i];
			} else if (min > Lotto[i]) {
				min = Lotto[i];
			}
		}
		System.out.println("max = " + max + ", min = " + min);
		
		// 5) 오름차순
		// => Ex05
	}

}
