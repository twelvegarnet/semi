package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Faq;
import service.face.FaqService;
import service.impl.FaqServiceImpl;

@WebServlet("/admin/faqdelete")
public class AdminFaqDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FaqService faqService = new FaqServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Faq faq = faqService.getPostno(req);
		
		faqService.faqDelete(faq);
		
		resp.sendRedirect("/admin/faqlist");
		
	}
	
	
	
	
	
	
	
	
}
