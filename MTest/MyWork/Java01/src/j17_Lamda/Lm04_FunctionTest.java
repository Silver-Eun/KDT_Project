package j17_Lamda;

import java.util.function.Function;

public class Lm04_FunctionTest {

	public static void main(String[] args) {
		// 1. String의 길이를 return 
		Function<String, Integer> f1 = t -> t.length();
		
		// 2. Double을 입력받아 Double return
		// => Double 입력받아 inch로, inch를 cm로 출력하기
		Function<Double, Double> cToi = d -> d*0.393701;
		Function<Double, Double> iToc = d -> d*2.54;
		
		// 실행
		System.out.println("실습1) function의 길이 => " + f1.apply("function"));
		System.out.println("실습1) 가나다라마의 길이 => " + f1.apply("가나다라마"));

		System.out.println("실습2) cToi, 123cm => " + cToi.apply(123.0) + " inch");
		System.out.println("실습2) cToi, 123cm => " + iToc.apply(123.0) + " cm");
	}

}
