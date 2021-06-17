package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Inquiry;
import dto.InquiryAnswer;
import inquiry.util.Paging;

public interface AdminInquiryService {

	/**
	 * 문의내역 전체 조회하기
	 * 	 (페이징 없음)
	 * 
	 * @return List<Inquiry> - 문의내역 전체 조회 결과 리스트
	 */
	public List<Inquiry> getInqList();

	
	/**
	 * 문의내역 전체 조회하기
	 * 	 페이징 처리
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Inquiry> - 문의내역 전체 조회 결과 리스트
	 */
	public List<Inquiry> getInqList(Paging paging);


	/**
	 * 페이징 객체 생성
	 * 
	 * 요청파라미터 curPage를 구한다
	 * Inquiry테이블과 curPage값을 이용해 Paging 객체를 생성한다
	 * 
	 * @param req - curPage정보를 담고 있는 요청정보 객체
	 * @return Paging - 페이징 계산이 완료된 Paging 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	
	/**
	 * 요청파라미터 얻기
	 * 
	 * @param req - 요청 정보 객체
	 * @return Inquiry - 전달파라미터 inquiryno를 포함한 객체
	 */
	public Inquiry getInquiryno(HttpServletRequest req);


	/**
	 * 주어진 inquiryno를 이용해 게시글 조회하기
	 * 
	 * @param inquiryno - inquiryno를 가지고 있는 객체
	 * @return Inquiry - 조회된 문의글
	 */
	public Inquiry viewInq(Inquiry inquiryno);


	/**
	 * Inquiry객체의 userno를 이용한 닉네임 조회
	 * 
	 * @param writeInquiry
	 * @return String - 게시글 작성자의 닉네임
	 */
	public String getNick(Inquiry viewInquiry);


	/**
	 * 문의사항에 대한 답변 작성하기
	 *  입력한 내용을 DB에 저장
	 * 
	 * @param req - 요청정보 객체(답변을 추가할 해당 게시글)
	 */
	public void writeAnswer(HttpServletRequest req);


	/**
	 * 문의사항 답변 수 조회
	 * 
	 * @param inquiryno - inquiryno로 조회될 객체
	 * @return int - 조회된 답변 수
	 */
	public int cntAns(Inquiry inquiryno);
	
	
	/**
	 * 문의글 삭제하기
	 * 
	 * @param inquiry - 삭제할 문의번호(inquiryno)를 가진 객체
	 */
	public void deleteInq(Inquiry inquiry);




}
