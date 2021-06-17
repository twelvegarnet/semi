package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.face.AdminMemberService;
import service.impl.AdminMemberServiceImpl;

@WebServlet("/admin/memberdel")
public class AdminMemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminMemberService adminMemberService = new AdminMemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/memberdel [GET]");
		
		Member member = adminMemberService.getUserno(req);
		
		adminMemberService.deleteMem(member);
		
		resp.sendRedirect("/admin/member");
	
	}
}
