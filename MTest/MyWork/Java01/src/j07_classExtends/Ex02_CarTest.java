package j07_classExtends;
// ** 상속 : extends
// => 기능을 확장해서 업그레이드 버젼 만듦
// => 기존(조상) 클래스의 맴버들(필드와 메소드)을 재사용 & 일부변경도 가능 

// ** 생성순서
// => JVM은 extends 키워드가 있으면 조상생성 후 후손 생성
// 이때 기본은 조상의 default 생성자를 실행하고,
// 특별히 후손 생성자에서 조상생성자_super(...)를 호출해 놓으면 그 생성자를 실행함
// => 상속을 허용하는 클래스는 default 생성자를 반드시 작성하는것이 바람직함

// ** 조상 : Super (Parent, Base) class
// => super.  : 조상의 인스턴스를 의미 (조상의 맴버에 접근 가능)
// => super()
// 	  조상의 생성자를 의미 (조상의 생성자에 접근 가능)
//    this() 처럼 생성자 메서드 내에서 첫줄에 위치해야함

// => 생성자메서드_super(), this() 호출은 생성자 내에서만 가능 

// ** 후손 : Sub ( Chiled, Derived [diráivd] ) class
// => super class 를 포함

class SportsCar extends Ex01_Car {
	int turbo;
	int speed;
	
	// 1)
	SportsCar() {
		// super(); 묵시적 호출, 넣어주지 않아도 컴파일러가 조상의 default 생성자를 의미하는 super()를 넣어줌
		System.out.println("SportsCar default 생성자");
	}
	// 2)
	SportsCar(int turbo) {
		this.turbo = turbo;
		System.out.println("SportsCar 초기화 생성자");
	}
	
	// 3)
	// => 조상의 멤버들도 모두 초기화 하는 생성자
	SportsCar(int turbo, int speed, int mileage, String color) {
		super(speed, mileage, color); // 조상 생성자 호출, 항상 첫줄에 위치
		this.turbo = turbo;
		System.out.println("SportsCar, Car 초기화 생성자");
	}
	
	// 4)
	// => Car 클래스에 생성자를 추가하지 않고,
	//	  super(speed, mileage) -> 없음(호출 불가능)
	//	  turbo, speed, mileage를 초기화 하는 생성자 추가
	//	  -> 조상의 speed, mileage에 매개변수 값을 전달
	SportsCar(int turbo, int speed, int mileage) {
		this.turbo = turbo;
		super.speed = speed;
		super.mileage = mileage;
		System.out.println("turbo, speed, mileage 초기화 생성자");
	}
	// => new 메소드
	public int powerUp(int turbo) {
		return this.turbo += turbo;
	}
	// 5)
	// => 조상과 동일한 (이름, 매개변수, return값)메소드
	// => 메소드 오버라이딩
	// => 조상에 정의된 메소드의 기능을 업그레이드하는 경우 주로 사용
	//	  조상에 정의된 기능 + 추가기능
	@Override
	public void speedUp() {
		super.speedUp();
		this.speed += 100; // 추가기능 SportsCar_speed
	}

	// @Override => 메소드 오버라이딩이 아닌 메소드 오버로드에 해당
	public void speedUp(int speed) { 
		this.speed += speed; // SportsCar_speed
		super.speed += speed; // Car_speed
		System.out.printf("speed=%d, this.speed=%d, super.speed=%d, COUNTRY=%s\n",
				speed, this.speed, super.speed, Ex01_Car.COUNTRY);
	}
	
	// => 조상과 동일한 이름의 메소드
	//    조상에도 있고 자식에도 있음
	// => 조상(super)/자식(this) 구별 필요 (멤버변수에도 동일하게 적용)
	@Override
	public String toString() {
		// => 조상의 toString 메소드 호출
		return super.toString() + "\nSportsCar [ turbo=" + turbo + " ]";
	}
	
	// 6) final Test
	// => 오버라이딩 금지
	// public void speedDown() { speed-=10; }
	// => 매개변수가 다르므로 오버로딩은 허용
	public void speedDown(int i) { speed-=i; }
	
}

public class Ex02_CarTest {

	public static void main(String[] args) {
		// 1) default 생성자 Test
		// => 조상의 멤버에 접근 가능함
		// => SportsCar 멤버 추가이전 / 이후 비교
		//	  이름이 같은 경우 현재(자식) 클래스에 정의된 멤버 우선 적용
		// => 생성자 추가 후 출력 순서 확인
		//	  조상생성자 → 자식생성자 실행
		SportsCar sc1 = new SportsCar();
		sc1.color = "Blue";
		System.out.println("sc1 => " + sc1); // 추가 이전 Car 출력
		System.out.println("color => " + sc1.color);
		
		// 2) 생성자 Test
		//    사용자 클래스에서 조상의 생성자를 선택할 수 없음 : 조상은 default 생성자 호출됨
		SportsCar sc2 = new SportsCar(100);
		System.out.println("생성자 Test sc2 => " + sc2);
		
		// 3) 조상 포함 모든 맴버변수를 초기화 하는 생성자
		SportsCar sc3 = new SportsCar(300, 100, 1000, "Red");
		System.out.println("생성자 Test sc3 => " + sc3);
		
		// 4) super 접근 Test
		SportsCar sc4 = new SportsCar(500, 500, 5000);
		System.out.println("생성자 Test sc4 => " + sc4);
		
		// 5) 멤버변수 Test
		// => 자식 클래스에 speed 추가하기전 출력(Car) / 추가 후 출력
		System.out.println("Test 5) speed1 => " + sc4.speed);
		// => speedUp 메소드 추가 전/후
		sc4.speedUp();
		System.out.println("Test 5) speed2 => " + sc4.speed);
		sc4.speedUp(123);
	}

}
