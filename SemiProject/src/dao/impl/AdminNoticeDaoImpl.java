package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import common.Paging;
import dto.Notice;
import dao.face.AdminNoticeDao;
import dao.face.NoticeDao;

public class AdminNoticeDaoImpl implements AdminNoticeDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Notice> selectAll(Connection conn) {

		String sql = "";
		sql += "SELECT * FROM notice";
		sql += " ORDER BY postno";
		
		List<Notice> noticeList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next()) {
				Notice n = new Notice();
				
				n.setPostno( rs.getInt("postno"));
				n.setCreate_date( rs.getDate("create_date"));
				n.setTitle( rs.getString("title"));
				n.setInq_content( rs.getString("inq_content"));
				n.setUserno( rs.getInt("userno"));
				n.setHit( rs.getInt("hit"));
				
				
				noticeList.add(n);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("noticeList : " + noticeList);
		
		return noticeList;
	}

	
	
	
	@Override
	public int updateHit(Connection conn, int post) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "UPDATE notice";
		sql += " SET hit = hit + 1";
		sql += " WHERE postno = ? ";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, post);
			
			res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("res : " + res);
		return res;
	}

	
	
	@Override
	public Notice selectNoticeByPostno(Connection conn, int post) {
		
		
		String sql = "";
		sql += "SELECT * FROM notice";
		sql += " WHERE postno = ? ";
		
		Notice viewNotice = new Notice();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객
			
			ps.setInt(1, post); //조회할 게시글 번호 적
			
			rs = ps.executeQuery(); //SQL수행 및 결과집합 저장
			
			while( rs.next()) {
				viewNotice.setPostno( rs.getInt("postno"));
				viewNotice.setCreate_date( rs.getDate("create_date"));
				viewNotice.setTitle( rs.getString("title"));
				viewNotice.setInq_content( rs.getString("inq_content"));
				viewNotice.setUserno( rs.getInt("userno"));
				viewNotice.setHit( rs.getInt("hit"));
				
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		
		return viewNotice;
	}




	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM notice";
		
		//총 게시글 수 
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return cnt;
	}




	@Override
	public List<Notice> selectAll(Connection conn, Paging paging) {

		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, N.* FROM (";
		sql += "		SELECT";
		sql += "			postno, create_date, title, userno, hit";
		sql += "		FROM notice";
		sql += "		ORDER BY postno DESC";
		sql += "	) N";
		sql += " ) NOTICE";
		sql += " WHERE rnum BETWEEN ? AND ? ";
		
		//결과 저장할 List  
		List<Notice> noticeList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
		
			rs = ps.executeQuery();
			
			while( rs.next()) {
				Notice n = new Notice();
				
				n.setPostno( rs.getInt("postno"));
				n.setCreate_date( rs.getDate("create_date"));
				n.setTitle( rs.getString("title"));
				n.setUserno( rs.getInt("userno"));
				n.setHit( rs.getInt("hit"));
				
				noticeList.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		
		return noticeList;
	}




	@Override
	public int update(Connection conn, Notice adminNotice) {

		String sql = "";
		sql += "UPDATE notice";
		sql += " SET title = ?, inq_content = ?";
		sql += " WHERE postno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, adminNotice.getTitle());
			ps.setString(2, adminNotice.getInq_content());
			ps.setInt(3, adminNotice.getPostno());
			
			res = ps.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return res;
	}




}
