package dao.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.SeoulGrade;
import review.dto.Seoul;

public interface RestaurantDao {
	/**
	 * 탑랭킹 리스트 조회
	 * @param conn
	 * @return
	 */
	public List<Seoul> selectByTopRest(Connection conn);
	/**
	 * 구별 탑랭킹 리스트 조회, 별점포함
	 * @param connection
	 * @param req
	 * @return
	 */
	public List<SeoulGrade> selectTopRestByTitle(Connection connection, HttpServletRequest req);
	/**
	 * 테마별 리스트 조회
	 * @param connection
	 * @param theme
	 * @return
	 */
	public List<SeoulGrade> selectThemeByBiz(Connection connection, String theme);
	/**
	 * 메뉴별 리스트 조회
	 * @param connection
	 * @param restaurant
	 * @return
	 */
	public List<SeoulGrade> selectByFoodMenu(Connection connection, SeoulGrade restaurant);


}
