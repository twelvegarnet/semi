package service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import common.JDBCTemplate;
import dao.face.InquiryDao;
import dao.impl.InquiryDaoImpl;
import dto.Inquiry;
import dto.InquiryAnswer;
import dto.InquiryFile;
import inquiry.util.Paging;
import service.face.InquiryService;

public class InquiryServiceImpl implements InquiryService {
	
	//InquiryDao 객체 생성
	private InquiryDao inquiryDao = new InquiryDaoImpl();

	@Override
	public List<Inquiry> getInqList() {
		return inquiryDao.selectAllInqList(JDBCTemplate.getConnection());
	}

	@Override
	public List<Inquiry> getInqList(Paging paging, HttpServletRequest req) {
		
		int userno = (int)req.getSession().getAttribute("userno");
		
		return inquiryDao.selectAllInqList(JDBCTemplate.getConnection(), paging, userno);
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
		int totalCount = inquiryDao.selectCntAllInq(JDBCTemplate.getConnection());
		
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
		//TEST 3)))
//		System.out.println("param: " + param);
		
		if (param != null && !"".equals(param)) {
			inquiryno.setInquiryno(Integer.parseInt(param));
		}
		
		//TEST 4)))
		System.out.println("inquiryno: " + inquiryno);
		return inquiryno;
	}

	
	@Override
	public Inquiry viewInq(Inquiry inquiryno) {
		return inquiryDao.selectInqByInquiryno(JDBCTemplate.getConnection(), inquiryno);
	}

	
	@Override
	public String getNick(Inquiry viewInquiry) {
		return inquiryDao.selectNickByUserno(JDBCTemplate.getConnection(), viewInquiry);
	}
	
	
	@Override
	public void writeInq(HttpServletRequest req) {
		
		Inquiry inquiry = new Inquiry();
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		inquiry.setInqsort(req.getParameter("inqsort"));
		inquiry.setTitle(req.getParameter("title"));
		inquiry.setInqcontent(req.getParameter("content"));
		inquiry.setUserno((int)req.getSession().getAttribute("userno"));
		
		
		//작성자 번호 처리
//		inquiry.setUserno((int) req.getSession().getAttribute("userno"));
		
		//title이 null이거나 빈칸일 때 처리
		if (inquiry.getTitle() == null || "".equals(inquiry.getTitle())) {
			inquiry.setTitle("(제목 없음)");
		}
		
		Connection conn = JDBCTemplate.getConnection();
		if (inquiryDao.insertInq(conn, inquiry) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	
	
	@Override
	public List<InquiryAnswer> getAnsList(Inquiry inquiryno) {
		return inquiryDao.selectAllAnsList(JDBCTemplate.getConnection(), inquiryno);
	}
	
	
	@Override
	public int cntAns(Inquiry inquiryno) {
		return inquiryDao.selectCntAllAns(JDBCTemplate.getConnection(), inquiryno);
	}

	
	@Override
	public void deleteInq(Inquiry inquiry) {
		Connection conn = JDBCTemplate.getConnection();
		
		if(inquiryDao.deleteInq(conn, inquiry) > 0) {
			JDBCTemplate.commit(conn);;
		} else {
			JDBCTemplate.rollback(conn);
		}
	}


}
