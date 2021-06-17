package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import dto.Seoul;
import service.face.DetailService;
import service.face.ReviewService;
import service.impl.DetailServiceImpl;
import service.impl.ReviewServiceImpl;

@WebServlet("/review/write")
public class ReviewWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReviewService reviewService = new ReviewServiceImpl();
	private DetailService detailService = new DetailServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Seoul upso_sno = detailService.getupso_sno(req);
		req.setAttribute("upso_sno", upso_sno);
		//로그인 되어있지 않으면 리다이렉트 
	if( req.getSession().getAttribute("login") == null ) {
		resp.sendRedirect("/member/login");
				
				return;
			}
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/review/write.jsp")
					.forward(req, resp);
	}		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//인코딩
		req.setCharacterEncoding("UTF-8");

		Seoul upso_sno = detailService.getupso_sno(req);
		System.out.println("컨트롤러 upso_sno"+upso_sno);
		//작성글 삽입
		req.setAttribute("upso_sno", upso_sno);
		reviewService.write(req, upso_sno);
					
		//목록으로 리다이렉션
		resp.sendRedirect("/review/info");
	}
				
	
}
