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
 * Servlet implementation class JoinPageController
 */
@WebServlet("/member/join")
public class JoinPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/join [GET]");
		// 회원가입폼으로
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/join [POST]");

		resp.setContentType("text/html;charset=UTF-8");
		// 한글 인코딩 처리
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(req.getParameter("year"));


		// 회원가입 정보 저장
		Member member = memberService.getJoinMember(req);
		// [TEST]
//		System.out.println(member);
		
		memberService.join(member);
		

		req.getRequestDispatcher("/WEB-INF/views/member/joinsuccess.jsp").forward(req, resp);

	}

}
