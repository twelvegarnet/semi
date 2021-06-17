package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import common.PagingReview;
import dto.Member;
import dto.Review;
import dto.Seoul;

public interface ReviewService {

	/** 
	 * 페이징 파라미터 받기
	 * @param req
	 * @return paging
	 */
	PagingReview getPaging(HttpServletRequest req);

	/**
	 * 페이징, 업소번호, 닉네임에 따른 리스트 조회
	 * @param paging
	 * @param upso_sno
	 * @param nick 
	 * @return reviewList
	 */
	List<Review> getList(PagingReview paging, Seoul upso_sno);
	
	/**
	 * 글작성
	 * @param req
	 * @param upso_sno 
	 */
	void write(HttpServletRequest req, Seoul upso_sno);

	/**
	 * 리뷰번호 가저오기
	 * @param req
	 * @return
	 */
	Review getReviewno(HttpServletRequest req);

	/**
	 * 글 수정
	 * @param req
	 */
	void update(HttpServletRequest req);

	/**
	 * 글 삭제
	 * @param review
	 */
	void delete(Review review);
	
	/**
	 * 업소 번호 마다의 리뷰 개수 받아오기
	 * @param upso_sno
	 * @return cnt
	 */
	int getCnt(Seoul upso_sno);

	/**
	 * 회원번호에 따른 페이징
	 * @param req
	 * @param userno
	 * @return paging
	 */
	Paging getPaging(HttpServletRequest req, int userno);

	/**
	 * 페이징과 회원번호에 따른 리뷰 목록 조회
	 * @param paging
	 * @param userno
	 * @return rvList
	 */
	List<Review> getReview(Paging paging, int userno);


}
