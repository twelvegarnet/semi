package dao.face;

import java.sql.Connection;

import dto.Seoul;
import dto.SeoulGrade;

public interface DetailDao {

	/**
	 * 업소번호에 따른 업소 정보 조회
	 * @param conn
	 * @param upso_sno
	 * @return
	 */
	Seoul selectUpsoByUpso_sno(Connection conn, Seoul upso_sno);

	/**
	 * 업소번호에 따른 업소 평점 조회
	 * @param connection
	 * @param upso_sno
	 * @return grade
	 */
	SeoulGrade selectGradeByUpso_sno(Connection connection, Seoul upso_sno);

}
