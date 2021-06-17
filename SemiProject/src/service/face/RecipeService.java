package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import dto.Recipe;

public interface RecipeService {

	/**
	 * Paging에 필요한 모든 정보를 산출하여 페이지네이션을 설정한다
	 * 
	 * @param req
	 * @return Paging에 필요한 startno 등 모든 데이터
	 */
	Paging getPaging(HttpServletRequest req);
	
	/**
	 * 모든 레시피 게시판의 글을 가져온다
	 * @param paging 
	 * 
	 * @return 레시피 테이블의 모든 데이터
	 */
	List<Recipe> getRecipeList(Paging paging);
	
	/**
	 * list.jsp에서 얻어온 postno로 해당하는 게시글의 모든 데이터를 가져온다
	 * 
	 * @return 해당 글 번호의 모든 데이터
	 */
	Recipe getRecipe(String postno);

	/**
	 * req에 jsp에서 가져올 수 있는 값들을 담아 dao에서 필요정보를 얻어온 다음
	 * insert메소드로 삽입 후 커밋한다
	 * 
	 * @param req
	 * @param resp 
	 * @return 
	 */
	void write(HttpServletRequest req, HttpServletResponse resp);
	
	/**
	 * 레시피 상세보기에서 얻은 postno를 이용하여 해당 recipe의 모든 데이터를 가져온다
	 * 
	 * @param postno 해당 레시피 게시글의 모든 데이터를 가져올 기준 postno 값
	 * @return 해당 레시피 게시글의 모든 정보
	 */
	Recipe getDataByUserno(String postno);
	

	/**
	 * Userno로 해당 Recipe의 모든 정보를 가져온다
	 * 
	 * @param userno
	 * @return Userno에 해당하는 모든 Recipe
	 */
	Recipe getRecipeByUserno(HttpServletRequest req);

	/**
	 * update.jsp에서 수정된 내용을 DB의 기존값에 덮어씌운다
	 * 
	 * @param req 수정될 레시피 게시글 데이터
	 */
	void Updatedata(HttpServletRequest req);

	/**
	 * 수정된 레시피 게시글의 데이터중 postno만 일치시켜서 레시피 게시글 데이터 전체를 가져온다
	 * 
	 * @param req
	 * @return 수정된 레시피 게시글의 전체 데이터
	 */
	Recipe getRecipeDataFromReq(HttpServletRequest req);

	/**
	 * 게시글 번호를 담고있는 req객체를 전달하여 해당 게시글 삭제
	 * 
	 * @param req 게시글번호를 담고있는 객체
	 */
	void deleteRecipe(HttpServletRequest req);

	/**
	 * 수정된 게시글의 postno, title, content를 파일에도 적용시킨다
	 * 
	 * @param req
	 * @param resp
	 */
	void Update(HttpServletRequest req, HttpServletResponse resp);

	/**
	 * 로그인한 회원이 작성한 레시피 리스트를 반환한다
	 * 
	 * @param userno
	 * @return 해당 회원이 작성한 레시피 리스트
	 */
	List<Recipe> getRecipe(int userno);

	/**
	 * 회원의 모든 레시피 리스트를 반환한다(페이징 적용)
	 * @param paging
	 * @param userno
	 * @return
	 */
	List<Recipe> getRecipe(Paging paging, int userno);

	/**
	 * Paging에 필요한 모든 정보를 산출하여 페이지네이션을 설정한다
	 * 
	 * @param req
	 * @return Paging에 필요한 startno 등 모든 데이터
	 */
	Paging getPaging(HttpServletRequest req, int userno);

	/**
	 * 해당 검색어로 검색된 모든 레시피 리스트를 가져온다
	 * 
	 * @param req
	 * @param paging 
	 * @return
	 */
	List<Recipe> getRecipeList(HttpServletRequest req, Paging paging);


}
