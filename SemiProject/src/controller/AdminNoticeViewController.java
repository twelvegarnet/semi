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
 * Servlet implementation class AdminNoticeViewController
 */
@WebServlet("/admin/noticeview")
public class AdminNoticeViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminNoticeService adminNoticeService = new AdminNoticeServiceImpl(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/notice/view [get]");
		
		//전달 파라미터 얻기 - postno 
		Notice postno = adminNoticeService.getPostno(req);
		
		int post = postno.getPostno();
		
		//상세보기 결과 조회   
		Notice viewNotice = adminNoticeService.view(post);
		System.out.println(viewNotice.getHit());
		
		//
		NoticeFile noticeFile = adminNoticeService.viewFile(post);
		System.out.println("noticeFIle : " + noticeFile.getFileno());
		
		System.out.println("NoticeFile 확인하기 : " + noticeFile);
		System.out.println("오리진네임 : " + noticeFile.getOriginName());
		System.out.println("스토어네임 : " + noticeFile.getStoredName());
		//조회결과 MODEL값 전달    
		req.setAttribute("viewNotice", viewNotice); // jsp로 데이터 전달
		
		req.setAttribute("noticeFile", noticeFile);
		
		//VIEW 지정 및 응답   
		req.getRequestDispatcher("/WEB-INF/views/admin/admin_noticeview.jsp").forward(req, resp);
	}
	
}
