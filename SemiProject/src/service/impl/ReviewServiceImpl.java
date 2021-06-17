package service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.PagingReview;
import dao.face.ReviewDao;
import dao.impl.ReviewDaoImpl;
import dto.Member;
import dto.Review;
import dto.Seoul;
import common.JDBCTemplate;
import common.Paging;
import service.face.ReviewService;

public class ReviewServiceImpl implements ReviewService {
	private ReviewDao reviewDao = new ReviewDaoImpl();
	@Override
	public PagingReview getPaging(HttpServletRequest req) {
//		System.out.println("getPaging() 호출");
		//전달파라미터 curPage 파싱
		String param = req.getParameter("curpage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
		curPage = Integer.parseInt(param);
				}
		//Review 테이블의 총 게시글 수를 조회한다
		int totalCount = reviewDao.selectCntAll(JDBCTemplate.getConnection());
		//Paging객체 생성
		PagingReview paging = new PagingReview(totalCount, curPage);
				
		return paging;
	}
	@Override
	public List<Review> getList(PagingReview paging, Seoul upso_sno) {
		return reviewDao.selectList(JDBCTemplate.getConnection(), paging, upso_sno);
	}
	@Override
	public void write(HttpServletRequest req, Seoul upso_sno) {
		//게시글 정보 저장할 객체
		Review review = new Review();
			
		review.setUpso_sno(req.getParameter("upso_sno"));
		review.setTitle( req.getParameter("title") );
		review.setInq_content( req.getParameter("inq_content") );
		review.setStar_score(Integer.parseInt(req.getParameter("star_score")));
		review.setNick((String) req.getSession().getAttribute("usernick"));
		review.setUserno((int) req.getSession().getAttribute("userno"));
		
		System.out.println("Service- review()" + review);
		if(review.getTitle()==null || "".equals(review.getTitle())) {
			review.setTitle("(제목없음)");
		}
		Connection conn = JDBCTemplate.getConnection();
		if( reviewDao.insert(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	@Override
	public Review getReviewno(HttpServletRequest req) {
		//reviewno를 저장할 객체 생성
		Review reviewno = new Review();
		//reviewno 전달파라미터 검증 - null, ""
		String param = req.getParameter("reviewno");
		if(param!=null && !"".equals(param)) {
			
			reviewno.setReviewno(Integer.parseInt(param));
		}
		return reviewno;
	}
	@Override
	public void update(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Review review = new Review();

		review.setReviewno(Integer.parseInt(req.getParameter("reviewno")));
		review.setTitle( req.getParameter("title") );
		review.setInq_content( req.getParameter("inq_content") );
		review.setStar_score( Integer.parseInt(req.getParameter("star_score")) );

		if(review.getTitle()==null || "".equals(review.getTitle())) {
			review.setTitle("(제목없음)");
		}
//System.out.println(review);
		Connection conn = JDBCTemplate.getConnection();
		if( reviewDao.update(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	@Override
	public void delete(Review review) {
		Connection conn = JDBCTemplate.getConnection();
			
		
		if( reviewDao.delete(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
	@Override
	public int getCnt(Seoul upso_sno) {
		int cnt = reviewDao.getReviewCnt(JDBCTemplate.getConnection(), upso_sno);
		return cnt;
	}
	@Override
	public Paging getPaging(HttpServletRequest req, int userno) {
		//전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
			}
						
		//review 테이블의 총 게시글 수를 조회한다
		int totalCount = reviewDao.selectCntByUserno(JDBCTemplate.getConnection(), userno);
						
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
					
			return paging;
			}
	@Override
	public List<Review> getReview(Paging paging, int userno) {
		Connection conn = JDBCTemplate.getConnection();
		
		return reviewDao.getReview(conn, paging, userno);
	}

	

}
