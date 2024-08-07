package service_OLD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.BoardDTO;
import model.BoardDAO;

@Component
public class BoardServiceImpl implements BoardService {
	// ** 전역변수 정의
	//BoardDAO dao = new BoardDAO();
	@Autowired
	BoardDAO dao;
	
	// ** 답글등록
	@Override
	public int rinsert(BoardDTO dto) {
		return dao.rinsert(dto);
	}

	// ** selectList
	@Override
	public List<BoardDTO> selectList() {
		return dao.selectList();
	}

	// ** selectOne
	@Override
	public BoardDTO selectOne(BoardDTO vo) {
		return dao.selectOne(vo);
	}
	
	// ** insert
	@Override
	public int insert(BoardDTO dto) {
		return dao.insert(dto);
	}
	
	// ** update
	@Override
	public int update(BoardDTO dto) {
		return dao.update(dto);
	}
		
	// ** delete
	@Override
	public int delete(BoardDTO dto) {
		return dao.delete(dto);
	}
	
}
