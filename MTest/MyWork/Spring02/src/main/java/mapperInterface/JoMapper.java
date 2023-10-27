package mapperInterface;

import java.util.List;
import domain.JoDTO;

public interface JoMapper {
	
	// ** joList
	List<JoDTO> joList(int jno);
	
	// ** selectList
	List<JoDTO> selectList();

	// ** selectOne
	JoDTO selectOne(JoDTO dto);

	// ** Insert
	int insert(JoDTO dto);

	// ** Update
	int update(JoDTO dto);

	// ** Delete
	int delete(JoDTO dto);
}