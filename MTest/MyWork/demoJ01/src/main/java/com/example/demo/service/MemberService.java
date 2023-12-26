package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.MemberJoDTO;
import com.example.demo.entity.Member;

public interface MemberService {
	
	// ** QueryDSL 적용 1)
	public List<Member> findMemberJoDSL(int jno);
	
	// ** JPA Method Naming 규약 findBy~~ Test
	public List<Member> findByJno(int jno);
	
	// ** Join Test
	public List<MemberJoDTO> findMemberJo();
	
	// ** selectList
	public List<Member> selectList();

	// ** selectOne
	public Member selectOne(String id);

	// ** insert, update
	public String save(Member entity);

	// ** delete
	public String delete(String id);

}