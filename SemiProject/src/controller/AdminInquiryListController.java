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
import inquiry.util.Paging;
import service.face.AdminInquiryService;
import service.impl.AdminInquiryServiceImpl;

@WebServlet("/admin/inqlist")
public class AdminInquiryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//AdminInquiryService 객체 생성
	AdminInquiryService adminInquiryService = new AdminInquiryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/inqlist [GET]");
		
		Paging paging = adminInquiryService.getPaging(req);
		System.out.println("BoardListController - " + paging);
		
		//문의목록 조회
//		List<Inquiry> inquiryList = inquiryService.getInqList();
		
		//페이징 적용한 문의목록 조회
		List<Inquiry> inquiryList = adminInquiryService.getInqList(paging);
		
		
		//paging객체 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//조회결과 MODEL값 전달
		req.setAttribute("inquiryList", inquiryList);
		
		
		Inquiry inquiryno = adminInquiryService.getInquiryno(req);
		Inquiry viewInquiry = adminInquiryService.viewInq(inquiryno);
		req.setAttribute("nick", adminInquiryService.getNick(viewInquiry));
		
		
		req.getRequestDispatcher("/WEB-INF/views/admin/admin_inqlist.jsp").forward(req, resp);
	}

}
