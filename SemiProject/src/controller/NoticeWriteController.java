package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.NoticeService;
import service.impl.NoticeServiceImpl;

@WebServlet("/notice/write")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoticeService noticeService = new NoticeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/notice/write [get]");
		
		//로그인 되어 있지 않으면 리다이렉
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/");
			
			return;
		}
		
		//view 지정
		req.getRequestDispatcher("/WEB-INF/views/board/notice/write.jsp").forward(req, resp);
	}

	
	
	
}
