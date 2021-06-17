package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Payment;
import service.face.MemberService;
import service.impl.MemberServiceImpl;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/paymentResult")
public class PaymentResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		System.out.println("/payment [GET]");
		
		HttpSession session = req.getSession();
		
		Payment payment = new Payment();
		payment.setAmt(req.getParameter("paid_amount"));
		payment.setUserid((String)session.getAttribute("userid"));
		//payment.setUserNo(10);
		payment.setPaymentUid(req.getParameter("imp_ui"));
		payment.setMerchant_uid(req.getParameter("merchant_uid"));
		
		memberService.insertPayment(payment);
		
		memberService.updateMember(payment);
		
		req.getRequestDispatcher("/WEB-INF/views/payment/paymentResult.jsp").forward(req, resp);
	}
}
