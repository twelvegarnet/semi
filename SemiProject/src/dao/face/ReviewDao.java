package dao.face;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import common.PagingReview;
import dto.Member;
import dto.Review;
import dto.Seoul;

public interface ReviewDao {
	/**
	 * Review 테이블의 총 게시글 수를 조회
	 * @param connection
	 * @return 총게시글 수 cnt
	 */
	int selectCntAll(Connection connection);

	/**
	 * 페이징, 업소번호를 받은 리스트 조회
	 * @param connection
	 * @param paging
	 * @param upso_sno
	 * @return reviewList
	 */
	List<Review> selectList(Connection connection, PagingReview paging, Seoul upso_sno);

	/**
	 * 글 DB에 삽입
	 * @param conn
	 * @param review
	 * @return res
	 */
	int insert(Connection conn, Review review);

	/**
	 * 글 DB에 수정
	 * @param conn
	 * @param review
	 * @return res
	 */
	int update(Connection conn, Review review);

	/**
	 * 글 DB에서 삭제
	 * @param conn
	 * @param review
	 * @return res
	 */
	int delete(Connection conn, Review review);

	/**
	 * DB에서 업소번호에 따른 총 리뷰 개수 가져오기
	 * @param conn 
	 * @param upso_sno
	 * @return cnt
	 */
	int getReviewCnt(Connection conn, Seoul upso_sno);
	
	/**
	 * DB에서 회원번호에 따른 리뷰 개수 가져오기
	 * @param conn
	 * @param userno
	 * @return
	 */
	int selectCntByUserno(Connection conn, int userno);
	
	/**
	 * DB에서 회원번호에 따른 리뷰 목록 가져오기
	 * @param conn
	 * @param paging
	 * @param userno
	 * @return rvList
	 */
	List<Review> getReview(Connection conn, Paging paging, int userno);

}
