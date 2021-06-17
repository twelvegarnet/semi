package service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dto.Notice;
import dao.face.NoticeDao;
import dao.impl.NoticeDaoImpl;
import service.face.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDao noticeDao = new NoticeDaoImpl();
	
	@Override
	public List<Notice> getList() {
		
		
		return noticeDao.selectAll(JDBCTemplate.getConnection());
	}
	
	

	@Override
	public Notice getPostno(HttpServletRequest req) {
		
		Notice postno = new Notice();
		
		String param = req.getParameter("postno");
		
		if( param != null && !"".equals(param)) {
			
			postno.setPostno( Integer.parseInt(param));
		} 
		
		return postno;
	}

	@Override
	public Notice view(int post) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//조회수 증가
		if( noticeDao.updateHit(conn, post) >= 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		
		
		return noticeDao.selectNoticeByPostno(conn, post);
	}

	
	
	
	
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//Notice 테이블의 총 게시글 수를 조회한다
		int totalCount = noticeDao.selectCntAll(JDBCTemplate.getConnection());
		
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println(totalCount);
		System.out.println(curPage);
		
		return paging;
	}

	@Override
	public List<Notice> getList(Paging paging) {
		
		//게시글 전체조회 결과 처
		return noticeDao.selectAll(JDBCTemplate.getConnection(), paging);
	}

	
	
	
	


}
