package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.Notice;
import dto.NoticeFile;

public interface AdminNoticeService {

	/**
	 * 공지사항 리스트 전체 조회.
	 * 
	 * @return 공지사항 전체 조회 결과 리스트.
	 */
	public List<Notice> getList();

	/**
	 * 게시글 전체 조회
	 * 페이징 처리 추가    
	 * 
	 * @param paging - 페이징 정보 객체    
	 * @return List<Notice> - 게시글 전체 조회 결과 리스트  
	 */
	public List<Notice> getList(Paging paging);
	
	
	/**
	 * 요청파라미터 얻기  
	 *
	 * @param 요청정보 객체   
	 * @return Notice 전달파라미터 postno를 포함한 객체   
	 */
	public Notice getPostno(HttpServletRequest req);

	/**
	 * 주어진 postno를 이용하여 상세페이지를 조회한다  
	 * 조회된 게시글의 조회수를 증가시킨다  
	 * 
	 * @param postno
	 * @return
	 */
	public Notice view(int post);

	
	/**
	 * 페이징 객체 생
	 * 
	 * @param req - curPage정보를 담고있는 요청정보 객
	 * @return 페이징 계산이 완료된 Paging객체를 생성한
	 */
	public Paging getPaging(HttpServletRequest req);

	
	/**
	 * 게시글 작성 
	 *  입력한 게시글 내용을 DB에 저
	 * 
	 *  첨부파일을 함께 업로드 할 수 있도록 처
	 * 
	 * @param req - 요청정보 객체(게시글내용 + 첨부파일)
	 * @return 
	 * 
	 */
	public void write(HttpServletRequest req);

	/**
	 * 게시글에 첨부파일 저장할 객체
	 * 
	 * @param post
	 * @return
	 */
	public NoticeFile viewFile(int post);

	
	/**
	 * 게시글 삭제  
	 * 
	 * 
	 * @param req
	 */
	public void deleteNotice(HttpServletRequest req);

	
	
	public void update(HttpServletRequest req);


	
	
	
	


	

	

	
	
}
