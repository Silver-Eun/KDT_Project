package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import domain.JoDTO;
import mapperInterface.JoMapper;
import model.JoDAO;

//** interface 자동완성 
//=> Alt + Shift + T  
//=> 또는 마우스우클릭 PopUp Menu 의  Refactor - Extract Interface...

@Component
public class JoServiceImpl implements JoService {
	
	@Autowired
	JoMapper mapper;
	
	// ** selectList
	@Override
	public List<JoDTO> selectList() {
		return mapper.selectList();
	}
	// ** selectOne
	@Override
	public JoDTO selectOne(JoDTO dto) {
		return mapper.selectOne(dto);
	}
	// ** Insert
	@Override
	public int insert(JoDTO dto) {
		return mapper.insert(dto);
	}
	// ** Update
	@Override
	public int update(JoDTO dto) {
		return mapper.update(dto);
	}
	// ** Delete
	@Override
	public int delete(JoDTO dto) {
		return mapper.delete(dto);
	}

} //class
