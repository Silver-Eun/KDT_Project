package j09_InnerClass;

interface MyInterface {
	void method1(); // 추상 메소드
	void method2(); // 추상 메소드
}

public class Ex06_Test {

	public static void main(String[] args) {
		MyInterface myint = new MyInterface() {
			@Override
			public void method1() {
				System.out.println("메소드1 생성");
			}
			@Override
			public void method2() {
				System.out.println("메소드2 생성");
			}
		};
		myint.method1();
		myint.method2();
	}

}
