package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Inquiry;
import service.face.InquiryService;
import service.impl.InquiryServiceImpl;

@WebServlet("/mypage/inqdelete")
public class InquiryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InquiryService inquiryService = new InquiryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/delete [GET]");
		
		Inquiry inquiry = inquiryService.getInquiryno(req);
		
		inquiryService.deleteInq(inquiry);
		
		resp.sendRedirect("/mypage/inqlist");
	
	}

}
