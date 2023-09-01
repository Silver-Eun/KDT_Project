package j04_array;
//** Lotto 번호 생성기 만들기 2
//=> 찾기(Search) & 정렬(Sort)

// *** Random 클래스
// => java.util 에 있으므로 import 필요하고, new 선언후 사용가능함.
// => Random() : 호출시마다 현재시간을 이용한 종자값이 자동 설정됨 
//   Random(long seed) : 인자값으로 주어진 종자값이 설정됨 
// 종자값 : 난수 만드는 알고리즘에서 사용되는 값
//         ( 같으면 같은난수 얻음 )
//
// => Random().nextInt(큰수 - 작은수 + 1) + 작은수 
//    Random().nextInt() , Random().nextLong() , Random().nextBoolean()
//    Random().nextDouble() , Random().nextFloat()
import java.util.Arrays;
import java.util.Random;

public class Ex05_Lotto02_Sort {

	public static void main(String[] args) {
		// 1) 배열정의
		int Lotto[] = new int[6];

		// 2) Random으로 숫자추출 & 배열에 담기
		// => Random, for 구문
		Random rn = new Random(1);

		for (int i = 0; i < Lotto.length; i++) {
			Lotto[i] = rn.nextInt(45) + 1;
			// ** 중복확인
			// => 숫자추출 후, Lotto에 담기 전 확인
			// -> 임시변수 필요, 중복 존재하면 안담고, 존재 안하면 담음
			// => 숫자추출 후, Lotto에 담기 후
			// -> 중복이 존재하면 i값을 후진시켜 다시 담도록
			// ** 중복확인 방법
			// => 이미 Lotto 배열에 담겨있는 Data와 비교
			// (그러므로 반복문 필요)

			for (int j = 0; j < i; j++) {
				if (Lotto[i] == Lotto[j]) {
					--i;
					break;
				}
			}
		}

		// 3) 출력(정렬 전)
		System.out.println("정렬 전 => " + Arrays.toString(Lotto));

		// 4) 오름차순 정렬
		// => 순차정렬 (Sequence Sort)
		// => 정렬 알고리즘에서 가장 간단하고 기본이 되는 알고리즘으로
		// 배열의 처음과 끝을 탐색하면서 차순대로 정렬하는 가장 기초적인 정렬 알고리즘
		// ** 정렬 알고리즘 : 삽입(insert)정렬, 합병(Merge)정렬, 퀵(Quick)정렬...
		// => https://blog.naver.com/tepet/221690306235
		for (int i = 0; i < Lotto.length; i++) {
			for (int j = i + 1; j < Lotto.length; j++) {
				if (Lotto[i] > Lotto[j]) {
					// ** 내림차순 if(Lotto[i] > Lotto[j]) {
					int temp = Lotto[i];
					Lotto[i] = Lotto[j];
					Lotto[j] = temp;
				}
			}
		}
		System.out.println("정렬 후 => " + Arrays.toString(Lotto));

		// ** 배열 Wrapper Class
		// => Arrays의 주요 메서드 : equals(null, null), sort(null)

		// 5) myNumber 생성 후 비교하기
		// => 배열정의, Random 추출 후 중복확인 후 배열에 담기
		// => 정렬, equals 비교
		int myNumber[] = new int[6];

		Random mn = new Random(1);

		for (int i = 0; i < myNumber.length; i++) {
			myNumber[i] = mn.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (myNumber[i] == myNumber[j]) {
					--i;
					break;
				}
			}
		}

		Arrays.sort(myNumber);

		System.out.println("myNumber => " + Arrays.toString(myNumber));

		if (Arrays.equals(Lotto, myNumber)) {
			System.out.println("당첨");
		} else {
			System.out.println("꽝");
		}
		
	}

}
