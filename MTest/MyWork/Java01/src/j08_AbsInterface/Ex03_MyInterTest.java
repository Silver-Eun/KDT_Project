package j08_AbsInterface;
class MyChild1 implements Ex03_MyInterface {
	public MyChild1() { System.out.println("MyChild1 default 생성자");	}
	
	@Override
	public String getName() { return NAME; }	
	@Override
	public int getNum() { return 0;	}
	
	void Child1() { System.out.println("MyChild1 child1() 메소드"); }
}

class MyChild2 implements Ex03_MyInterface {
	String name = "kim";
	int num;
	
	public MyChild2() { System.out.println("MyChild2 default 생성자");	}
	
	@Override
	public String getName() { return NAME; }	
	@Override
	public int getNum() { return 0;	}
	
	void Child2() { System.out.println("MyChild2 child2() 메소드"); }
}

public class Ex03_MyInterTest {

	public static void main(String[] args) {
		Ex03_MyInterface ch1 = new MyChild1();
		System.out.println("main ch1.getName() => " + ch1.getName());
		System.out.println("main ch1.getNum() => " + ch1.getNum());
		ch1.getName();
		ch1.getNum();
		// ch1.child1(); 인터페이스에 정의되지않은 멤버는 접근불가
		
		Ex03_MyInterface ch2 = new MyChild2();
		System.out.println("main ch2.getName() => " + ch2.getName());
		System.out.println("main ch2.getNum() => " + ch2.getNum());
		ch2.getName();
		ch2.getNum();
		// ch2.child2(); 인터페이스에 정의되지않은 멤버는 접근불가
		
		// => 정리
		// MyChild1, MyChild2는 서로 무관하지만 interface로 인해 같은 Type으로 사용 가능
		// 다형성 적용 가능(클래스 교체 가능)		
		ch2 = ch1;
		System.out.println("main ch2.getName() => " + ch2.getName());
		System.out.println("main ch2.getNum() => " + ch2.getNum());
		
		// 비교
		MyChild1 mch1 = new MyChild1();
		MyChild2 mch2 = new MyChild2();
		// mch2 = mch1; 서로 다른 Type이므로 오류
		
	}

}