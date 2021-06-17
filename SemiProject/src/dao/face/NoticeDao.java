package dao.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.Notice;
import dto.NoticeFile;

public interface NoticeDao {

	/**
	 * Notice 테이블 전체 조회 
	 * 
	 * @param conn
	 * @return List<Notice> - Notice테이블 전체 조회 결과리스트 
	 */
	public List<Notice> selectAll(Connection conn);
	
	/**
	 * Notice 테이블 전체 조회  
	 *  페이징 처리 추가   
	 * 
	 * @param conn - 페이징 정보 객체   
	 * @return - paging - Notice테이블 전체 조회 결과 리스트  
	 */
	public List<Notice> selectAll(Connection conn, Paging paging);

	/**
	 * 조회된 게시글의 조회수 증가   
	 * 
	 * @param postno 조회된 게시글 번호를 가진 객체   
	 */
	public int updateHit(Connection conn, int post);

	
	/**
	 * 
	 * 
	 * @param conn
	 * @param postno
	 * @return
	 */
	public Notice selectNoticeByPostno(Connection conn, int post);

	
	
	public int selectCntAll(Connection conn);

	
	/**
	 * 다음 게시글 번호 반환
	 * 게시글 테이블과 첨부파일 테이블에 입력될 게시글번호를 시퀀스를 통해 추출한다
	 * 
	 * @return - 다음 게시글 번호
	 */
	public int selectPostno(Connection conn);

	
	/**
	 * 게시글 입력
	 * 
	 * 
	 * @param conn
	 * @param adminNotice
	 * @return
	 */
	public int insert(Connection conn, Notice adminNotice);

	
	/**
	 * 게시글에 첨부파일 입력
	 * 
	 * @param noticeFile - 업로드 된 첨부파일 정보 객체
	 * @return
	 */
	public int insertFile(Connection conn, NoticeFile noticeFile);

	
	
	public NoticeFile selectFileByPostno(Connection conn, int post);

	
	
	/**
	 * 게시글에 파일 삭제
	 * 
	 * @param conn
	 * @param req
	 * @return
	 */
	public int deleteNoticeFile(Connection conn, HttpServletRequest req);

	
	/**
	 * 게시글 삭제
	 * 
	 * @param conn
	 * @param req
	 * @return
	 */
	public int deleteNotice(Connection conn, HttpServletRequest req);

	
	public int update(Connection conn, Notice adminNotice);

	
	public int updateFile(Connection conn, NoticeFile noticeFile);
	



	
	
}
