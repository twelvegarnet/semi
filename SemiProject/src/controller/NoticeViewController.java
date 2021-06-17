package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Notice;
import service.face.NoticeService;
import service.impl.NoticeServiceImpl;

@WebServlet("/notice/view")
public class NoticeViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoticeService noticeService = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/notice/view [get]");
		
		//전달 파라미터 얻기 - postno 
		Notice postno = noticeService.getPostno(req);
		
		int post = postno.getPostno();
		
		//상세보기 결과 조회   
		Notice viewNotice = noticeService.view(post);
		System.out.println(viewNotice.getHit());
		
		//조회결과 MODEL값 전달    
		req.setAttribute("viewNotice", viewNotice); // jsp로 데이터 전달
		
		//VIEW 지정 및 응답   
		req.getRequestDispatcher("/WEB-INF/views/board/notice/view.jsp").forward(req, resp);
	}
	
	
}
