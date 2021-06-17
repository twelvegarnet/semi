package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Inquiry;
import dto.InquiryAnswer;
import service.face.AdminInquiryService;
import service.impl.AdminInquiryServiceImpl;

@WebServlet("/admin/inqview")
public class AdminInquiryViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminInquiryService adminInquiryService = new AdminInquiryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/inqview [GET]");
		
		//전달파라미터 얻기 - inquiryno
		Inquiry inquiryno = adminInquiryService.getInquiryno(req);
		
		//상세보기 결과 조회
		Inquiry viewInquiry = adminInquiryService.viewInq(inquiryno);
		
		//문의 답변 개수 조회
		int cntAnswer = adminInquiryService.cntAns(inquiryno);
		
		
		//닉네임 전달
		req.setAttribute("nick", adminInquiryService.getNick(viewInquiry));
		
		req.setAttribute("viewInquiry", viewInquiry);
		
		req.setAttribute("cntAnswer", cntAnswer);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/admin_inqview.jsp").forward(req, resp);

	
	}

}
