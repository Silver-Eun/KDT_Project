package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.BoardDTO;
import mapperInterface.BoardMapper;

// ** Mybatis 적용
// => CRUD 처리를 Mapper를 이용
// => DAO -> Mapper interface ->  Mapper.xml

// ** Mybatis interface 방식으로 적용
// => MemberDAO 대신 MemberMapper 사용
// => MemberMapper의 인스턴스를 스프링이 생성해주고 이를 주입받아 실행함
//    (스프링이 생성해주는 동일한 타입의 클래스는 JUnit Test로 확인가능, 추후 실습) 
// => 단, 설정파일에 <mybatis-spring:scan base-package="mapperInterface"/> 반드시 추가해야함
//    MemberDAO의 Sql구문 처리-> mapperInterface 사용으로 MemberMapper가 역할을 대신함

// => SQL 구문 : xml로 작성 -> 이 파일을 Mapper라 함 
// => Mapper 작성규칙
//    -> mapperInterface와 패키지명, 화일명이 동일해야함

@Service
public class BoardServiceImpl implements BoardService {
	// ** 전역변수 정의
	//BoardDAO dao = new BoardDAO();
	@Autowired
	// => BoardMapper의 인스턴스를 스프링이 생성해주고 이를 주입받아 실행함
	//    즉, 위 인터페이스의 구현체(클래스)는 개발자가 작성할 필요가 없음
	BoardMapper mapper;
	
	// ** 답글등록
	// => rinsert, stepUpdate
	@Override
	public int rinsert(BoardDTO dto) {
		if (mapper.rinsert(dto) > 0) {
			// stepUpdate
			System.out.println("** stepUpdate Count => " + mapper.stepUpdate(dto));
			return 1;
		} else return 0;
	}

	// ** selectList
	@Override
	public List<BoardDTO> selectList() {
		return mapper.selectList();
	}

	// ** selectOne
	@Override
	public BoardDTO selectOne(BoardDTO vo) {
		return mapper.selectOne(vo);
	}
	
	// ** insert
	@Override
	public int insert(BoardDTO dto) {
		return mapper.insert(dto);
	}
	
	// ** update
	@Override
	public int update(BoardDTO dto) {
		return mapper.update(dto);
	}
		
	// ** delete
	@Override
	public int delete(BoardDTO dto) {
		return mapper.delete(dto);
	}
	
}
