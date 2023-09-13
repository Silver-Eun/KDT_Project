package j10_Exception;
// ** try ~ catch ~ finally
// => finally 블럭은 무조건 시행
// => 1) 정상실행
//    2) Exception : ArrayIndexOutOfBoundsException
//    3) 반복문 제어할 수 있는 구문 : return, break, continue

public class Ex03_finally {

	public static void main(String[] args) {
		int[] price = {100, 200, 300};
		
		// Test 1)
		// for (int i = 0; i < price.length; i++){
		
		// Test 2)
		for (int i = 0; i < price.length; i++) {
			try {
				// Test 3) continue, break, return
				// => try 블럭에 진입하면 무조건 finally는 실행
				if(i == 1) return; // void 메소드에서 사용하면 메소드 무조건 종료
				if(i == 2) break; // 무조건 반복문 종료
				if(i == 3) continue;
				// => 나머지 문장 실행하지않고 다음 반복문 실행
				//    그러나 i = 4면 반복문 종료
				System.out.printf("price[%d] = %d \n", i, price[i]);
			} catch (Exception e) {
				System.out.println("Exception => " + e.toString());
			} finally {
				System.out.println("finally 무조건 실행, i => " + i);
			}
			System.out.println("for_endLine, i => " + i);
		}
		System.out.println("Program 정상종료");
	}

}
