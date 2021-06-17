package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.SeoulGrade;
import review.dto.Seoul;

public interface RestaurantService {

	/**
	 * 탑랭킹 맛집 정보가져오기
	 * @return
	 */
	public List<Seoul> getTopRest();
	/**
	 * 구별 탑랭킹 맛집 정보 가져오기
	 * @param req
	 * @return
	 */
	public List<SeoulGrade> getTopRest(HttpServletRequest req);
	/**
	 * 테마별 맛집 리스트 가져오기
	 * @param parameter
	 * @return
	 */
	public List<SeoulGrade> getThemeList(String parameter);
	/**
	 * 메뉴별 쿼리 세팅
	 * @param req
	 * @return
	 */
	public SeoulGrade setQueryString(HttpServletRequest req);
	/**
	 * 음식별 분류 리스트 가져오기
	 * @param restaurant
	 * @return
	 */
	public List<SeoulGrade> getFoodList(SeoulGrade restaurant);





}
