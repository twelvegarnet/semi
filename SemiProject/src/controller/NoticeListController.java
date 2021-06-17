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
import service.face.NoticeService;
import service.impl.NoticeServiceImpl;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoticeService noticeService = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/notice/list [get]");

		Paging paging = noticeService.getPaging(req);
		
		
//		List<Notice> noticeList = noticeService.getList();
		
		List<Notice> noticeList = noticeService.getList(paging);
		
		req.setAttribute("paging", paging);
		
		req.setAttribute( "noticeList", noticeList);
		
//		System.out.println("noticeList : " + noticeList);
		req.getRequestDispatcher("/WEB-INF/views/board/notice/list.jsp").forward(req, resp);
	}
	
	
}
