package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Seoul;
import dto.Review;
import service.face.DetailService;
import service.face.ReviewService;
import service.impl.DetailServiceImpl;
import service.impl.ReviewServiceImpl;

@WebServlet("/review/update")
public class ReviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReviewService reviewService = new ReviewServiceImpl();
	private DetailService detailService = new DetailServiceImpl();
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//전달 파라미터 얻기
		Seoul upso_sno = detailService.getupso_sno(req);
		Review reviewno = reviewService.getReviewno(req);
		req.setAttribute("reviewno", reviewno);
		
		req.getRequestDispatcher("/WEB-INF/views/review/update.jsp")
		.forward(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//인코딩
		req.setCharacterEncoding("UTF-8");
		//작성글 수정
		reviewService.update(req);
					
		//목록으로 리다이렉션
		resp.sendRedirect("/review/info");
	}
}
