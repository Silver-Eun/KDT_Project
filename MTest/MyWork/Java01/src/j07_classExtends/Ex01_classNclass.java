package j07_classExtends;
// ** 클래스와 클래스 간의 관계
// 1) 집합(has-a): Student와 Car
// 2) 사용(use)  : Ex04_classNclass와 Car
// 3) 상속(is-a) : Person, Student

public class Ex01_classNclass {
	
	static Ex01_Car car = new Ex01_Car(100, 200, "Yellow");
	
	public static void myCar(Ex01_Car car) {
		car.speedDown();
		System.out.println("2) 사용(use) 관계 : myCar_speed => " + car.speed);
	}

	public static void main(String[] args) {
		// 1) 집합(has-a)
		// => Ex01_classNclass 클래스와 Ex01_Car 클래스 관계
		System.out.println("1) 집합(has-a) => " + car);
		
		// => Student와 Car 클래스의 관계
		Ex01_Student s1 = new Ex01_Student("0001", "Kim", 99);
		System.out.println("main student => " + s1);
		System.out.println("main car_color => " + s1.car.color);
		System.out.println("main myCar_color => " + Ex01_Student.myCar.color.toUpperCase());
		
		// 2) 사용(use)
		// => Ex04_classNclass 클래스가 메소드 인자의 형식으로 Ex01_Car를 사용한 경우
		myCar(car);		
	}

}
