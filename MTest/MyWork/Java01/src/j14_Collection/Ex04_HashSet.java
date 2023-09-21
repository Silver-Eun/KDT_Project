package j14_Collection;

import java.util.HashSet;
import java.util.Iterator;

// ** Set : ppt 30p
// => 원소의 중복을 허용하지 않고, 순서가 없음
// => HashSet, TreeSet, LinkedHashSet

// ** HashSet
// => HashSet은 해쉬 테이블에 원소를 저장하기 때문에 성능면에서 가장 우수,
//    하지만 원소들의 순서가 일정하지 않은 단점이 있다

// ** Iterator 클래스를 이용한 처리 (출력 등...)
// => 배열 -> Set
// => Set -> Iterator : 순차 처리 적용

public class Ex04_HashSet {

	public static void main(String[] args) {
		// 1) 정의
		// => 중복 허용하지 않음
		// 1.1) Object
		// => 제네릭을 적용하지 않거나, Object Type인 경우
		// 값은 같지만 Type이 다른 경우 Test (다른 데이터로 취급)
		// 즉, "123"과 123은 동일하지 않음
		Object[] ob = { "가나다", "ABC", "123", 123, new Integer(123), "Green", "123.456" };
		HashSet<Object> oSet = new HashSet<>();
		for (Object o : ob) {
			if (!oSet.add(o)) {
				System.out.println("중복자료 => " + o);
			}
		}
		// => 확인
		System.out.println("oSet => " + oSet); // toString() 오버라이딩 되어있음

		// 1.2) String
		HashSet<String> sSet = new HashSet<String>();

		// 2) 초기화
		sSet.add("Java");
		sSet.add("MySql");
		sSet.add("Web");
		sSet.add("Spring");
		sSet.add("Mybatis");
		sSet.add("JPA");
		sSet.add("Java"); // 오류는 없고 허용하지 않음
		sSet.add("Spring"); // 오류는 없고 허용하지 않음
		// sSet.add(123.456); -> String만 허용

		// => 삭제
		System.out.println("** sSet Spring 삭제결과 => " + sSet.remove("Spring"));
		System.out.println("** sSet Test 삭제결과 => " + sSet.remove("Test"));

		// 3) 출력
		System.out.println("sSet => " + sSet);
		System.out.println("sSet.size() => " + sSet.size());

		// 4) 반복처리
		// => 삭제시 필요, 반복처리가 가능하도록 해줘야함(즉, Iterator를 사용해야함)
		// => Iterator 활용
		// - 순차적으로 비교하면서 원하는값 찾기, 삭제하기
		// - 변경된 사항들은 set에 반영됨
		Iterator<String> iSet = sSet.iterator();
		while (iSet.hasNext()) {
			// if(iSet.next().equals("Web")) iSet.remove();
			// => "a" 포함된 자료는 삭제 (반복문 필요)
			if (iSet.next().contains("a"))
				iSet.remove();

			// => remove 결과는 원본인 sSet에 반영
			// => 비교
			// 반복문 내부에서 sSet 접근 : 허용하지 않음
			// ( iSet과 sSet의 remove 메소드 인자값 차이 주의 )
			// if(iSet.next().equals("Web")) sSet.remove("Web");
			// sSet.add("Oracle");
			// => 런타임 오류 발생 : java.util.ConcurrentModificationException
		}
		// => 삭제결과 : 반복문으로 출력하기
		// => iSet 재사용
		// Iterator는 한번 사용을 마치면 자료를 포인트하는 커서가
		// 끝에가 있어 hasNext()가 false를 return 하기 떄문에
		// 재할당해야 함
		iSet = sSet.iterator();
		System.out.println("iSet.hasNext() 확인 => " + iSet.hasNext());
		// => 삭제결과 반복문으로 출력하기
		while (iSet.hasNext()) {
			System.out.println("최종결과" + iSet.next());
		}

		// 5) set 과 for 반복문
		// => set은 순서의 개념이 없어 인덱스를 이용해 차례대로 순회하는것은 불가능하지만,
		// 반복문을 적용할 수 없다는것은 아님
		for (String s : sSet) {
			System.out.println("** for: s => " + s);
		}

		System.out.println("** Program 정상종료 **");
	}

}