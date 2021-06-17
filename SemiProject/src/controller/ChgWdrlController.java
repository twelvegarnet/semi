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
 * Servlet implementation class ChgWdrlController
 */
@WebServlet("/member/chg")
public class ChgWdrlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	MemberService memberService = new MemberServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/member/chg [GET]");

		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("userid"));
		Member member = memberService.saveLoinId(session.getAttribute("userid"));
		
//		Member member = memberService.saveLoinId();
		
		
		Member info = memberService.getuserInfo(member);
		System.out.println(req.getParameter("check"));
		
		req.setAttribute("info", info);
		
		
		
		if(req.getParameter("check") == null) {
			req.getRequestDispatcher("/WEB-INF/views/member/changeWithdrawal.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(req, resp);
		}
		
		
		
		
		
		
		
		
		
	}

}
