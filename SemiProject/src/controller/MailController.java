package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.face.EmailService;
import service.face.MemberService;
import service.impl.EmailServiceImpl;
import service.impl.MemberServiceImpl;
import util.getTempPassword;

@WebServlet("/send")
public class MailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmailService emailService = new EmailServiceImpl();
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/send [GET]");
		
		System.out.println(req.getParameter("userid"));
		System.out.println(req.getParameter("email"));
		
		//랜덤 비밀번호 가져오기
		getTempPassword pw = new getTempPassword();
		String tempPW = pw.randomPassword(10);
		System.out.println(tempPW);
		// 이메일, 유저 아이디, 임시 비밀번호 객체 저장
		Member member = memberService.saveEmail(req,tempPW);
		
		System.out.println(member);
		//업데이트
		memberService.chagePW(member);
		
		
		
		// 메일보내기
		emailService.send(member);
		
		
		
		
	}
}
