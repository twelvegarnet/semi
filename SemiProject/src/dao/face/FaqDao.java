package dao.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Faq;

public interface FaqDao {

	/**
	 * 게시판 - FAQ 회원일때 문의제목과 답변내용이 보여지는 페이지 
	 */
	public List<Faq> getData(Connection conn);

	/**
	 * 게시판 - FAQ 관리자일때 데이터들이 보여지는 목록페이지 
	 */
	public List<Faq> selectFAQList(Connection conn);

	/**
	 * 게시판 - FAQ 관리자일때 데이터들이 보여지는 상세페이지 
	 */
	public Faq selectFAQView(Connection conn, Faq postno);

	/**
	 * 게시판 - FAQ 관리자가 글작성하는 페이지 
	 */
	public int insert(Connection conn, Faq write);
	
	/**
	 * 게시판 - FAQ 관리자가 글수정하는 페이지 
	 */
	public int update(Connection conn, Faq faq);

	/**
	 * 게시판 - FAQ 관리자가 글삭제하는 페이지 
	 */
	public int delete(Connection conn, Faq faq);

	/**
	 * postno와 일치하는 faq 전체데이터 가져오기
	 */
	public Faq getFaqByPostno(Connection conn, int postno);


}
