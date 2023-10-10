package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc01.DBConnection;

// ** DAO(Data Access Object)
// => SQL 구문 처리
// => CRUD 구현 
//   Create(Insert), Read(selectList, selectOne), Update, Detete

//=> 첫번째 예제 Ex01_~~~ 와 DAO와 다른점
// 	- 요청 처리 결과를 제공
//	- 즉, 메서드의 역할별로 처리결과를 return 해야함
//	- 그러므로 특히 select 결과를 전달하기위해 결과를 담는 작업이 필요함  

public class StudentDAO {
	// ** 전역변수 정의
	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// ** selectList
	public List<StudentDTO> selectList() {
		sql = "select * from student";
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				// => selectList 결과 존재
				// => 결과를 list 에 담기
				// - list = rs; 불가능, 1 Row 단위로 옮겨야함
				// - 1 Row 는 StudentVO Type
				do {
					StudentDTO vo = new StudentDTO();
					vo.setSno(rs.getInt(1));
					vo.setName(rs.getString(2));
					vo.setAge(rs.getInt(3));
					vo.setJno(rs.getInt(4));
					vo.setInfo(rs.getString(5));
					vo.setPoint(rs.getDouble(6));
					vo.setBirthday(rs.getString(7));
					list.add(vo);
				} while (rs.next());
			} else {
				list = null;
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
			list = null;
		}
		return list;
	}

	// ** selectOne
	public StudentDTO selectOne(StudentDTO vo) {
		sql = "select * from student where sno=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getSno());
			rs = pst.executeQuery();
			if (rs.next()) {
				// => Data 존재: rs을 vo에 담아서 return
				vo.setName(rs.getString(2));
				vo.setAge(rs.getInt(3));
				vo.setJno(rs.getInt(4));
				vo.setInfo(rs.getString(5));
				vo.setPoint(rs.getDouble(6));
				vo.setBirthday(rs.getString(7));
				return vo;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception => " + e.toString());
			return null;
		}
	}

	// ** Group 적용
	public List<GroupDTO> groupList() {
		sql = "select jno, count(*), sum(age), avg(age), max(age), min(age) from student Group by jno";
		List<GroupDTO> list = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				do {
					GroupDTO dto = new GroupDTO();
					dto.setJno(rs.getInt(1));
					dto.setCount(rs.getInt(2));
					dto.setSum(rs.getInt(3));
					dto.setAvg(rs.getDouble(4));
					dto.setMax(rs.getInt(5));
					dto.setMin(rs.getInt(6));

					list.add(dto);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("** groupList Exception => " + e.toString());
			list = null;
		}
		return list;
	}

	// ** insert
	// => name, age, jno, info 입력
	public int insert(StudentDTO dto) {
		sql = "insert into student (name, age, jno, info) values (?, ?, ?, ?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getName());
			pst.setInt(2, dto.getAge());
			pst.setInt(3, dto.getJno());
			pst.setString(4, dto.getInfo());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("insert Exception => " + e.toString());
			return 0;
		}
	}

	// ** update
	// => info, point, birthday 수정
	public int update(StudentDTO dto) {
		sql = "update student set info=?, point=?, birthday=? where sno=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getInfo());
			pst.setDouble(2, dto.getPoint());
			pst.setString(3, dto.getBirthday());
			pst.setInt(4, dto.getSno());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("update Exception => " + e.toString());
			return 0;
		}
	}

	// ** delete
	public int delete(StudentDTO dto) {
		sql = "delete from student where sno=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getSno());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("delete Exception => " + e.toString());
			return 0;
		}
	}

	// ** Transaction Test
	// => Connection 객체가 관리
	// => 기본값은 AutoCommit true임
	// => setAutoCommit(false) -> commit 또는 rollback
	// => Test 사항
	// - 동일자료를 2번 입력 -> 2번째 입력에서 p.key 중복 오류발생

	// 1) Transaction 적용 전
	// => 동일자료를 2번 입력
	// - 1번째는 입력완료되고, 2번째 입력에서 p.key 중복 오류발생
	// - Rollback 불가능
	// - MySql Command로 1번째 입력 확인 가능

	// 2) Transaction 적용 후
	// => 동일자료를 2번 입력
	// - 1번째는 입력완료되고, 2번째 입력에서 p.key 중복 오류발생
	// - Rollback 가능 -> 둘 다 취소됨

	public void transactionTest() {
		sql = "insert into student (sno, name, age, jno, info) "
				+ "values (26, 'Test', 20, 7, 'Transaction Test')";
		/* Transaction 적용 전
		try {
			pst = cn.prepareStatement(sql);
			pst.executeUpdate(); // 첫번째는 Table에 입력완료
			pst.executeUpdate(); // 두번째에서 p.key 중복 오류
		} catch (Exception e) {
			System.out.println("** Transaction1 Exception => "+e.toString());
		}*/
		// Transaction 적용 후
		try {
			cn.setAutoCommit(false);
			pst = cn.prepareStatement(sql);
			pst.executeUpdate(); // 첫번째는 Buffer에 입력완료
			pst.executeUpdate(); // 두번째에서 p.key 중복 오류
			cn.commit();
		} catch (Exception e) {
			System.out.println("** Transaction2 Exception => "+e.toString());
			// => RollBack
			try {
				cn.rollback();
				System.out.println("** Rollback 성공");
			} catch (Exception e2) {
				System.out.println("** Rollback Exception => "+e2.toString());
			}
		}
	}

}
