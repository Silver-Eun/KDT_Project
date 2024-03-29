package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.MemberDTO;

import mapperInterface.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	// ** 전역변수 정의
	@Autowired
	MemberMapper mapper;
	
	// ** RTestControler incheck2 Test
	@Override
	public MemberDTO selectOneJno(String id, Integer jno) {
		return mapper.selectOneJno(id, jno);
	}
	
	// ** Jo_List 추가
	@Override
	public List<MemberDTO> joList(int jno) {
		return mapper.joList(jno);
	}
	
	// ** selectList
	@Override
	public List<MemberDTO> selectList() {
		return mapper.selectList();
	}
	// ** selectOne
	@Override
	public MemberDTO selectOne(MemberDTO dto) {
		return mapper.selectOne(dto);
	}

	// ** insert
	@Override
	public int insert(MemberDTO dto) {
		return mapper.insert(dto);
	}
	// ** update
	@Override
	public int update(MemberDTO dto) {
		return mapper.update(dto);
	}
	// ** delete
	@Override
	public int delete(MemberDTO dto) {
		return mapper.delete(dto);
	}
	
} //class
