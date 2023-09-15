package j11_APITest;

// import java.util.Calendar;

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
//     이름만 수정(Update) 가능, 모든필드를 사용(read) 가능
//     (그러나 주민번호는 뒷자리는 *로 표시)
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
         this.age = (2023 - (2000+ a) + 1);
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

//class Person {
//	// 1) 맴버필드(private)
//	private String idNo;
//	private String name;
//	private int age;
//	private char gender;
//	
//	// 2) 생성자 2개
//	// => default
//	public Person() { System.out.println("** Person Default 생성자 **"); }
//	
//	// => 초기화 생성자 
//	public Person(String idNo, String name) { 
//		System.out.println("** Person 초기화 생성자 **"); 
//		this.idNo=idNo;
//		this.name=name;
//		
//		// ** idNo
//		// => 6자리-7자리 총14 자리 -> 900909-1022333 , 010101-3011222
//		
//		// ** 성별
//		// => idNo 의 "-" 다음자리의 값이 1,3:'남' 또는 2,4:'여'
//		// 1) idNo 의 "-" 다음자리의 값 꺼내기
//		//int gType = Integer.parseInt(idNo.substring(idNo.indexOf("-")+1, idNo.indexOf("-")+2));
//		// => 비교
//		int gType = Integer.parseInt( String.valueOf(idNo.charAt(idNo.indexOf("-")+1)));
//		
//		// 2) 1,3 또는 2,4 -> 홀수 or 짝수 (확장가능성)
//		if ( gType%2==0 ) this.gender='여';
//		else this.gender='남';
//		
//		// ** age : 올해 - 태어난해 
//		// => 태어난해: idNo 의 앞2자리와 뒤 첫자리
//		//          ( 1,2 -> +1900 / 3,4 -> +2000 )
//		// => 올해(Calendar 사용) : 시스템 날짜, 시간
//		int year = Calendar.getInstance().get(Calendar.YEAR);
//		
//		if ( gType < 3 ) age = year - (Integer.parseInt(idNo.substring(0,2)) + 1900);
//		else age = year - (Integer.parseInt(idNo.substring(0,2)) + 2000); 
//	
//	} //초기화 생성자
//	
//	// 3) setter
//	public void setName(String name) { this.name=name; } 
//	
//	// 4) getter
//	public String getIdNo() {
//		return idNo.substring(0, idNo.indexOf("-"))+"-*******" ;
//	}
//	public String getName() { return name; }
//	public int getAge() { return age; }
//	public char getGender() { return gender ; }
//	
//	// 5) 출력
//	public void infoPrint() {
//		System.out.println("** info Print **");
//		System.out.println("** 번호 : "+getIdNo());
//		System.out.println("** 이름 : "+getName());
//		System.out.println("** 나이 : "+getAge());
//		System.out.println("** 성별 : "+getGender());
//	}
//	@Override
//	public String toString() {
//		return "Person [idNo=" + idNo + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
//	}
//	// => 개발자용	 (입력된 원시 Data 그대로 출력) 
//	
//} //Person

// PersonTest
// => 5명 생성 후 배열에 넣고
//    나이순으로 출력하기
// => 출력은 infoPrint() 이용

public class Ex07_PersonTest {
   public static void ageSort(Person[] arr) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = i + 1; j < arr.length; j++) {
            if (arr[i].getAge() > arr[j].getAge()) {
               Person temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
         }
      }
   }

   public static void main(String[] args) {
      Person a = new Person("Kim", "971216-1111111");
      Person b = new Person("Lee", "781004-2222222");
      Person c = new Person("Choi", "860321-1111111");
      Person d = new Person("Park", "030719-2222222");
      Person e = new Person("Eun", "090910-1111111");
      
      Person[] arr = {a, b, c, d, e};
      
      ageSort(arr);
      
      for( int i = 0; i < arr.length; i++) {
         arr[i].infoPrint();
         System.out.println();
      }
   }
   
}