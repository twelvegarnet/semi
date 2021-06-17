package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Seoul;

public interface TestDao {
	/** 
	 * 서울 리스트 목록 조회
	 * @param connection
	 * @return
	 */
	List<Seoul> selectList(Connection connection);

}
