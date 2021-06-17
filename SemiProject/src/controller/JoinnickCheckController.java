package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.face.MemberService;
import service.impl.MemberServiceImpl;

/**
 * Servlet implementation class JoinnickCheckController
 */
@WebServlet("/join/nickcheck")
public class JoinnickCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/join/nickcheck [POST]");
		int cnt = 0;
		if(req.getParameter("nick") == "" || req.getParameter("nick") == null) {
			cnt = 2;
		} else {
			// 닉네임 중복검사
			cnt = memberService.nickcheck(req.getParameter("nick"));
		}

		System.out.println(cnt);
		
		//타입을 json으로 바꿔줘야됨
		Gson gson = new Gson();

		String res = gson.toJson(cnt);
		// ajax로 리턴해줌
		resp.getWriter().write(res);


	}
}
