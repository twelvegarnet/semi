package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.FileDao;
import dto.ParamData;
import dto.UploadFile;

public class FileDaoImpl implements FileDao {
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int insertParam(Connection conn, ParamData paramData, int postno) {
		
		String sql = "";
		sql += "INSERT INTO paramdata( datano, postno, title, filecontent)";
		sql += "	VALUES( paramdata_seq.nextval, ?, ?, ? )";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, postno);
			ps.setString(2, paramData.getTitle());
			ps.setString(3, paramData.getContent());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}

	@Override
	public int insertFile(Connection conn, UploadFile uploadFile, int postno) {
		
		String sql = "";
		sql += "INSERT INTO uploadfile( fileno, postno, origin_name, stored_name )";
		sql += "	VALUES( uploadfile_seq.nextval, ?, ?, ? )";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, postno);
			ps.setString(2, uploadFile.getOriginName());
			ps.setString(3, uploadFile.getStoredName());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}		
		
		return result;
	}

	@Override
	public List<UploadFile> getFilaData(Connection conn, int postno1) {
		
		List<UploadFile> list = new ArrayList<>();
		
		String sql = "";
		sql += "SELECT * FROM uploadfile";
		sql += "	WHERE postno = ?";
		
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, postno1);
			
			rs = ps.executeQuery();
			
			UploadFile uploadFile = new UploadFile();
			
			while( rs.next() ) {
				
				uploadFile.setFileno( rs.getInt("fileno") );
				uploadFile.setPostno( rs.getInt("postno") );
				uploadFile.setOriginName( rs.getString("origin_Name") );
				uploadFile.setStoredName( rs.getString("stored_Name") );
				
				list.add(uploadFile);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}

	@Override
	public int updateParamData(Connection conn, HttpServletRequest req) {
		
		String sql = "";
		sql += "UPDATE paramdata";
		sql += "	SET title = ?, filecontent = ?";
		sql += "	WHERE postno = ?";
		
		String post = req.getParameter("postno");
		int postno = Integer.parseInt(post);
		
		System.out.println("updateParamData의 글 번호 : " + postno);
		System.out.println("updateParamData의 글 제목 : " + req.getParameter("title"));
		System.out.println("updateParamData의 글 내용 : " + req.getParameter("content"));
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, req.getParameter("title"));
			ps.setString(2, req.getParameter("content"));
			ps.setInt(3, postno);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int deleteParamdata(Connection conn, HttpServletRequest req) {
		
		String sql = "";
		sql += "DELETE FROM paramdata";
		sql += " WHERE postno = ?";
		
		String post = req.getParameter("postno");
		int postno = Integer.parseInt(post);
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, postno);
			
			res = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int deleteUploadfile(Connection conn, HttpServletRequest req) {
		
		String sql = "";
		sql += "DELETE FROM uploadfile";
		sql += " WHERE postno = ?";
		
		String post = req.getParameter("postno");
		int postno = Integer.parseInt(post);
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, postno);
			
			res = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public UploadFile getStoredName(Connection conn, int postno1) {

		String sql = "";
		sql += "SELECT * FROM uploadfile";
		sql += "	WHERE postno = ?";
		
		UploadFile uploadFile = new UploadFile();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, postno1);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				uploadFile.setFileno( rs.getInt("fileno"));
				uploadFile.setPostno( rs.getInt("postno"));
				uploadFile.setOriginName( rs.getString("origin_name"));
				uploadFile.setStoredName( rs.getString("stored_name"));
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return uploadFile;
	}



}

