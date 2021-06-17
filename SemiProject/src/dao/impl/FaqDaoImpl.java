package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.FaqDao;
import dto.Faq;

public class FaqDaoImpl implements FaqDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Faq> getData(Connection conn) {

		String sql = "";
		sql += "SELECT * FROM FAQ";

		List<Faq> faqList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery(sql);
			
			while( rs.next() ) {
				
				Faq f = new Faq();
				
				f.setTitle( rs.getString("title") );
				f.setInq_content( rs.getString("inq_content") );
			
				faqList.add(f);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return faqList;
	}

	@Override
	public List<Faq> selectFAQList(Connection conn) {

		String sql = "";
		sql += "SELECT * FROM FAQ";
		sql += " ORDER BY postno DESC";
		
		List<Faq> faqList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				
			Faq f = new Faq();
				
				f.setPostno( rs.getInt("postno" ));
//				f.setCreate_date( rs.getDate("create_date") );
				f.setInq_content( rs.getString("inq_content") );
				f.setTitle( rs.getString("title") );
				f.setUserno( rs.getInt("userno") );
				
			faqList.add(f);	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return faqList;
	}

	@Override
	public Faq selectFAQView(Connection conn, Faq postno) {

		String sql = "";
		sql += "SELECT * FROM FAQ";
		sql += " WHERE postno = ?"; 
		
		Faq v = null;
		
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, postno.getPostno()); 
				
				rs = ps.executeQuery(); 
				
				while(rs.next()) {
					
					v = new Faq(); 
					
//					v.setCreate_date( rs.getDate("create_date") );
					v.setInq_content( rs.getString("inq_content") );
					v.setPostno( rs.getInt("postno") );
					v.setTitle( rs.getString("title") );
					v.setUserno( rs.getInt("userno") );
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
			
		return v;
	}

	@Override
	public int insert(Connection conn, Faq write) {

		String sql = "";
		sql += "INSERT INTO faq( postno, title, inq_content)";
		sql += " VALUES (faq_seq.nextval, ?, ?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, write.getTitle());
			ps.setString(2, write.getInq_content());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	
		return res;
	}

	@Override
	public int update(Connection conn, Faq faq) {
		
		String sql = "";
		sql += "UPDATE faq";
		sql += " SET title = ?, inq_content = ?";
		sql += " WHERE postno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, faq.getTitle());
			ps.setString(2, faq.getInq_content());
			ps.setInt(3, faq.getPostno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		
		return res;
	}
	

	@Override
	public Faq getFaqByPostno(Connection conn, int postno) {

		String sql = "";
		sql += "SELECT * FROM faq";
		sql += " WHERE postno = ?";
		
		Faq faq = new Faq();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, postno);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				faq.setTitle(rs.getString("title"));
				faq.setInq_content(rs.getString("inq_content"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("faq : " + faq);
		
		return faq;
		
	}

	@Override
	public int delete(Connection conn, Faq faq) {

		String sql = "";
		sql += "DELETE faq";
		sql += " WHERE postno = ?";

		int res = -1;

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, faq.getPostno());

			res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return res;
	}
}