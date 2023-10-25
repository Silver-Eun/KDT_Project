package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.MemberDTO;
import model.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	// ** 전역변수 정의
	//MemberDAO dao = new MemberDAO();
	@Autowired
	MemberDAO dao;

	// ** selectList
	@Override
	public List<MemberDTO> selectList() {
		return dao.selectList();
	}

	// ** selectOne
	@Override
	public MemberDTO selectOne(MemberDTO vo) {
		return dao.selectOne(vo);
	}
	
	// ** insert
	@Override
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}
	
	// ** update
	@Override
	public int update(MemberDTO dto) {
		return dao.update(dto);
	}
		
	// ** delete
	@Override
	public int delete(MemberDTO dto) {
		return dao.delete(dto);
	}
	
}
