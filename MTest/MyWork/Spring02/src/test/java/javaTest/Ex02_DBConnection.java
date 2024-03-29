package javaTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

// ** @ 종류
// => @Before - @Test - @After
//  -> 하나의 클래스에서 @들을 반복사용하면 오류는 안나지만, 마지막 @만 실행됨
// => @ 적용 테스트 메서드 : non static, void로 정의 해야 함.

public class Ex02_DBConnection {
	// 1) static, return값 있는 경우 Test
	// => Test 메서드를 작성해서 Test
	// @Test : 불허
	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			Connection cn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("** JDBC Connection 성공");
			return cn;
		} catch (Exception e) {
			System.out.println("** JDBC Connection Exception => " + e.toString());
			return null;
		}
	}
	public void connectionTest() {
		System.out.println("** DB_Connection => " + getConnection());
		// => 연결성공 -> 주소 return
		//	  연결실패 -> null return
		assertNotNull(getConnection());
	}
	
	@Test
	// 2) non static, void로 정의
	// => finally 추가하지 않은 경우: 항상 Green_Line , console의 메시지로 확인
	// => finally 추가: cn값 확인
	public void getConnectionVoid() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			cn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("** JDBC Connection 성공 = > " + cn);
		} catch (Exception e) {
			System.out.println("** JDBC Connection Exception => " + e.toString());
		} finally {
			assertNotNull(cn);			
		}
	}
	
}
