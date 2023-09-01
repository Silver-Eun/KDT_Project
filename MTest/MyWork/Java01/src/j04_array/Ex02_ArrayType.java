package j04_array;

import java.util.Arrays;

public class Ex02_ArrayType {

	public static void main(String[] args) {
		// Type별로 배열을 정의하고 출력해본다
		// => 묵시적 정의, 출력은 eachFor 구문으로
		// => float, char, String, long
		// => data 개수는 5개
		// 1) float
		System.out.println("float");
		float[] a = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
		for(float s : a) {
			System.out.print(s + " ");
		}
		
		// 2) char
		System.out.println("\nchar");
		char[] b = {'가', '나', '다', '라', '마'};
		for(char s : b) {
			System.out.print(s + " ");
		}		
		
		// 3) String
		System.out.println("\nString");
		String[] c = {"서울", "1234", "용인", "성남", "4278"};
		for(String s : c) {
			System.out.print(s + " ");
		}
		
		// 4) long
		System.out.println("\nlong");
		long[] d = {1432432l, 42343l, 21123l, 43424l, 32434l};
		for(long s : d) {
			System.out.print(s + " ");
		}
		
		// ** 배열 지원하는 Wrapper Class : Arrays
		System.out.println("\nWrapper Class : Arrays");
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));
		
	}

}
