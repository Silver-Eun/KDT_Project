package j02_ifSwitch;

import java.util.Scanner;

public class Ex04_switchMonth {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.printf("월을 입력하세요 => ");
//		int month = Integer.parseInt(sc.nextLine());
//		
//		switch(month) {
//		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
//			System.out.println(month + "월은 31일까지입니다."); break;
//		case 4: case 6: case 9: case 11:
//			System.out.println(month + "월은 30일까지입니다."); break;
//		case 2: System.out.println(month + "월은 28일까지입니다."); break;
//		}
//		switch(month) {
//		case 3: case 4: case 5:
//			System.out.println(month + "월은 봄입니다."); break;
//		case 6: case 7: case 8:
//			System.out.println(month + "월은 여름입니다."); break;
//		case 9: case 10: case 11:
//			System.out.println(month + "월은 가을입니다."); break;
//		case 12: case 1: case 2:
//			System.out.println(month + "월은 겨울입니다."); break;
//		}
		int month = 0;
		int days = 0;
		int year = 0;
		String season = null;
		System.out.printf("연도를 입력하세요 => ");
		year = Integer.parseInt(sc.nextLine());
		System.out.printf("월을 입력하세요 => ");
		month = Integer.parseInt(sc.nextLine());
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			days = 31; break;
		case 4: case 6: case 9: case 11:
			days = 30; break;
		case 2:
			// => 윤년 확인 추가
			if((year % 4) == 0 && (year % 100) != 0 || (year % 400) == 0)
			days = 29; 
			else days = 29;
			break;
		}
		
		 /* => new_version
        Java 버젼 15이상 부터 가능
  		switch (month) {
     	case 1,3,5,7,8,10,12: days = 31; break;
     	case 4,6,9,11: days = 30; break;
     	case 2:  days = 29; break;
   		} //switch
		*/
		
		switch(month) {
		case 3: case 4: case 5:
			season = "봄"; break;
		case 6: case 7: case 8:
			season = "여름"; break;
		case 9: case 10: case 11:
			season = "가을"; break;
		case 12: case 1: case 2:
			season = "겨울"; break;
		}
		
		sc.close();
		
		System.out.printf("%d년 %d월은 %d일까지 있고, %s입니다.\n", year, month, days, season);

	}

}
