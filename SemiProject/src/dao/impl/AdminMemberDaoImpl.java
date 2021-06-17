package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.AdminMemberDao;
import dto.Member;
import inquiry.util.Paging;

public class AdminMemberDaoImpl implements AdminMemberDao {
	
	PreparedStatement ps = null;
	ResultSet rs = null;


	@Override
	public List<Member> selectAllMemList(Connection conn) {
		
		//SQL 구문
		String sql = "";
		sql += "SELECT * FROM user_table";
		sql += " ORDER BY userno DESC";
		
		List<Member> userList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Member m = new Member();
				
				m.setUserno(rs.getInt("userno"));
				m.setUserid(rs.getString("userid"));
				m.setUserpw(rs.getString("userpw"));
				m.setUsername(rs.getString("username"));
				m.setNick(rs.getString("nick"));
				m.setEmail(rs.getString("email"));
				m.setGrade(rs.getString("grade"));
			
				userList.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return userList;
	}


	@Override
	public int deleteMem(Connection conn, Member member) {
		
		//SQL 구문
		String sql = "";
		sql += "UPDATE user_table SET userpw='(삭제된 회원)', username='(삭제된 회원)', userbirth='(삭제된 회원)', phoneno='(삭제된 회원)', email='(삭제된 회원)', grade='X'";
		sql += " WHERE userno = ?";
		
		int result = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, member.getUserno());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
