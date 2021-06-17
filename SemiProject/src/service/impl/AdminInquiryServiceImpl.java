package service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.AdminInquiryDao;
import dao.impl.AdminInquiryDaoImpl;
import dto.Inquiry;
import dto.InquiryAnswer;
import inquiry.util.Paging;
import service.face.AdminInquiryService;

public class AdminInquiryServiceImpl implements AdminInquiryService {
	
	//InquiryDao 객체 생성
	private AdminInquiryDao adminInquiryDao = new AdminInquiryDaoImpl();

	@Override
	public List<Inquiry> getInqList() {
		return adminInquiryDao.selectAllInqList(JDBCTemplate.getConnection());
	}

	@Override
	public List<Inquiry> getInqList(Paging paging) {
		return adminInquiryDao.selectAllInqList(JDBCTemplate.getConnection(), paging);
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//Board 테이블의 총 게시글 수 조회
		int totalCount = adminInquiryDao.selectCntAllInq(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	
	@Override
	public Inquiry getInquiryno(HttpServletRequest req) {
		
		//inquiryno 저장할 객체
		Inquiry inquiryno = new Inquiry();
		
		//inquiryno 전달파라미터 검증
		String param = req.getParameter("inquiryno");
		
		if (param != null && !"".equals(param)) {
			inquiryno.setInquiryno(Integer.parseInt(param));
		}
		
		//TEST 4)))
		System.out.println("inquiryno: " + inquiryno);
		return inquiryno;
	}

	
	@Override
	public Inquiry viewInq(Inquiry inquiryno) {
		return adminInquiryDao.selectInqByInquiryno(JDBCTemplate.getConnection(), inquiryno);
	}

	
	@Override
	public String getNick(Inquiry viewInquiry) {
		return adminInquiryDao.selectNickByUserno(JDBCTemplate.getConnection(), viewInquiry);
	}

	
	@Override
	public void writeAnswer(HttpServletRequest req) {
		
		InquiryAnswer answer = new InquiryAnswer();
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		answer.setInquiryno(Integer.parseInt(req.getParameter("inquiryno")));
		answer.setUserno((int)req.getSession().getAttribute("userno"));
		answer.setAnswercontent(req.getParameter("answercontent"));
		System.out.println("answer: " + answer);
		
		if (req.getParameter("answercontent") != null && !"".equals(req.getParameter("answercontent"))) {
			answer.setAnswercontent(req.getParameter("answercontent"));
		}
		
		Connection conn = JDBCTemplate.getConnection();
		if (adminInquiryDao.insertAnswer(conn, answer) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

	
	@Override
	public int cntAns(Inquiry inquiryno) {
		return adminInquiryDao.selectCntAllAns(JDBCTemplate.getConnection(), inquiryno);
	}
	
	
	@Override
	public void deleteInq(Inquiry inquiry) {
		Connection conn = JDBCTemplate.getConnection();
		
		if(adminInquiryDao.deleteInq(conn, inquiry) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}




}
