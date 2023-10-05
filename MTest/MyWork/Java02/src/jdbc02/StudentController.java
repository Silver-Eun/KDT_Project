package jdbc02;

import java.util.List;

// ** Controller
// => 요청 : 요청분석 -> 담당 Service -> Service는 DAO 
// => 결과 : DAO -> Service -> Controller
// => View : Controller -> View 담당 (Java:Console // Web:JSP, Html.., React) 

public class StudentController {
	// ** 전역변수 정의
	StudentService service = new StudentService();

	// ** View 역할 메소드
	public void printList(List<StudentVO> list) {
		System.out.println("** student List **");
		if(list!=null) {
			// ** list 출력
			for(StudentVO s:list) {
				System.out.println(s);
			}
		} else {
			System.out.println("** selectList : 출력 Data가 1건도 없음 **");
		}
	}
	
	// => selectOne 호출
	public void printDetail(StudentVO vo) {
		System.out.println("** student Detail **");
		if (vo!= null) {
			System.out.println(vo);
		} else {
			System.out.println("** selectOne : 출력할 Data가 없음 **");
		}
	}
	
	// => groupList 호출
		public void printGroup(List<GroupDTO> list) {
			System.out.println("** student List **");
			if(list!=null) {
				// ** list 출력
				for(GroupDTO s:list) {
					System.out.println(s);
				}
			} else {
				System.out.println("** groupList : 출력 Data가 1건도 없음 **");
			}
		}

	public static void main(String[] args) {
		// ** StudentController 인스턴스 생성
		StudentController sc = new StudentController();
		
		// ** student_List
		// => 요청에 해당하는 service.selectList() 메소드 실행
		// => 위의 결과를 view에 처리하도록 전달
		sc.printList(sc.service.selectList());
		
		// ** Student_Detail
		StudentVO vo = new StudentVO();
		vo.setSno(21);
		sc.printDetail(sc.service.selectOne(vo));
		
		// ** Group 적용
		sc.printGroup(sc.service.groupList());
	}

}
