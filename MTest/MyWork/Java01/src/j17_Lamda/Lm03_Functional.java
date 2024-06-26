package j17_Lamda;

// ** @FunctionalInterface Test
// => 이를 적용한 인터페이스는 한개의 추상메소드만을 선언할 수 있음
// => 그러나 static, default 선언이 붙은 메서드는 무관

//@FunctionalInterface
interface Value {
	int num(int a, int b);
	// String myString(int a, int b);
}

class Compute {
	public void inValue(Value v) {
		int result = v.num(5, 10);
		// => num 메소드의 처리내용은 구현이 안되어 있음
		// inValue 메소드 호출시 넣어주는
		// 인자(Value 인터페이스 구현체)에 의해 결정
		System.out.println("inValue, result => " + result);
	}
}

public class Lm03_Functional {

	public static void main(String[] args) {
		// 1. Lamda식 사용 X, 익명클래스 ( +연산으로 구현 )
		Compute cp = new Compute();
		System.out.println("1. Lamda식 사용 X, 익명클래스 ( +연산으로 구현 )");

		cp.inValue(new Value() {
			@Override
			public int num(int a, int b) {
				return a + b;
			}
		});

		// 2. 람다식 사용 O ( * 연산으로 구현 )
		// => Value Type의 매개변수를 람다식으로 정의
		System.out.println("2. 람다식 사용 O ( * 연산으로 구현 )");
		cp.inValue((a, b) -> { 
			System.out.printf("num : a = %d, b = %d\n", a, b);
			return a + b; });
		
		// 3. 생략형 Lamda식 ( - 연산으로 구현 )
		System.out.println("3. 생략형 Lamda식 ( - 연산으로 구현 )");
		cp.inValue((a, b) -> a - b);
	}

}
