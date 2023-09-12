package j08_AbsInterface;

class Car {
	String color;
	int door;
	
	void drive() { // 운전하는 기능
		System.out.println("drive");
	}

	void stop() { // 멈추는 기능
		System.out.println("stop");
	}
}

class FireEngine extends Car { // 소방차
	void water() { // 물을 뿌리는 기능
		System.out.println("water");
	}
}

public class Ex7_7 {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = new FireEngine();
		
		fe.water();
		car = fe; // car = (Car)fe;에서 형변환 생략
		// car.water();
		fe2 = (FireEngine)car;
		fe2.water();
	}

}
