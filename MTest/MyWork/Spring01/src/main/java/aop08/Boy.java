package aop08;

import java.util.Random;

import org.springframework.stereotype.Component;

//** Aop 구현 8 
//=> Around : 핵심관심사항에 인자(매개변수)와 return값이 있는 경우 
//=> @ Test

@Component("boy")
public class Boy implements Programmer {

	public Boy() {
		System.out.println("** Boy default 생성자 **");
	}

	@Override
	public String doStudying(int n) throws Exception {

		System.out.println("게시판을 " + n + "개 만듭니다 => 핵심적 관심사항");

		// if (new Random().nextBoolean()) // true : 실패
		if (true) // true : 실패 -> 항상 비정상종료 되도록
			throw new Exception("홀랑 다 날렸다 => 예외발생");
		return "취업성공 연봉 1억";
	} // doStudying

} // Boy
