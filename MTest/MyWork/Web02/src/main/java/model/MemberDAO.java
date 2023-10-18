package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.MemberDTO;

// ** DAO(Data Access Object)
// => SQL 구문 처리
// => CRUD 구현 
//   Create(Insert), Read(selectList, selectOne), Update, Detete

public class MemberDAO {
	// ** 전역변수 정의
	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// ** selectList
	public List<MemberDTO> selectList() {
		sql = "select * from member";
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				// => selectList 결과 존재
				// => 결과를 list에 담기
				do {
					MemberDTO dto = new MemberDTO();
					dto.setId(rs.getString(1));
					dto.setPassword(rs.getString(2));
					dto.setName(rs.getString(3));
					dto.setAge(rs.getInt(4));
					dto.setJno(rs.getInt(5));
					dto.setInfo(rs.getString(6));
					dto.setPoint(rs.getDouble(7));
					dto.setBirthday(rs.getString(8));
					dto.setRid(rs.getString(9));
					list.add(dto);
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
	public MemberDTO selectOne(MemberDTO dto) {
		sql = "select * from member where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getId());
			rs = pst.executeQuery();
			if (rs.next()) {
				// => Data 존재: rs을 dto에 담아서 return
				dto.setPassword(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setJno(rs.getInt(5));
				dto.setInfo(rs.getString(6));
				dto.setPoint(rs.getDouble(7));
				dto.setBirthday(rs.getString(8));
				dto.setRid(rs.getString(9));
				return dto;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception => " + e.toString());
			return null;
		}
	}

	// ** insert
	// => 모든 컬림 입력
	public int insert(MemberDTO dto) {
		sql = "insert into member (id, password, name, age, jno, info, point, birthday, rid) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getPassword());
			pst.setString(3, dto.getName());
			pst.setInt(4, dto.getAge());
			pst.setInt(5, dto.getJno());
			pst.setString(6, dto.getInfo());
			pst.setDouble(7, dto.getPoint());
			pst.setString(8, dto.getBirthday());
			pst.setString(9, dto.getRid());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("insert Exception => " + e.toString());
			return 0;
		}
	}

	// ** update
	// => id와 password를 제외한 모든 컬럼 수정
	public int update(MemberDTO dto) {
		sql = "update member set name=?, age=?, jno=?, info=?, point=?, "
				+ "birthday=?, rid=? where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getName());
			pst.setInt(2, dto.getAge());
			pst.setInt(3, dto.getJno());
			pst.setString(4, dto.getInfo());
			pst.setDouble(5, dto.getPoint());
			pst.setString(6, dto.getBirthday());
			pst.setString(7, dto.getRid());
			pst.setString(8, dto.getId());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("update Exception => " + e.toString());
			return 0;
		}
	}

	// ** delete
	// => id로 삭제
	public int delete(MemberDTO dto) {
		sql = "delete from member where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getId());

			return pst.executeUpdate(); // 처리 개수
		} catch (Exception e) {
			System.out.println("delete Exception => " + e.toString());
			return 0;
		}
	}

}
