package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.face.MemberService;
import service.impl.MemberServiceImpl;

/**
 * Servlet implementation class LoginFindPwController
 */
@WebServlet("/member/find/loginPw")
public class LoginFindPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/find/loginPw [GET]");

		req.getRequestDispatcher("/WEB-INF/views/member/findMemberPw.jsp").forward(req, resp);






	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/find/loginPw [POST]");
		
		resp.setContentType("text/html;charset=UTF-8");
		// 한글 인코딩 처리
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Member member = memberService.findPw(req);
		
		System.out.println(member);
		req.setAttribute("member", member);
		req.getRequestDispatcher("/WEB-INF/views/member/findMemberPwResult.jsp").forward(req, resp);
		
	
	}
}
