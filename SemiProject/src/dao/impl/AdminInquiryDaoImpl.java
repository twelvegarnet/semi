package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.AdminInquiryDao;
import dto.Inquiry;
import dto.InquiryAnswer;
import inquiry.util.Paging;

public class AdminInquiryDaoImpl implements AdminInquiryDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	
	@Override
	public List<Inquiry> selectAllInqList(Connection conn) {
		
		//SQL 구문
		String sql = "";
		sql += "SELECT * FROM inquiry";
		sql += " ORDER BY inquiryno DESC";
		
		//결과 저장할 List
		List<Inquiry> inquiryList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Inquiry inq = new Inquiry();
				
				inq.setInquiryno(rs.getInt("inquiryno"));
				inq.setInqsort(rs.getString("inqsort"));
				inq.setCreateDate(rs.getDate("createDate"));
				inq.setTitle(rs.getString("title"));
				inq.setUserno(rs.getInt("userno"));
				inq.setInqcontent(rs.getString("inqcontent"));
				
				inquiryList.add(inq);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return inquiryList;
	}

	
	@Override
	public List<Inquiry> selectAllInqList(Connection conn, Paging paging) {
		
		//SQL 구문
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, I.* FROM (";
		sql += "        SELECT inquiryno, title, userno, createDate,";
		sql += " 		(SELECT nick FROM user_table U WHERE U.userno = INQ.userno ) nick";
		sql += "        FROM inquiry INQ";
		sql += "        ORDER BY inquiryno DESC";
		sql += "    ) I";
		sql += " ) INQUIRY";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<Inquiry> inquiryList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Inquiry inq = new Inquiry();
				
				inq.setInquiryno(rs.getInt("inquiryno"));
				inq.setTitle(rs.getString("title"));
				inq.setUserno(rs.getInt("userno"));
				inq.setCreateDate(rs.getDate("createDate"));
				inq.setNick(rs.getString("nick"));
				
				inquiryList.add(inq);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return inquiryList;
	}


	@Override
	public int selectCntAllInq(Connection conn) {
		
		//SQL 구문
		String sql = "";
		sql += "SELECT count(*) cnt FROM inquiry";
		
		//총 게시글 수
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
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
	public Inquiry selectInqByInquiryno(Connection conn, Inquiry inquiryno) {
		
		//SQL 구문
		String sql = "";
		sql += "SELECT * FROM inquiry";
		sql += " WHERE inquiryno = ?";
		
		//결과 저장 객체
		Inquiry viewInq = new Inquiry();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, inquiryno.getInquiryno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				viewInq.setInquiryno(rs.getInt("inquiryno"));
				viewInq.setInqsort(rs.getString("inqsort"));
				viewInq.setUserno(rs.getInt("userno"));
				viewInq.setCreateDate(rs.getDate("createDate"));
				viewInq.setTitle(rs.getString("title"));
				viewInq.setInqcontent(rs.getString("inqcontent"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return viewInq;
	}

	
	@Override
	public String selectNickByUserno(Connection conn, Inquiry viewInquiry) {
		
		//SQL 구문
		String sql = "";
		sql += "SELECT nick FROM user_table";
		sql += " WHERE userno = ?";
		
		//결과 저장할 객체 생성
		String nick = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, viewInquiry.getUserno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				nick = rs.getString("nick");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return nick;
	}


	@Override
	public int insertAnswer(Connection conn, InquiryAnswer answer) {
		
		//SQL 구문
		String sql = "";
		sql += "INSERT INTO InquiryAnswer (answerno, answercontent, inquiryno, userno)";
		sql += " VALUES (inquiryAns_seq.nextval, ?, ?, ?)";
		
		//결과 저장할 변수
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, answer.getAnswercontent());
			ps.setInt(2, answer.getInquiryno());
			ps.setInt(3, answer.getUserno());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}


	@Override
	public int selectCntAllAns(Connection conn, Inquiry inquiryno) {
		
		//SQL 구문
		String sql = "";
		sql += "SELECT count(*) FROM InquiryAnswer A"; 
		sql += "	WHERE A.inquiryno IN (SELECT I.inquiryno";
		sql += "    					  FROM Inquiry I";
		sql += "						  WHERE I.inquiryno = ?)";
		
		//총 답변 수
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, inquiryno.getInquiryno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
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
	public int deleteInq(Connection conn, Inquiry inquiry) {
		
		//SQL 구문
		String sql = "";
		sql += "DELETE inquiry";
		sql += " WHERE inquiryno = ?";
		
		int result = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, inquiry.getInquiryno());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)	 ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}


}
