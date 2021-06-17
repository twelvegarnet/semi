package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import inquiry.util.Paging;
import service.face.AdminMemberService;
import service.impl.AdminMemberServiceImpl;

@WebServlet("/admin/member")
public class AdminMemberManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminMemberService adminMemberService = new AdminMemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/member [GET]");
		
		List<Member> memList = adminMemberService.getMemList();
		
		Member member = adminMemberService.getUserno(req);
		
		adminMemberService.deleteMem(member);
		
		
		req.setAttribute("memList", memList);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/admin_memberManagement.jsp").forward(req, resp);
	}
}
