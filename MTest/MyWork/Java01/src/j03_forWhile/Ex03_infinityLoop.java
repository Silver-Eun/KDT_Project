package j03_forWhile;

public class Ex03_infinityLoop {

	public static void main(String[] args) {
		// 1) for
		int count = 0;
		System.out.println("무한 Loop Test => for ");
		for(;;) { // 무조건
			System.out.println("for_count => " + count++);
			if(count > 10000) break;
		}
		
		// 2) while
		count = 0;
		System.out.println("무한 Loop Test => while ");
		while(true) {
			System.out.println("while_count => " + count++);
			if(count > 10000) break;			
		}

		// 3) do_while
		count = 0;
		System.out.println("무한 Loop Test => while ");
		 do{
			System.out.println("do_while_count => " + count++);
			if(count > 10000) break;			
		}while(true);
		
		// ** 조건문 : 무조건 실행
		if(true) System.out.println("TRUE");
		// else System.out.println("FALSE");
	}

}
