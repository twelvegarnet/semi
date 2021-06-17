package controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Notice;
import dto.NoticeFile;
import service.face.AdminNoticeService;
import service.impl.AdminNoticeServiceImpl;

/**
 * Servlet implementation class AdminNoticeUpdateController
 */
@WebServlet("/admin/noticeupdate")
public class AdminNoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminNoticeService adminNoticeService = new AdminNoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/noticeupdate [get]");
		
		Object postno1 = req.getParameter("postno");
		
		Integer postno = Integer.parseInt((String)postno1);   
		
		System.out.println("ddddd");
		
		//int postno
		Notice notice = adminNoticeService.view(postno);
		
		NoticeFile noticeFile = adminNoticeService.viewFile(postno);
		
		req.setAttribute("Notice", notice);
		
		req.setAttribute("NoticeFile", noticeFile);
		
		req.setAttribute("Postno", postno);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/admin_noticeupdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/noticeupdate [post]");
		
		adminNoticeService.update(req);
		
		resp.sendRedirect("/admin/noticelist");
		
		
	}
}
