package j11_APITest;
// ** Person
// => 주민등록번호, 이름을 전달받으면
// => 주민등록번호를 이용해서, age, 성별을 set 하고
// => info 출력하기 

// => 맴버필드(private) : idNo(String), name(String), age(int), gender(char)
// => 생성자 2개
//    * default
//    * 주민등록번호,이름을 매개변수로 전달받아 초기화 
//    -> 나이 계산, 성별도 찾아서 set
// => setter/getter
//     이름만 수정 가능, 
//    모든필드를 사용가능 (그러나 주민번호는 뒷자리는 * 로표시)
// => infoPrint()
// => toString은 오버라이딩(선택)

// ** info
// 이름 : 000
// 번호 : 090909-*******
// 나이 : 20세
// 성별 : "남" 또는 "여"

class Person {
	private String idNo;
	private String name;
	private int age;
	private char gender;
	
	Person() {}
	Person(String name, String idNo) {
		this.idNo = idNo;
		this.name = name;
		setAge(idNo);
		setGender(idNo);
	}
	
	public void setName(String name) { this.name = name; }
	
	public String getIdNo() { return idNo; }
	public String getName() { return name; }
	public int getAge() { return age; }
	public char getGender() { 
		if(gender == 'M') return '남';
		else return '여';
	}
	
	public void setAge(String idNo) {
		int a = Integer.parseInt(idNo.substring(0,2));
		if (a < 24 ) {			
			this.age = (2023 - a + 1);
		}
		else if (a > 24 && a < 100 ) {
			this.age = (2023 - (1900 + a) + 1);
		}

	}
	public void setGender(String idNo) {
		String idno = idNo.trim();
		char gen = idno.charAt(7);
		if(gen == '1' || gen == '3') {
			this.gender = 'M';
		}
		else if(gen == '2' || gen == '4') {
			this.gender = 'F';
		}
	}
	
	void infoPrint() {
		System.out.println("이름 : " + name);
		System.out.println("번호 : " + idNo.substring(0,6) + " - *******");
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);
	}
}

// PersonTest
// => 5명 생성 후 배열에 넣고
//    나이순으로 출력하기
// => 출력은 infoPrint() 이용

public class Ex07_PersonTest {

	public static void main(String[] args) {
		Person a = new Person("Kim", "971216-1111111");
		Person b = new Person("Lee", "781004-2222222");
		Person c = new Person("Choi", "860321-1111111");
		Person d = new Person("Park", "030719-2222222");
		Person e = new Person("Eun", "090910-1111111");
//		a.infoPrint();
//		b.infoPrint();
//		c.infoPrint();
//		d.infoPrint();
//		e.infoPrint();
		
		Person arr[] = {a, b, c, d, e};
	}

}
