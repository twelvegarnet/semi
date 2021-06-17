package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import common.PagingReview;
import dto.Review;
import service.face.ReviewService;
import service.impl.ReviewServiceImpl;

@WebServlet("/mypage/review")
public class MyPageReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReviewService reviewService = new ReviewServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//요청파라미터를 전달하여 객체 생성하기
		int userno = (int) req.getSession().getAttribute("userno");
		Paging paging = reviewService.getPaging(req, userno);
		
		req.setAttribute("paging", paging);
		
		//해당 회원이 작성한 레시피 리스트
		List<Review> rvList = reviewService.getReview(paging, userno);
				
		req.setAttribute("rvList", rvList);
				
		req.getRequestDispatcher("/WEB-INF/views/mypage/myreviewlist.jsp")
					.forward(req, resp);
	}
}
