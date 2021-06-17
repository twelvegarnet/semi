package service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.FaqDao;
import dao.impl.FaqDaoImpl;
import dto.Faq;
import service.face.FaqService;

public class FaqServiceImpl implements FaqService {

	private FaqDao faqDao = new FaqDaoImpl();
	private Connection conn = JDBCTemplate.getConnection();

	@Override
	public List<Faq> View() {

		return faqDao.getData(conn);
	}

	@Override
	public void FaqWrite(HttpServletRequest req) {

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Faq write = new Faq();

		write.setTitle( req.getParameter("title") );
		write.setInq_content( req.getParameter("content") );

		Connection conn = JDBCTemplate.getConnection();
		if( faqDao.insert(conn, write) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

	@Override
	public List<Faq> faqlist() {
		return faqDao.selectFAQList(JDBCTemplate.getConnection());
	}

	@Override
	public Faq getPostno(HttpServletRequest req) {

		Faq postno = new Faq();

		String param = req.getParameter("postno");

		if(param!=null && !"".equals(param)) {

			postno.setPostno( Integer.parseInt(param) );
		}

		return postno;

	}

	@Override
	public Faq adminView(Faq postno) {
		return faqDao.selectFAQView(JDBCTemplate.getConnection() , postno);
	}

	@Override
	public void faqDelete(Faq faq) {

		Connection conn = JDBCTemplate.getConnection();
		if( faqDao.delete(conn, faq) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

	}


	public void FaqUpdate(HttpServletRequest req) {

		Connection conn = JDBCTemplate.getConnection();


		Faq faq = new Faq();

		faq.setPostno(Integer.parseInt(req.getParameter("postno")));
		faq.setTitle(req.getParameter("title"));
		faq.setInq_content(req.getParameter("content"));

		System.out.println("dao faq - " + faq);
		
		if( faqDao.update(conn, faq) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

	@Override
	public Faq getFaqByPostno(HttpServletRequest req) {

		Connection conn = JDBCTemplate.getConnection();

		int postno = Integer.parseInt(req.getParameter("postno"));
		
		return faqDao.getFaqByPostno(conn, postno);
	}

}
