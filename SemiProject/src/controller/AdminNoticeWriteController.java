package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.face.AdminNoticeService;
import service.impl.AdminNoticeServiceImpl;

/**
 * Servlet implementation class AdminNoticeWrite
 */
@WebServlet("/admin/noticewrite")
public class AdminNoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminNoticeService adminNoticeService = new AdminNoticeServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/noticewrite [get]");
		
		if( req.getSession().getAttribute("login") == null ) {
			resp.sendRedirect("/memeber/login");
			
			return;
		}

		req.getRequestDispatcher("/WEB-INF/views/admin/admin_noticewrite.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/noticewrite [post]");
//		System.out.println(req.getParameter(null));
		
		
		
//		if( login ) {
//			
//			HttpSession session = req.getSession();
			System.out.println("requestget : " +req.getParameter("title"));
//			session.setAttribute("login", login);
			adminNoticeService.write(req);
//			
//		}
		
		resp.sendRedirect("/admin/noticelist");
	}
	
}
