package aop03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// ** IOC/DI 적용
		// => 스프링컨테이너 생성
		// => 필요한 Bean을 주입받는다
		
		AbstractApplicationContext sc = 
				new GenericXmlApplicationContext("aop03.xml");
		Programmer programmerB = (Programmer)sc.getBean("boy");
		Programmer programmerG = (Programmer)sc.getBean("girl");
		programmerB.doStudying();
		programmerG.doStudying();
		sc.close();
	} //main

} //class
