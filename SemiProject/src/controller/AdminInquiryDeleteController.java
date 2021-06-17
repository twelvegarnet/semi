package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Inquiry;
import service.face.AdminInquiryService;
import service.impl.AdminInquiryServiceImpl;

@WebServlet("/admin/inqdelete")
public class AdminInquiryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminInquiryService adminInquiryService = new AdminInquiryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/inqdelete [GET]");
		
		Inquiry inquiry = adminInquiryService.getInquiryno(req);
		
		adminInquiryService.deleteInq(inquiry);
	
		resp.sendRedirect("/admin/inqlist");
	}
}
