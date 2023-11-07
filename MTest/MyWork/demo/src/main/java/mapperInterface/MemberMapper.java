package mapperInterface;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.MemberDTO;

public interface MemberMapper {
	// ** JUnit Test *********************************
	// => @Select 적용 연습
	@Select("select * from member where id=#{id}")
	MemberDTO selectOneID(String id);
	// => mapper 메서드의 매개변수는 Type 무관, 그러나 갯수는 반드시 1개

	// => @Param 적용 Test
	// -> 기본규칙: Mybatis에서는 매개변수 Type은 무관하지만, 갯수는 1개만 허용
	// -> @Param: mapper에서 #{...} 적용, 복수갯수 사용 가능 (단, 기본자료형 사용불가)
	@Select("select * from member where id=#{ii} and jno=#{jno}")
	MemberDTO selectOneJno(@Param("ii") String id, @Param("jno") Integer jno);

	// => totalCount (Group 함수 Test)
	@Select("select count(*) from member where id != 'admin'")
	int totalCount();

	// ** Jo_List 추가
	List<MemberDTO> joList(int jno);

	// ** selectList
	List<MemberDTO> selectList();

	// ** selectOne
	MemberDTO selectOne(MemberDTO dto);

	// ** insert
	int insert(MemberDTO dto);

	// ** update
	int update(MemberDTO dto);

	// ** delete
	int delete(MemberDTO dto);
}