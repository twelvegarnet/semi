package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Faq;

public interface FaqService {

	/**
	 * FAQ 회원일때 보여지는 페이지 
	 */
	public List<Faq> View();
	
	/**
	 * FAQ 관라자 페이지에서 목록조회  
	 */
	public List<Faq> faqlist();
	
	/**
	 * FAQ 관리자 페이지에서 상세페이지 조회할때 게시글번호 가져오기 
	 */
	public Faq getPostno(HttpServletRequest req);
	
	/**
	 * FAQ 관리자 페이지에서 상세페이지 보여주기  
	 */
	public Faq adminView(Faq postno);

	/**
	 * FAQ 관리자 페이지에서 글작성 
	 */
	public void FaqWrite(HttpServletRequest req);
	
	/**
	 * FAQ 관리자 페이지에서 글수정
	 */
	public void FaqUpdate(HttpServletRequest req);

	/**
	 * FAQ 관리자 페이지에서 글삭제
	 */
	public void faqDelete(Faq faq);

	/**
	 * postno가 일치하는 faq 전체 데이터 가져오기
	 */
	public Faq getFaqByPostno(HttpServletRequest req);

	
}
