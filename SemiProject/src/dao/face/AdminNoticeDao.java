package dao.face;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import dto.Notice;

public interface AdminNoticeDao {

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
	

	public int update(Connection conn, Notice adminNotice);


	
	
}
