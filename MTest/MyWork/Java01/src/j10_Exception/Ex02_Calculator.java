package j10_Exception;
// ** 실습
// => 두개의 정수를 입력 받아 4칙연산(+,-,*,/) 결과 출력하기
// => 입력 정수는 1 ~ 99 까지 허용
// => nextLine()으로 입력 받기 -> try ~ catch 적용하기
// 1) 범위를 벗어난 값를 입력하면 정상값 입력할 때까지 반복
// 2) 반복분 이용해서 종료하고 싶을 때까지 Test 하기

import java.util.Scanner;

// ** Scanner 사용시 주의 사항
// => nextInt(), nextLine() 사용시 주의
// nextInt()는 개행문자 (\n) 가 뒤에 붙고, 숫자만 받아 처리
// 그래서 nextInt()만 계속되면 문제가 없는데,
// 뒤이어서 nextLine()이 오면 앞 nextInt()의 
// 남겨진 \n을 한줄로 인식 받아 버린다.

public class Ex02_Calculator {

	public static void main(String[] args) {
		// 1. scanner 인스턴스, 변수 정의
		Scanner sc = new Scanner(System.in);

		// 2. 반복문, try~ catch 적용
		// => 두개의 정수를 입력 받기
		// => 입력 받은 정수 범위 확인 ( 1 ~ 99 )
		// Yes : 4칙연산(+,-,*,/) 결과 출력하고 종료
		// No : 다시 입력받기 반복
//		while (true) {
//			try {
//				System.out.print("정수를 입력하세요 => ");
//				int a = Integer.parseInt(sc.nextLine());
//				System.out.print("정수를 입력하세요 => ");
//				int b = Integer.parseInt(sc.nextLine());
//
//				if (0 < a && a < 100 && 0 < b && b < 100) {
//					System.out.println(a + b);
//					System.out.println(a - b);
//					System.out.println(a * b);
//					System.out.println((float) (a / b));
//					break;
//				} else
//					System.out.println("다시 입력하세요");
//			} catch (Exception e) {
//				System.out.println("다시 입력하세요");
//			}
//		}
		while (true) {
			try {
				System.out.print("숫자1을 입력하세요 => ");
				int a = Integer.parseInt(sc.nextLine());
				// => 문자입력시: NumberFormatException
				// i = sc.nextInt(); 
				// => InputMismatchException 발생
				//    주의 -> 입력값중 숫자만 가져가고 남아있는 enter_Key 값 때문에 무한반복됨
				if (a < 1 || a > 99) {
					System.out.println("숫자1이 범위(1~99)를 벗어납니다.");
					continue;
				}
				System.out.print("숫자2을 입력하세요 => ");
				int b = Integer.parseInt(sc.nextLine());
				if (b < 1 || b > 99) {
					System.out.println("숫자2가 범위(1~99)를 벗어납니다.");
					continue;
				}

				System.out.println("Add => " + (a + b));
				System.out.println("Min => " + (a - b));
				System.out.println("Mul => " + (a * b));
				System.out.println("Div => " + (a / b));
				System.out.println("** 종료하시겠습니까? (Y,y : 종료) =>");
				// => 대/소문자 모두가능하도록
				if (sc.nextLine().toUpperCase().equals("Y")) {
					System.out.println("** Program 종료 **");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("** NumberFormatException => " + e.toString());
				System.out.println("** 정확하게 숫자만 입력하세요 **");
			} catch (Exception e) {
				System.out.println("** Exception => " + e.toString());
			}

		}

	}

}
