package j05_classMethod;

import java.util.Arrays;
import java.util.Random;

public class Ex10_CallByRefLotto {
	
	// package Test용 변수선언
	int ddd = 100; // default
	public int iii = 200;
	public static int sss = 300;

	public static void main(String[] args) {
		int Lotto[] = new int[6];

		Random rn = new Random(1);

		for (int i = 0; i < Lotto.length; i++) {
			Lotto[i] = rn.nextInt(45) + 1;
			
			for (int j = 0; j < i; j++) {
				if (Lotto[i] == Lotto[j]) {
					--i;
					break;
				}
			}
		}

		System.out.println("정렬 전 => " + Arrays.toString(Lotto));

		// 오름차순 정렬
		// => 순차정렬 (Sequence Sort)메소드 만들기
		// => static
		lottoSort(Lotto, 'A');
		
		System.out.println("정렬 후 => " + Arrays.toString(Lotto));

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
	// ** CallByReference(매개변수 참조자료형, 주소전달)
	// => 배열
	// => 매개변수(배열, char_Asccending/Descending)
	// => 전달된 배열을 오름차순 또는 내림차순으로 정렬
	public static void lottoSort(int[] arr, char c) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ( (c=='A' && arr[i]>arr[j]) || (c=='D' && arr[i]<arr[j]) ) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
