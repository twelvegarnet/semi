package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.InquiryDao;
import dto.Inquiry;
import dto.InquiryAnswer;
import inquiry.util.Paging;

public class InquiryDaoImpl implements InquiryDao {
	
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
	public List<Inquiry> selectAllInqList(Connection conn, Paging paging, int userno) {
		
		//SQL 구문
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, I.* FROM (";
		sql += "        SELECT inquiryno, title, userno, createDate,";
		sql += " 		(SELECT nick FROM user_table U WHERE U.userno = INQ.userno ) nick";
		sql += "        FROM inquiry INQ";
		sql += "        WHERE userno = ?";
		sql += "        ORDER BY inquiryno DESC";
		sql += "    ) I";
		sql += " ) INQUIRY";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<Inquiry> inquiryList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
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
		//TEST 2)))
//		System.out.println("Dao: " + inquiryno);
		
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
	public int insertInq(Connection conn, Inquiry inquiry) {
		System.out.println(inquiry);
		
		//SQL 구문
		String sql = "";
		sql += "INSERT INTO inquiry (inquiryno, inqsort, title, inqcontent, userno)";
		sql += " VALUES (inquiry_seq.nextval, ?, ?, ?, ?)";
		
		//결과 저장할 변수 생성
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, inquiry.getInqsort());
			ps.setString(2, inquiry.getTitle());
			ps.setString(3, inquiry.getInqcontent());
			ps.setInt(4, inquiry.getUserno());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}

	
	@Override
	public List<InquiryAnswer> selectAllAnsList(Connection conn, Inquiry inquiryno) {

		//SQL 구문
		String sql = "";
		sql += "SELECT * FROM InquiryAnswer A"; 
		sql += "	WHERE A.inquiryno IN (SELECT I.inquiryno";
		sql += "    					  FROM Inquiry I";
		sql += "						  WHERE I.inquiryno = ?)";
		
		//결과 저장할 List
		List<InquiryAnswer> answerList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, inquiryno.getInquiryno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				InquiryAnswer ans = new InquiryAnswer();
				
				ans.setAnswerno(rs.getInt("answerno"));
				ans.setAnswercontent(rs.getString("answercontent"));
				ans.setCreateDate(rs.getDate("createDate"));
				ans.setInquiryno(rs.getInt("inquiryno"));
				ans.setUserno(rs.getInt("userno"));
				
				answerList.add(ans);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return answerList;
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
