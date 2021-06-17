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

@WebServlet("/admin/faqupdate")
public class AdminFaqUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FaqService faqService = new FaqServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("update - get");
		
		Faq faq = faqService.getFaqByPostno(req);
		System.out.println("controller faq - " + faq);
		req.setAttribute("faq", faq);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/admin_faqupdate.jsp").forward(req, resp);
	
	}
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("post");
			req.setCharacterEncoding("UTF-8");
	
			System.out.println(req.getParameter("postno"));
			System.out.println(req.getParameter("title"));
		
			faqService.FaqUpdate(req);
			
			resp.sendRedirect("/admin/faqlist");
			
		}
	
}
