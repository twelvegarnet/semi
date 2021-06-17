package controller;

import java.io.IOException;

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
 * Servlet implementation class AdminNoticeDeleteController
 */
@WebServlet("/admin/noticeDelete")
public class AdminNoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminNoticeService adminNoticeService = new AdminNoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/noticeDelete [get]");
		
		adminNoticeService.deleteNotice(req);
		
		
		resp.sendRedirect("/admin/noticelist");
		
	}

}
