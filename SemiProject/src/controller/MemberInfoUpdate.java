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
 * Servlet implementation class MemberInfoUpdate
 */
@WebServlet("/member/update")
public class MemberInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/member/update [POST]");
		
		resp.setContentType("text/html;charset=UTF-8");
		// 한글 인코딩 처리
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Member member = memberService.getUpdateMember(req);
		
		System.out.println(member);
		
		
		memberService.updateMemberInfo(member);
		
		
		resp.sendRedirect("/member/chg");
		
		
//		System.out.println(member);
		
		
		
		
		
		
	}



}
