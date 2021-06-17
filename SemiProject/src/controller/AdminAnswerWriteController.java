package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.AdminInquiryService;
import service.impl.AdminInquiryServiceImpl;

@WebServlet("/admin/inqanswer")
public class AdminAnswerWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminInquiryService adminInquiryService = new AdminInquiryServiceImpl();

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/inqanswer [POST]");
		
		adminInquiryService.writeAnswer(req);
		
		resp.sendRedirect("/admin/inqlist");
	}
}
