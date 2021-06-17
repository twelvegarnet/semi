package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;
import service.face.MemberService;
import service.impl.MemberServiceImpl;

/**
 * Servlet implementation class LoginPageController
 */
@WebServlet("/member/login")
public class LoginPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TEST
		System.out.println("/login [GET]");

		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);




	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TEST
//		System.out.println("/login [POST]");

		// TEST
		//		System.out.println(req.getParameter("userid"));
		//		System.out.println(req.getParameter("userpw"));

		// 로그인 정보 저장

		Member member = memberService.getLoginMember(req);
		
//		System.out.println(member);
		// 로그인 인증
		boolean login = false;
		login = memberService.login(member);
		
		if(login) {
			member = memberService.info(member);
			// 세션정보 저장하기
			
			System.out.println("!!!!!!!!!!!!!!!");
			HttpSession session = req.getSession();
			session.setAttribute("login", login);
			session.setAttribute("userid", member.getUserid());
			session.setAttribute("usernick", member.getNick());
			session.setAttribute("userno", member.getUserno());
			session.setAttribute("grade", member.getGrade());
			System.out.println(session.getAttribute("grade"));
			
			//메인페이지로
			resp.sendRedirect("/");
		} else {
			System.out.println(member);
			System.out.println("로그인 실패");
			
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('아이디 또는 비밀번호를 확인해주세요'); location.href='/member/login';</script>");
			
			out.flush();
			
//			resp.sendRedirect("/member/login");
		}

		
		
		
		
		


	}



}
