package j07_classExtends;
/*
// 1대 : Animal
class Animal {
	public boolean breath;
	public int leg = 4;
	
	Animal() {}
	Animal(boolean breath, int leg) {
		this.breath = breath;
		this.leg = leg;
	}
}

// 2대 : Mammal
class Mammal extends Animal {
	String howling;
	String run;
	
	Mammal() {}
	Mammal(boolean breath, int leg, String howling, String run) {
		super(breath, leg);
		this.howling = howling;
		this.run = run;
	}
}

// 3대 : Wild, Pet
class Wild extends Mammal {
	
	String location = "동물원";
	
	Wild() {}
	Wild(boolean breath, int leg, String howling, String run) {
		super.breath = breath;
		super.leg = leg;
		super.howling = howling;
		super.run = run;
	}
	
	public String toString() {
		return "[ breath=" + breath + ", leg=" + leg + ", howling=" + howling
				+ ", run=" + run + " ]";
	}
}
class Pet extends Mammal {
	
	boolean vaccine;
	
	Pet() {}
	Pet(boolean breath, int leg, String howling, String run, boolean vaccine) {
		super.breath = breath;
		super.leg = leg;
		super.howling = howling;
		super.run = run;
		this.vaccine = vaccine;
	}
	
	public String toString() {
		return "[ breath=" + breath + ", leg=" + leg + ", howling=" + howling
				+ ", run=" + run + ", vaccine=" + vaccine + " ]";
	}
}

public class Ex03_Animal {

	public static void main(String[] args) {
		Wild lion = new Wild(true, 4, "어흥", "빠름");
		System.out.println("lion => " + lion);
		Wild tiger = new Wild(true, 4, "어흥", "빠름");
		System.out.println("tiger => " + tiger);
		
		Pet dog = new Pet(true, 4, "멍멍", "빠름", true);
		System.out.println("dog => " + dog);
		Pet cat = new Pet(true, 4, "야옹", "빠름", true);
		System.out.println("cat => " + cat);
	}

}
*/
