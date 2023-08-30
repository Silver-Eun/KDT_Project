package j02_ifSwitch;

public class Ex01_ifBasic {

	public static void main(String[] args) {
		// ** 삼항식
		boolean rain = true; // 지역변수 : 메서드 내에서만 유효
		String doing = (rain == true) ? "Study Java" : "Study React";

		// ** if : 단일구문
		if (rain == true)
			doing = "Study Java";
		else
			doing = "Study React";
		// => else 구문은 생략 가능(필요시에만 사용)

		// ** if : 복합구문(compound statement)
		// => 여러문장의 경우 중괄호를 사용하여 문장들을 그룹핑
		if (rain) {
			int i = 100; // 지역변수 : 정의된 { }내에서만 유효
			System.out.println("** 비오면 ");
			System.out.println(doing);
			System.out.println("** 비오면 우산 필요, i = " + i);
		} else {
			System.out.println("** 비 안오면 ");
			System.out.println(doing);
			// System.out.println("** 비 안오면 양산 필요" + i); -> 사용 불가
		}

		// ** 복합조건식
		// => 날씨가 좋고 공휴일이면 공원에 산책을 간다
		// 아니면 집에서 요리를 한다
		// => rain은 false, day는 'Red'이면
		String day = "Red";
		if (!rain && day == "Red")
			doing = "삼겹살에 소주를 먹는다.";
		else
			doing = "부침개에 막걸리 먹는다.";
		System.out.println(doing);

		// ** 중첩 if 구문
		// => if문 내에 if문 포함
		if (!rain) {
			if (day == "Red") {
				System.out.println("공원으로 산책가기");
			} else {
				System.out.println("집에서 요리하기");
			}
		} else {
			System.out.println("집에서 요리하기");
		}

	}

}