package mapperInterface;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.MemberDTO;

//import criTest.SearchCriteria;

public interface MemberMapper {
	
	// ** JUnit Test *********************************
	// => @Select 적용 연습
	@Select("select * from member where id=#{id}")
	MemberDTO selectOneID(String id); 
	// => mapper 메서드의 매개변수는 Type 무관, 그러나 갯수는 반드시 1개
	
	// => @Param 적용 Test
	// 	-> 기본규칙: Mybatis 에서는 매개변수 Type은 무관하지만, 갯수는 1개만 허용
	//	-> @Param: mapper 에서 #{...} 적용, 복수갯수 사용 가능 (단, 기본자료형 사용불가)
	@Select("select * from member where id=#{ii} and jno=#{jno}")
	MemberDTO selectOneJno(@Param("ii") String id, @Param("jno") Integer jno); 
	
	// => totalCount (Group 함수 Test)
	@Select("select count(*) from member where id != 'admin'")
	int totalCount();
	
	// *************************************************
	
	// ** Jo_List 추가
	List<MemberDTO> joList(int jno);

	//1. selectList
	List<MemberDTO> selectList();

	//2. selectOne: Detail
	MemberDTO selectOne(MemberDTO vo);

	//3. insert: Join
	int insert(MemberDTO vo);

	//4. update
	// => id (P.Key) 제외한 모든 컬럼수정
	int update(MemberDTO vo);

	//5. delete
	int delete(MemberDTO vo);
	

} //MemberMapper
