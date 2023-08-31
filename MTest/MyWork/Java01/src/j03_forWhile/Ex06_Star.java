package j03_forWhile;

public class Ex06_Star {

	public static void main(String[] args) {
		// 1) 반삼각형
		// => * 을 1개 부터 시작해서 갯수를 늘려가면서 9 line 출력 
		// => 각 행별로 행번호 갯수만큼 출력하기
		System.out.println("** 1) 반삼각형 **");
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		// 2) 피라미드(삼각형)
		// => 5행9열(마지막행, 각 line*2-1)
		System.out.println("\n** 2) 피라미드(삼각형) **");
//		for(int i = 0; i < 5; i++) {
//			for(int j = 0; j <= 4-i; j++) {
//				System.out.print(" ");
//			}
//			for(int j = 0; j < i*2+1; j++) {	
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
		
		int line = 5;
		for(int i = 1; i <= line; i++) {
			// => 반복문1 : space
			for(int j = 1; j <= line - i; j++) {
				System.out.print(" ");
			}
			// => 반복문2 : *
			for(int j = 1; j <= (i*2-1); j++) {
				System.out.print("★");
			}
			System.out.println("");			
		}
		
		// 3) 다이아몬드
		System.out.println("\n** 3) 다이아몬드 **");
		// => 상부출력
		line = 5;
		for(int i = 1; i <= line; i++) {
			// => 반복문1 : space
			for(int j = 1; j <= line - i; j++) {
				System.out.print(" ");
			}
			// => 반복문2 : *
			for(int j = 1; j <= (i*2 - 1); j++) {
				System.out.print("★");
			}
			System.out.println("");			
		}
		// => 하부출력
	    // => 총 그리는 line 갯수(위의 line-1=4) ~ 1까지 감소
		for(int i = line - 1; i >= 1; i--) {
			// => 반복문1 : space
			for(int j = 1; j <= line - i; j++) {
				System.out.print(" ");
			}
			// => 반복문2 : *
			for(int j = 1; j <= (i*2 - 1); j++) {
				System.out.print("★");
			}
			System.out.println("");			
		}
		
		// 4) 모래시계
		System.out.println("\n** 4) 모래시계 **");
		// => 상부출력
		for(int i = line - 1; i >= 1; i--) {
			// => 반복문1 : space
			for(int j = 1; j <= line - i; j++) {
				System.out.print(" ");
			}
			// => 반복문2 : *
			for(int j = 1; j <= (i*2 - 1); j++) {
				System.out.print("★");
			}
			System.out.println("");			
		}
		// => 하부출력
		// => 총 그리는 line 갯수(위의 line-1=4) ~ 1까지 감소
		line = 5;
		for(int i = 1; i <= line; i++) {
			// => 반복문1 : space
			for(int j = 1; j <= line - i; j++) {
				System.out.print(" ");
			}
			// => 반복문2 : *
			for(int j = 1; j <= (i*2 - 1); j++) {
				System.out.print("★");
			}
			System.out.println("");			
		}
		
	}

}
