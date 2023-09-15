package j13_generic;

import j07_classExtends.Ex01_Car;

// ** Generic Class Test 
// ** FruitBox 만들기
// => Apple, Banana 등 모든 과일을 담을수 있는 Generic FruitBox class를 만들기
//    단 과일들만 담을 수 있어야 함( 자율적으로 )
// 힌트 : Apple, Banana 등 각종 과일들이 class이고, 
//       이들은 과일(Fruit) 로 구분 될 수 있어야함
// => 실습
// -> 1) Fruit 만들기
// -> 2) 과일 클래스들 만들기(3개)
// -> 3) FruitBox 만들기
//       과일들담기_setter, 과일들출력메서드_fruitPrint()
// -> 4) main 완성하기
interface Fruiti { }
class Fruit {public String toString() { return "Fruit"; } }

class Apple extends Fruit implements Fruiti { public String toString() { return "Apple"; } }
class Banana extends Fruit implements Fruiti { public String toString() { return "Banana"; } }
class Orange extends Fruit implements Fruiti { public String toString() { return "Orange"; } }

// FruitBox
// => Apple, Banana 등 모든 과일을 담을수 있는 Generic FruitBox class
// => T : Type 제한 없음
class FruitBoxA<T> {
	private T[] arr;
	public void setArr(T[] arr) { this.arr = arr; }
	public T[] getArr() { return this.arr; }
	
	public void fruitPrint() {
		for (T a:arr) {
			System.out.println(a);
		}
	}
}

// => T : Fruit Type으로 제한 -> Fruit의 후손 클래스만 허용
class FruitBox<T extends Fruit> {
	private T[] arr;
	public void setArr(T[] arr) { this.arr = arr; }
	public T[] getArr() { return this.arr; }
	
	public void fruitPrint() {
		for (T a:arr) {
			System.out.println(a);
		}
	}
}

class FruitBoxi<T extends Fruiti> {
	private T[] arr;
	public void setArr(T[] arr) { this.arr = arr; }
	public T[] getArr() { return this.arr; }
	
	public void fruitPrint() {
		for (T a:arr) {
			System.out.println(a);
		}
	}
}

// => 

public class Ex03_FruitBox {

	public static void main(String[] args) {
		// 1) 종합 Set
		// => 모든 객체들을 다 담을 수 있음
		Object[] oarr = {new Apple(), new Banana(), new Orange()};
		FruitBoxA fb1 = new FruitBoxA();
		fb1.setArr(oarr);
		fb1.fruitPrint();
		
		// => Apple Box
		Apple[] a1 = {new Apple(), new Apple(), new Apple()};
		FruitBoxA<Apple> fb2 = new FruitBoxA<Apple>();
		fb2.setArr(a1);
		fb2.fruitPrint();

		// 2) Fruit Box
		Fruit[] f1 = {new Apple(), new Banana(), new Orange()};
		FruitBoxA<Fruit> fb3 = new FruitBoxA<Fruit>();
		fb3.setArr(f1);
		fb3.fruitPrint();

		Apple[] a2 = {new Apple(), new Apple(), new Apple()};
		FruitBoxA<Fruit> fb4 = new FruitBoxA<Fruit>();
		fb4.setArr(a1);
		fb4.fruitPrint();
		
		// 3) interface Test
		 FruitBoxi<Fruiti> fb5 = new FruitBoxi<Fruiti>();
	     Fruiti[] farri = { new Apple(), new Banana(), new Orange() };
	     fb5.setArr(farri);
	     //fb5.setArr(farr); // Fruit Type 배열 farr은 담을 수 없지만,  
	     fb5.setArr(a2);  // Fruiti를 구현한 Apple Type 배열은 허용됨.
	     fb5.fruitPrint();

	}

}
