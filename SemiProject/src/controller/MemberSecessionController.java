package controller;

import java.io.IOException;

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
 * Servlet implementation class MemberSecessionController
 */
@WebServlet("/member/secession")
public class MemberSecessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	MemberService memberService = new  MemberServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/secession [POST]");


		memberService.secession(req.getSession().getAttribute("userno"));

		//세션 객체
		HttpSession session = req.getSession();

		//세션 삭제 - 로그아웃
		session.invalidate();

		//메인화면으로 리다이렉트
		resp.sendRedirect("/");
		

	}
}
