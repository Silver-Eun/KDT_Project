package j14_Collection;
// ** Set을 이용한 로또번호 생성하기
// => 중복자료가 허용안되는 Set의 특징을 이용하여 로또 번호 생성하기
// => Random 또는 Math로 1 ~ 45 범위 내의 정수를 중복되지 않도록 
//    6개를 추출 후 오름차순으로 출력하기

// ** Set 구현 클래스
// => HashSet
// HashSet은 해쉬 테이블에 원소를 저장하기 때문에 성능면에서 가장 우수하다
// 하지만 원소들의 순서가 일정하지 않은 단점이 있다
// => TreeSet
// 레드-블랙 트리(red-black tree)에 원소를 저장한다 
// 따라서 값에 의해 순서가 결정되지만 HashSet보다는 느리다
// => LinkedHashSet
// 해쉬 테이블과 링크드 리스트를 결합한 것으로
// 원소들의 순서는 삽입되었던 순서와 같다


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Random;

public class Ex05_SetLotto {

	public static void main(String[] args) {
		Random rn = new Random();

		TreeSet<Integer> tlotto = new TreeSet<Integer>();

		while (tlotto.size() < 6) {
			tlotto.add((rn.nextInt(45) + 1));
		}

		System.out.println("tlotto => " + tlotto);

		// hashSet
		HashSet<Integer> hlotto = new HashSet<Integer>();

		while (hlotto.size() < 6) {
			hlotto.add((rn.nextInt(45) + 1));
		}

		System.out.println("hlotto => " + hlotto);

		Object[] olotto = hlotto.toArray();
		Arrays.sort(olotto);

		System.out.println("hlotto 정렬 => " + Arrays.toString(olotto));
		System.out.println("hlotto 원본 => " + hlotto); // 원본값 유지

		// 5. Collections
		// => Collection들의 WrapperClass
		// Collection과 관련된 편리한 메서드를 제공
		// 단, interface Collection과 구별
		// interface Collector의 구현클래스 Collectors와 구별
		// => Collections.sort(List<T> list)
		// 인자로 List 타입이 필요함

		// ** 오름차순 출력
		// => Set -> 순차구조 (Iterator , List)
		// => Set -> List
		// LinkedList의 생성자중에 set을 매개변수로 사용하면
		// 이 set을 list 생성해주는 생성자가 있음
		List<Integer> list = new LinkedList<>(hlotto);
		Collections.sort(list);
		System.out.println("Collections.sort => " + list);
	}

}
