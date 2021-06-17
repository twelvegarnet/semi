package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Inquiry;
import dto.InquiryAnswer;
import inquiry.util.Paging;

public interface AdminInquiryDao {
	
	/**
	 * Inquiry 테이블 전체 조회하기
	 *   (페이징 없음)
	 * 
	 * @param connection - DB연결 객체
	 * @return List<Inquiry> - Inquiry 테이블 전체 조회 결과 리스트
	 */
	public List<Inquiry> selectAllInqList(Connection conn);

	
	/**
	 * Inquiry 테이블 전체 조회하기
	 * 	 페이징 처리
	 * 
	 * @param connection - DB연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Inquiry> - Inquiry 테이블 전체 조회 결과 리스트
	 */
	public List<Inquiry> selectAllInqList(Connection conn, Paging paging);


	/**
	 * 총 게시글 수 조회
	 * 
	 * @param connection - DB연결 객체
	 * @return 총 게시글 수
	 */
	public int selectCntAllInq(Connection conn);


	/**
	 * inquiryno를 통한 게시글 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param inquiryno - 해당 inquiryno를 가진 객체
	 * @return Inquiry - 조회된 결과 객체
	 */
	public Inquiry selectInqByInquiryno(Connection conn, Inquiry inquiryno);

	
	/**
	 * userno를 이용해 nick을 조회한다
	 * 
	 * @param conn - DB연결 객체
	 * @param writeInquiry - 조회할 userno를 가진 객체
	 * @return String - 작성자 닉네임
	 */
	public String selectNickByUserno(Connection conn, Inquiry viewInquiry);


	/**
	 * 문의에 대한 답변 삽입하기
	 * 
	 * @param conn - DB연결 객체
	 * @param answer - 삽입되는 답변 내용
	 */
	public int insertAnswer(Connection conn, InquiryAnswer answer);


	/**
	 * 문의에 대한 답변 개수 가져오기
	 * @param inquiryno 
	 * 
	 * @param connection - DB연결 객체
	 * @return int - 해당 문의에 대한 답변 개수
	 */
	public int selectCntAllAns(Connection conn, Inquiry inquiryno);

	
	/**
	 * 문의글 삭제하기
	 * 
	 * @param conn - DB연결 객체
	 * @param inquiry - 삭제할 문의번호를 가지고 있는 객체
	 */
	public int deleteInq(Connection conn, Inquiry inquiry);



}
