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
	public void printList(List<StudentDTO> list) {
		System.out.println("** student List **");
		if(list!=null) {
			// ** list 출력
			for(StudentDTO s:list) {
				System.out.println(s);
			}
		} else {
			System.out.println("** selectList : 출력 Data가 1건도 없음 **");
		}
	}
	
	// => selectOne 호출
	public void printDetail(StudentDTO vo) {
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
		/*
		// ** student_List
		// => 요청에 해당하는 service.selectList() 메소드 실행
		// => 위의 결과를 view에 처리하도록 전달
		sc.printList(sc.service.selectList());
		
		// ** Student_Detail
		StudentDTO dto = new StudentDTO();
		dto.setSno(21);
		sc.printDetail(sc.service.selectOne(dto));
		
		// ** Group 적용
		sc.printGroup(sc.service.groupList());
		
		// ** insert
		// => dto에 입력값 담기 -> Service(-> dto) -> 결과 출력
		dto.setName("관리자");
		dto.setAge(99);
		dto.setJno(7);
		dto.setInfo("insert test");
		if (sc.service.insert(dto) > 0) {
			System.out.println("** insert 성공");
		} else System.out.println("** insert 실패");
		
		// ** update
		// => info, point, birthday 수정, sno=25
		dto.setInfo("update Test");
		dto.setPoint(123.456);
		dto.setBirthday("2000-09-08");
		dto.setSno(25);
		if ( sc.service.update(dto) > 0) {
			System.out.println("** update 성공 & 확인");
			sc.printDetail(sc.service.selectOne(dto));
		}
		else System.out.println("** update 실패");
		
		// ** delete
		dto.setSno(41);
		if (sc.service.delete(dto) > 0) {
			System.out.println("** delete 성공 & 확인");
			sc.printDetail(sc.service.selectOne(dto));
		} else System.out.println("** delete 실패");
		*/
		// ** Transaction Test
		// => command에서 복습
		// => JDBC에서 적용 전/후 비교
		// => JDBC : Connection 객체가 관리
		//			 기본값은 AutoCommit true
		//			 setAutoCommit(false) -> commit 또는 rollback
		// => 적용 전
		sc.service.transactionTest();
	}

}
