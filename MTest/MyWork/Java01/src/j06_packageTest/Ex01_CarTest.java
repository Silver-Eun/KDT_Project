package j06_packageTest;
// ** 클래스에 포함 가능한것 (맴버)
// => 속성(변수, 필드_Field, Column), 기능.동작(메서드)
// => 맴버변수(전역변수), 맴버메서드
// => 맴버메서드 종류 (역할이 정해져있는 메서드들)
// - main, 생성자(Constructor), toString, setter, getter

// ** 클래스명                                                                              
// => 대문자로 시작, 예약어 사용불가, API 라이브러리의 클래스명 비추
// => 클래스는 객체의 설계도

// ** 객체의 주기 (LifeCycle)
// => 생성 -> 사용 -> 소멸 (in Memory, RAM)
// => 클래스(in HDD) -> 생성(in Memory) -> 객체화 (인스턴스 생성)
// -> 사용 -> 소멸(Memory 반납)

// ** 클래스, 객체, 인스턴스(instance : 사례, 경우)
// 클래스와 인스턴스는 설계도와 제품이라고 할 수 있다
// 그럼 객체는 클래스일까 인스턴스일까?
// Java 프로그래밍에서는 설계도인 클래스가
// 메모리상의 구체적인 실체인 인스턴스가 되었을때 객체라고 부른다

// 그러므로 클래스와 인스턴스는 구별되고, 클래스와 객체도 구별되지만,
// 객체와 인스턴스는 구분없이 포괄적으로 객체라는 말을 쓰기도 한다.

class Car {
	// ** 맴버변수, 필드(field) : 속성
	public int speed;
	public int mileage;
	public String color = "Yellow";
	
	// package Test용 변수선언
	public static int ddd = 100;
			
	// ** 맴버메서드 (Method, function, procedure)
	public void speedUp() { speed += 10; }
	public void speedDown() { speed -= 10; }
	
	public String toString() {
		return "[ speed=" + speed + ", mileage=" + mileage + ", color=" + color+" ]";
	}
	
} 

public class Ex01_CarTest {

	public static void main(String[] args) {
		
	} // main

} // class
