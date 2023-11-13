package mapperInterface;

import java.util.List;

import com.example.demo.domain.JoDTO;


public interface JoMapper {

	//1. selectList
	List<JoDTO> selectList(); //selectList

	//2. selectOne: Detail
	JoDTO selectOne(JoDTO vo); //selectOne

	//3. insert
	int insert(JoDTO vo); //insert

	//4. update
	// => id (P.Key) 제외한 모든 컬럼수정
	int update(JoDTO vo); //update

	//5. delete
	int delete(JoDTO vo); //delete

}