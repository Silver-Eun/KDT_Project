package j14_Collection;

import java.util.*;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;

// ** HashMap의 순차처리 ( Iterator , Entry ) 
// => HashMap의 주요 메서드 ( Set Type으로 return ) 활용
// - entrySet() : key + value를 Entry Type으로 묶어 Set으로
// - keySet() : key값들만 Set으로
// - values() : value들만 Set으로
// 1) 키와 값을 같이 읽어 순차처리
// 2) 키와 값을 따로 읽어 순차처리

public class Ex09_MapIterator {

	public static void main(String[] args) {
		// 1. HashMap 정의
		// => <이름, 점수>
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("Kim", 90);
		hm.put("Lee", 90);
		hm.put("Choi", 50);
		hm.put("Park", 80);
		hm.put("Eun", 70);
		System.out.println("hm => " + hm);

		// 2. 순차처리
		// 2.1) entrySet() : key+value를 Entry Type으로 묶어 Set으로
		// => HashMap의 entrySet() -> Set -> Iterator
		// 키와 값을 같이읽어 하나의 데이터(entry)로 Set에 저장
		
		// ** ?
		// <?> => 모든 자료형 을 의미 , 내부적으로는 Object
		// <? super 객체형 > => 명시된 객체형의 상위 객체
		// <? extends 객체형 > => 명시된 객체형과 객체형을 상속한 하위 객체
		Set<?> set = hm.entrySet();
		System.out.println("se => " + set);
		
		// ** Set -> Iterator
		Iterator<?> iSet = set.iterator();
		while(iSet.hasNext()) {
			// System.out.println("while : " + iSet.next());
			// => key, value 구분 없음 (Set의 Data을 읽어오는것과 불과)
			// => key, value 구분하려면
			// => Entry 객체 활용 : Entry 객체를 이용해서 key, value 구분 가능
			Map.Entry<?, ?> e = (Map.Entry<?, ?>)iSet.next();
			// => Map.Entry<?, ?> Type의 인스턴스 e를 통해 key, value 접근 가능
			System.out.printf("Entry : key = %s, value = %d\n", e.getKey(), e.getValue());
		}

		// 2.2) keySet() : key 값들만 Set 으로
		// => HashMap의 keySet() -> Set -> Iterator
		set = hm.keySet();
		System.out.println("keySet => " + set);
		
		// => Set -> Iterator
		iSet = set.iterator();
		
		// => while
		while (iSet.hasNext()) {
			// System.out.println("key=" + iSet.next());
			// System.out.println("value=" + hm.get(iSet.next()));
			// => next()가 2회 일어나므로 바람직하지 않음 : 논리적 오류, 실행 오류 모두 발생
			String hmkey = (String)iSet.next();
			System.out.printf("Entry : key = %s, value = %d\n", hmkey, hm.get(hmkey));
		}
		
		// => 2) for
		for (String s:hm.keySet()) {
			System.out.printf("Entry : key = %s, value = %d\n", s, hm.get(s));			
		}
		
		// 2.3) values() : value들만 Set으로
		// 총합계, 평균 출력하기
		Collection<Integer> cv = hm.values();
		// => Collection -> Iterator
		iSet = cv.iterator();
		int sum = 0;
		while (iSet.hasNext()) {
			sum += (Integer)iSet.next();
		}
		System.out.println("총합계 = " + sum);
		System.out.println("평균 = " + sum/(hm.size()));
		System.out.println("최고점수 = " + Collections.max(cv));
		System.out.println("최고점수 = " + Collections.min(cv));
	}

}
// ** Entry -------------------------------------------
// Map 인터페이스는 내부에 내부인터페이스 Entry를 가지고 있고,
// Object key, Object value는 Entry 인터페이스에 선언되어 있음
// 그러므로 Map의 key와 value는 각각의 Object 이며 Map.Entry타입으로 저장
// 그래서 Map의 key와 value에 접근 할때는
// => 먼저 Map의 인스턴스에서 entrySet으로 키와 value를 둘다 가져옴
// => entrySet은 Set타입이므로 Set타입 인스턴스에 저장
// => Set타입으로 가져온 인스턴스에서 iterator()메소드 호출해서 iterator가져옴
// => 얻어온 iterator에서 hasNext메소드를 호출하여 HashMap 내부 요소에 접근
// => HashMap의 각 key와 value값은 결국 Map.Entry 타입의 배열에 들어있으므로
//    HashMap에서 각 key와 value값에 접근하기 위해서는
//    Map.Entry 타입 인스턴스에 iterator의 next()메소드로 key와 value값 가져옴