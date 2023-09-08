package j08_AbsInterface;
// ** interface
// => 상수, 추상메서드
// => static, default 메서드 (구현부가 있는 메서드, Java8부터 추가됨)

interface Animali {
	void breath();
	void sound();
	void special();
}

class Cati implements Animali {
	@Override
	public void breath() { System.out.println("고양이는 숨을 쉰다"); }
	
	@Override
	public void sound() { System.out.println("고양이는 야옹 야옹 운다"); }
	
	@Override
	public void special() { System.out.println("special : 고양이 eyeColor는 멋지다"); }
	
	void eyeColor() { System.out.println("고양이 eyeColor는 멋지다"); }
}

class Dogi implements Animali {
	@Override
	public void breath() { System.out.println("강아지는 숨을 쉰다"); }
	
	@Override
	public void sound() { System.out.println("강아지는 멍멍 운다"); }
	
	@Override
	public void special() { System.out.println("special : 강아지 eyeColor는 멋지다"); }
}

class Eaglei implements Animali {
	@Override
	public void breath() { System.out.println("독수리는 숨을 쉰다"); }
	
	@Override
	public void sound() { System.out.println("독수리는 수리수리 운다"); }
	
	@Override
	public void special() { System.out.println("special : 훨훨 높이 난다"); }
}

public class Ex02_InterAnimal {

	public static void main(String[] args) {
		// 1) 생성
	    // => 직접생성은 불가능
	    // => 인스턴스의 Type 으로는 정의가능, 구현클래스를 통해 생성됨
	    // => 그러나 사용범위는 interface에 정의된 만큼만
		Animali c1 = new Cati();
		c1.breath();
		c1.sound();
		c1.special();
		
		Cati c2 = new Cati();
		c2.breath();
		c2.sound();
		c2.special();
		
		// 2) 다형성 적용
		Animali animal = new Dogi(); // Cati() Eaglei()
		animal.breath();
		animal.sound();
		animal.special();
		
		// 3) 메소드 호출
		animalUse(c1);
		animalUse(c2);
		animalUse(animal);
		animalUse(new Eaglei());
		
		// 4) 연산자 instanceof 적용
		Bear bear = new Bear();
		if(bear instanceof Animali) {
			System.out.println("Bear는 animali 인스턴스입니다.");
		} else {
			System.out.println("Bear는 animali 인스턴스가 아닙니다.");			
		}
	}
	public static void animalUse(Animali animal) {
		animal.breath();
		animal.sound();
		animal.special();
	}

}
