package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Faq;
import service.face.FaqService;
import service.impl.FaqServiceImpl;


@WebServlet("/admin/faqlist")
public class AdminFaqListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FaqService faqService = new FaqServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get");
	
		List<Faq> faqlist = faqService.faqlist();
		
		req.setAttribute("faqlist", faqlist);
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/admin/admin_faqlist.jsp").forward(req, resp);
	
	}
	
}
