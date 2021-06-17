package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.PagingReview;
import dto.Review;
import dto.Seoul;
import dto.SeoulGrade;
import service.face.DetailService;
import service.face.ReviewService;
import service.impl.DetailServiceImpl;
import service.impl.ReviewServiceImpl;




@WebServlet("/detail")
public class DetailMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService = new ReviewServiceImpl();
    private DetailService detailService = new DetailServiceImpl();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 불러들여 저장
		Seoul upso_sno = detailService.getupso_sno(req);
		Seoul viewupso = detailService.view(upso_sno);
		req.setAttribute("upso_sno", upso_sno);
		req.setAttribute("viewupso", viewupso);
		
		SeoulGrade grade = detailService.getGrade(upso_sno);
		req.setAttribute("grade", grade);
//		System.out.println("컨트롤러 grade"+ grade);
		
		int cnt = reviewService.getCnt(upso_sno);
		req.setAttribute("cnt", cnt);
		
		//1안--------------------------------------------------
//		Paging paging = reviewService.getPaging(req);		
//		req.setAttribute("paging", paging);
		
//		System.out.println("paging" + paging);
//		System.out.println(upso_sno);
//		System.out.println(viewupso);
		
		//페이징을 적용한 게시글 조회 
//		List<Review> reviewList = reviewService.getList(paging, upso_sno);
		
//		req.setAttribute("reviewList", reviewList);
//		System.out.println(reviewList);
		req.getRequestDispatcher("/WEB-INF/views/detail/detail.jsp").forward(req, resp);
		//2안 -------------------------------------------------
		
		//타입을 json으로
//		resp.setContentType("application/json");
//		resp.setCharacterEncoding("UTF-8");
//		
//		String data = req.getParameter("all data");
//		String gson = new Gson().toJson( data );
//		
//		resp.getWriter().write(gson);
		
}

}
