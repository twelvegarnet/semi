package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PagingReview;
import dto.Seoul;
import dto.Member;
import dto.Review;
import service.face.DetailService;
import service.face.MemberService;
import service.face.ReviewService;
import service.impl.DetailServiceImpl;
import service.impl.MemberServiceImpl;
import service.impl.ReviewServiceImpl;

@WebServlet("/review/list")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService = new ReviewServiceImpl();
    private DetailService detailService = new DetailServiceImpl();
//    private MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터를 전달하여 객체 생성하기
		PagingReview paging = reviewService.getPaging(req);
		Seoul upso_sno = detailService.getupso_sno(req);
		Seoul viewupso = detailService.view(upso_sno);
//		Member nick = memberService.getLoginMember(req);
		
		//업소번호 MODEL값
		req.setAttribute("upso_sno", upso_sno);
		req.setAttribute("viewupso", viewupso);
		req.setAttribute("paging", paging);
//		req.setAttribute("usernick", nick);
				
//		System.out.println(upso_sno);
//		System.out.println(viewupso);
		
		//페이징을 적용한 게시글 조회
		List<Review> reviewList = reviewService.getList(paging, upso_sno);
		System.out.println("reviewList" + reviewList);
		req.setAttribute("reviewList", reviewList);

		req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);

	}

}
