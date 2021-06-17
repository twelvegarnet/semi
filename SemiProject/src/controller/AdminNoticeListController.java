package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import dto.Notice;
import service.face.AdminNoticeService;
import service.impl.AdminNoticeServiceImpl;

/**
 * Servlet implementation class AdminNoticeListController
 */
@WebServlet("/admin/noticelist")
public class AdminNoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminNoticeService adminNoticeService = new AdminNoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/noticelist [get]");
		
		Paging paging = adminNoticeService.getPaging(req);
		
		
//		List<Notice> noticeList = noticeService.getList();
		
		List<Notice> noticeList = adminNoticeService.getList(paging);
		
		req.setAttribute("paging", paging);
		
		req.setAttribute( "noticeList", noticeList);
		
		
		req.getRequestDispatcher("/WEB-INF/views/admin/admin_noticelist.jsp").forward(req, resp);
	}
}
