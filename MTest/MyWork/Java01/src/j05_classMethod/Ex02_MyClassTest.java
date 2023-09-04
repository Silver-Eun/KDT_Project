package j05_classMethod;

class Bank {
	// ** 멤버변수
	// => 전역(Global) 변수
	//	  클래스내 모든 메소드에서 사용 사능
	//	  다른 클래스에서도 접근 가능
	public String account;
	public int money;
	public int age;
	
	public void addMoney(int myMoney) {
		
		// ** void 메소드의 return Test
		if (myMoney > 1000) {
			System.out.println("myMoney 값 이상으로 종료");
			return;
		}
		
		int money = 5000;
		// => 2. 위치 변경 후 money1 출력값 비교
		
		money += 100; // 전역변수 ( 위 2번 적용 전까지 )
		System.out.println("** addMoney money = " + money); // 전역 money
		// ** 지역(Local) 변수
		// => 메소드 내부에 정의된 변수, 인자
		// { } 내부에서만 적용가능
		// 클래스 외부에서도 접근 불가능
		// 전역변수와 동일한 이름의 지역변수를 정의하면 지역변수가 우선
		// { 단, 지역변수 선언 이후부터 } 
		money += money;
		int price = 10000;
		// int money = 5000; // 1. 지역변수 2. 위치를 메소드내 첫줄로 이동
		System.out.println("** addMoney money = " + money); // 지역 money
	}
	public void deleteMoney() {
		money -= 100;
	}
	public String toString() {
		return "[ account=" + account + ", money=" + money + ", age=" + age+" ]";
	}
}

public class Ex02_MyClassTest {

	public static void main(String[] args) {
		Bank myBank = new Bank();
		myBank.account = "abc";
		myBank.money = 1000000;
		myBank.age = 27;
		// myBank.addMoney();
		System.out.println("myBank : " + myBank);
		
		// 지역변수, void_return Test
		myBank.addMoney(1000);
		myBank.addMoney(2000);
		
		Bank yourBank = new Bank();
		yourBank.account = "cde";
		yourBank.money = 100000000;
		yourBank.age = 31;
		yourBank.deleteMoney();
		yourBank.deleteMoney();
		System.out.println("yourBank : " + yourBank);
		}

}
