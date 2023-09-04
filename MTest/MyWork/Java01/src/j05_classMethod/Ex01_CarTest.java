package j05_classMethod;
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
	// => 클래스의 전역변수
	// 	  클래스내에 있는 모든 메서드에서 사용가능
	public int speed;
	public int mileage;
	public String color;
	
	// ** 맴버메서드 (Method, function, procedure)
	// => 동작 또는 기능을 구현
	public void speedUp() {
		speed += 10;
	}
	public void speedDown() {
		speed -= 10;
	}
	// => String (return Type) : 문자열을 반환(return) -> 메서드 처리 결과로 문자열을 제공
	// => toString (메서드명) : 객체의 속성(맴버필드, 맴버변수)의 값을 문자로 제공하는 역할에 주로 사용됨   
	public String toString() {
		return "[ speed=" + speed + ", mileage=" + mileage + ", color=" + color+" ]";
	}
	// ** toString 메서드
    // => 출력문에서 인스턴스명만 사용했을 때 자동호출됨
    // => Object에 정의됨 ( 객체의 주소를 String Type으로 return )
    // => 대부분의 클래스에서 속성 출력용도로 재정의하여 사용함.
} // Car

//=> API 라이브러리의 클래스명 비추
//class System {
// System.out 이 오류 뜨는 것을 확인
//} 

public class Ex01_CarTest {

	public static void main(String[] args) {
		System.out.println("** Car class test");
		// ** 객체사용
	    // => 생성-> 사용 -> 소멸
	    // => 생성: "인스턴스화 한다" 또는 "인스턴스를 생성한다" 라고 함
		
		Car myCar = new Car();
		myCar.color = "Gold";
		myCar.mileage = 1000;
		myCar.speed = 500;
		myCar.speedUp();
		System.out.println("myCar1 toString => " + myCar.toString());
		System.out.println("myCar2 toString => " + myCar);
		
		// ** 소멸 : 메모리청소
        // => 더이상 사용되지않는 값들은 자동제거해줌
	    // => Garbage Collector (쓰레기 수집기)
	    // => 정해진 알고리즘에 의해 작동됨 ( 일정시간동안 또는 더이상 참조되지않는 등등 )   
	    // => 참조형 변수에 null 값을 주면 소멸 (더이상 참조되지않음)
		myCar = null; // null -> 값이 없음
		// myCar.color; -> 따라서 접근 불가 : 컴파일 오류
		// myCar.speedDown(); -> 실행오류 : java.lang.NullPointerException
		
		Car mCar = new Car();
		mCar.color = "White";
		mCar.mileage = 1200;
		mCar.speed = 400;
		System.out.println("mCar1 toString => " + mCar.toString());
		System.out.println("mCar2 toString => " + mCar);

		Car rCar = mCar; // mCar의 주소값이 전달
		System.out.println("rCar => " + rCar);
		
		Car dCar = new Car();
		dCar.color = "Red";
		dCar.mileage = 1150;
		dCar.speed = 450;
		System.out.println("dCar1 toString => " + dCar.toString());
		System.out.println("dCar2 toString => " + dCar);
	} // main

} // class
