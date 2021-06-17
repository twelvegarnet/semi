package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Inquiry;
import inquiry.util.Paging;
import service.face.InquiryService;
import service.impl.InquiryServiceImpl;

@WebServlet("/mypage/inqlist")
public class InquiryListPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//InquiryService 객체 생성
	InquiryService inquiryService = new InquiryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/inqlist [GET]");
		
		Paging paging = inquiryService.getPaging(req);
		System.out.println("BoardListController - " + paging);
		
		//문의목록 조회
//		List<Inquiry> inquiryList = inquiryService.getInqList();
		
		//페이징 적용한 문의목록 조회
		List<Inquiry> inquiryList = inquiryService.getInqList(paging, req);
		
		
		//paging객체 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//조회결과 MODEL값 전달
		req.setAttribute("inquiryList", inquiryList);
		
		
		Inquiry inquiryno = inquiryService.getInquiryno(req);
		Inquiry viewInquiry = inquiryService.viewInq(inquiryno);
		req.setAttribute("nick", inquiryService.getNick(viewInquiry));
		
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/mypage/inquirylist.jsp").forward(req, resp);
	
	
		
	}

}
