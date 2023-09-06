package j05_classMethod;
// => 6-1
//	-> 맴버변수는 private 으로 정의
//	-> setter/getter, toString 추가
// => 6-2 : info() 는 만들지 않아도 됨.
// => 6-3
//	-> Student 의 인스턴스를 5개 만들어서 배열에 담기
//	-> 배열을 이용해서 위 5개 인스턴스의 정보와 
//  Total, Average 출력하기

class Student {
	// 1) 매개변수 선언문
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;
	
	// 2) 메소드
	// => 생성자
	public Student() {}
	public Student(String name,int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math= math;
	}

	// => setter/getter
	public void setName(String name) { this.name = name; }
	public String getName() { return name; }
	public void setBan(int ban) { this.ban = ban; }
	public int getBan() { return ban; }
	public void setNo(int no) { this.no = no; }
	public int getNo() { return no; }
	public void setKor(int kor) { this.kor = kor; }
	public int getKor() { return kor; }
	public void setEng(int eng) { this.eng = eng; }
	public int getEng() { return eng; }
	public void setMath(int math) { this.math= math; }
	public int getMath() { return math; }
	
	// => 사용자 정의 메소드
	public int getTotal() { return kor + eng + math;}
	// => 평균은 소수이하 2자리로
	public float getAverage() { 
		// return (kor + eng + math)/3;
		// return (int)((kor + eng + math) / 3f * 10 + 0.5f) / 10f;
		return Math.round(((kor + eng + math) / 3f) * 10) / 10.0f;
		}
	
	public String toString() {
		return "[이름=" + name + ", 반" + ban + ", 국어점수=" + kor 
				+ ", 영어점수=" + eng + ", 수학점수 = " + math + "]";
	}
	// 성적순 정렬
	// => 인스턴스 없이 다른 클래스들이 호출 가능하도록 작성
	// => 내림차순
	public static void studentSort(Student[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i].getTotal() < arr[j].getTotal()) {
					Student temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}

public class Ex09_StudentTest {

	public static void main(String[] args) {
		
		// 1) student 배열 만들기
		Student st1 = new Student("Kim", 1, 1, 98, 67, 78);
		// String name="가나다라"; int age = 100;과 동일한 선언문(비교)
		Student st2 = new Student("Park", 2, 2, 64, 61, 79);
		Student st3 = new Student("Lee", 3, 3, 86, 71, 81);
		Student st4 = new Student("Choi", 4, 4, 89, 68, 91);
		Student st5 = new Student("Eun", 5, 5, 68, 79, 83);
		
		Student[] arr1 = {st1, st2, st3, st4, st5};
		// Student[] arr1 = {st1, st2, st3, new Student("Choi", 4, 4, 89, 68, 91), st5};
		
		// 2) 출력
		// => eachFor 적용 : index 사용할 필요없고 readOnly의 경우
		// => 기능추가 : 반 전체 합계, 평균 계산하고 출력
//		for(int i = 0; i < arr1.length; i++) {
//			
//			System.out.println(arr1[i]);
//			System.out.println("total=" + (arr1[i].getKor() + arr1[i].getEng()
//					+ arr1[i].getMath()) + ", average=" + (arr1[i].getKor() + arr1[i].getEng()
//							+ arr1[i].getMath())/3f);
//		}
		
		int sum = 0;
		double avg = 0;
		for(Student a:arr1) {
			System.out.println(a);
			System.out.printf("Total = %d, Average = %5.2f\n", a.getTotal(), a.getAverage());
			sum += a.getTotal();
			avg += a.getAverage();
		}
		System.out.printf("전체 합계 Total = %d, 전체평균 Average = %5.2f\n", sum, avg);
		
		// 3) 석차순 출력
		// => 정렬 메소드 만들기
		// => 인스턴스 없이 다른 클래스들이 호출 가능하도록 작성
		Student.studentSort(arr1);
		// => 정렬 메소드 실행 후 arr1의 순서는 밴경
		System.out.println("성적순 출력");
		for(Student a:arr1) { System.out.println(a); }
	}

}
