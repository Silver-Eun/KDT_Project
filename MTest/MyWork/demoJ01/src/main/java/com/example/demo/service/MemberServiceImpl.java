package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.MemberJoDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberDSLRepositoryImpl;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MyRepositoryImpl;

import lombok.RequiredArgsConstructor;

// ** MemberController 에서 요청하는 메서드만 작성
// => selectList(), 
//	  service.selectOne(entity.getId()),
//	  save(entity), delete(entity.getId())

//@Log4j2
@Service
@RequiredArgsConstructor 
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository repository;
	private final MemberDSLRepositoryImpl drepository;
	private final MyRepositoryImpl mrepository;
	
	
	// ** QueryDSL 적용 1)
	@Override
	public List<Member> findMemberJoDSL(int jno) {
		return drepository.findMemberJoDSL(jno);
	}
	
	// ** JPA Method Naming 규약 findBy~~ Test
	@Override
	public List<Member> findByJno(int jno) {
		return repository.findByJno(jno);
	}
	
	// ** Join Test
	@Override
	public List<MemberJoDTO> findMemberJo(){
		// 1) @Query("...") 에 JPQL, LEFT_JOIN 구문, MemberJoDTO return
		//return repository.findMemberJo();
		// 2) QueryDSL 적용 2) Join & DTO return
		return drepository.findMemberJoinDSL();
	}
	
	// ** selectList
	@Override
	public List<Member> selectList() {
		// 1) 기본형 : JpaRepository 적용
		// return repository.findAll();
		
		// 2) MyRepository 적용
		// => EntityManager 활용
		return mrepository.adminMemberList();
	}
	
	// ** selectOne
	@Override
	public Member selectOne(String id) {
		Optional<Member> result = repository.findById(id);
    	if ( result.isPresent() ) return result.get();
    	else return null;
	}

	// ** insert, update
	@Override
	public String save(Member entity) {
		repository.save(entity); // 저장 또는 수정
        return entity.getId();   // 저장후 key return
	}
	 
	// ** delete
	@Override
	public String delete(String id) {
		repository.deleteById(id);
		return id; // 삭제후 key return
	}
	
} //class
