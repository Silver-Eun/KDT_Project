package j01_basic;
//** Type Casting(형변환)
//1. 자동 (프로모션 promotion, 확대 형변환)
// => 큰자료형에 작은자료형을 대입하면 : 자동으로 이루어짐

//2. 강제 (디모션 demotion, 축소 형변환)
// => 작은자료형에 큰자료형을 대입 : 자동으로 이루어지지않음
//=> 자료의 Type이 다른경우
//=> 명시적 형변환

public class Ex04_Casting {

	public static void main(String[] args) {
		// 1. 자동 (프로모션 promotion, 확대 형변환)
		double d = 123.456; // 8byte
		int i = 123456; // 4byte
		d = i; // 프로모션 promotion
		System.out.printf("** 프로모션 promotion : d = %f,  i = %d\n", d, i);		
		// i = d; -> type mismatch
		
		// 2. 강제 (디모션 demotion, 축소 형변환)
		i = (int)d;
		System.out.printf("** 디모션 demotion1 : i = %d\n", i);
		
		// => 같은크기 다른Type (int , float)
		float f = 456.789f;
		int n = 100;
		// n = f; -> 오류, f = n; -> 허용(promotion 적용)
		
		n = (int)f;
		System.out.printf("** 디모션 demotion2 : n = %d, f = %f\n", n, f);
		
		// => 정수형 연산
		// => 4byte 이하 type의 정수형 연산의 경우 무조건 그 결과는 int(4byte)로 처리
		short s1 = 10, s2 = 20, s3 = 0;
		// s3 = s1 + s2; -> type mismatch(s1 + s2의 결과는 int이기 때문)
		
		s3 = (short)(s1 + s2);
		
		// => char / int
		char c = 'C'; // 2byte
		System.out.printf("** 디모션 char1 : c = %s, c의 코드값 = %d\n", c, (int)c);
		n = c + 10; // 지동형 변환으로 산술연산 적용
		System.out.printf("** 디모션 char2 : n = %d, n의 케릭터값 = %s\n", n, (char)n);
		
		// => 교재, 연습문제 3장 1번
		long l = 1000l;
		float ff = 1;
		// => float 4byte, long 8byte
		//	  float의 표현 범위가 크기 때문에 자동형변환이 됨
	}

}
