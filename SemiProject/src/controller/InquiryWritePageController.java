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

@WebServlet("/mypage/inqwrite")
public class InquiryWritePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	InquiryService inquiryService = new InquiryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/inqwrite [GET]");
		
		Inquiry write = new Inquiry();
		
		write = inquiryService.getInquiryno(req);
		
		req.setAttribute("write", write);

		req.getRequestDispatcher("/WEB-INF/views/mypage/inquirywrite.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/inqwrite [POST]");

		inquiryService.writeInq(req);
		
		resp.sendRedirect("/mypage/inqlist");

	}

}
