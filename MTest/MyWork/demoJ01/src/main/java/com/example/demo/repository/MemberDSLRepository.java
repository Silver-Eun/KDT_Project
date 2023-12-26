package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.MemberJoDTO;
import com.example.demo.entity.Member;

public interface MemberDSLRepository {
	
	// ** QueryDSL 적용 (Entity return)
	// => Parameter로 전달된 조원들만 출력하기 
	List<Member> findMemberJoDSL(int jno);
	
	// **QueryDSL 적용 ( Join & DTO return )
	List<MemberJoDTO> findMemberJoinDSL();
	
}
