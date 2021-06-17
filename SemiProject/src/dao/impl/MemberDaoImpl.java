
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.MemberDao;
import dto.Member;
import dto.Payment;

public class MemberDaoImpl implements MemberDao {

	PreparedStatement ps = null;
	ResultSet rs = null;


	@Override
	public Member selectMemberByUserid(Connection conn, Member member) {
		String sql = "";
		sql += "SELECT * FROM user_table";
		sql += " WHERE 1=1 AND userid = ?";

		Member res = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			rs = ps.executeQuery();

			while(rs.next()) {
				res = new Member();
				res.setUserid(rs.getString("userid"));
				res.setUserpw(rs.getString("userpw"));
				res.setNick(rs.getString("nick"));
				res.setUserno(rs.getInt("userno"));
				res.setGrade(rs.getString("grade"));
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}



		return res;
	}


	@Override
	public int selectCntMemberUseridUserpw(Connection conn, Member member) {

		String sql="";

		sql += "SELECT count(*) cnt FROM user_table";
		sql += " WHERE userid = ? AND userpw = ?";

		int res = 0;


		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			ps.setString(2, member.getUserpw());
			rs = ps.executeQuery();

			while(rs.next()) {
				res = rs.getInt("cnt");
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}


		System.out.println(res);

		return res;
	}
	

	@Override
	public int insertByMemberInfo(Connection conn, Member member) {
		
		String sql ="INSERT INTO user_table( userno,userid,username,userpw,userbirth,phoneno,nick,email,gender,grade)";
		sql += " VALUES(seq_user.nextval,?,?,?,?,?,?,?,?,?)";
		
		
		int res = 0;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, member.getUserid());
			ps.setString(2, member.getUsername());
			ps.setString(3, member.getUserpw());
			ps.setString(4, member.getUserbirth());
			ps.setString(5, member.getPhoneno());
			ps.setString(6, member.getNick());
			ps.setString(7, member.getEmail());
			ps.setString(8, member.getGender());
			ps.setString(9, member.getGrade());
			
			res = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}


	@Override
	public List<Member> getAllUser(Connection conn) {
		
		//SQL 구문 생성
		String sql = "";
		sql += "SELECT*FROM user_table";
		
		//리턴값 담을 리스트 객체 생성
		List<Member> list = new ArrayList<>();
		
		try {
			//DB연결 객체
			ps = conn.prepareStatement(sql);
			
			//SQL구문 수행
			rs = ps.executeQuery();
			
			//결과값 추출 및 저장
			while( rs.next() ) {
				Member m = new Member();
			
				
				m.setUserno( rs.getInt("userno"));
				m.setUserid( rs.getString("userid"));
				m.setUserpw( rs.getString("userpw"));
				m.setUsername( rs.getString("username"));
				m.setUserbirth( rs.getString("userbirth"));
				m.setPhoneno( rs.getString("phoneno"));
				m.setNick( rs.getString("nick"));
				m.setGrade( rs.getString("grade"));
				m.setGender( rs.getString("gender"));
				m.setEmail( rs.getString("email"));
				
				list.add(m);
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
	public Member getUserno(Connection conn, Member m) {
		
		String sql ="";
		sql += "SELECT * FROM user_table";
		sql += "	WHERE userid = ?";
		
		Member member = new Member();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, m.getUserid());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				member.setUserno( rs.getInt("userno") ); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return member;
	}

	@Override
	public int selectById(Connection conn, String userid) {
		String sql ="";
		sql +=" SELECT COUNT(*) CNT FROM user_table";
		sql +="	WHERE userid = ?";
		int res = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			
			
			while (rs.next()) {
				res = rs.getInt("cnt");
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		
		return res;
	}


	@Override
	public int selectByNick(Connection conn, String nick) {
		String sql ="";
		sql +=" SELECT COUNT(*) CNT FROM user_table";
		sql +="	WHERE nick = ?";
		int res = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, nick);
			
			rs = ps.executeQuery();
			
			
			while (rs.next()) {
				res = rs.getInt("cnt");
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public Member selectByUserInfo(Connection conn, Member member) {
		String sql ="";
		sql += "SELECT * FROM user_table";
		sql += " WHERE userid = ?";
		
		Member res = null;
		
		
		
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, member.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				res = new Member();
				
				res.setUserid(rs.getString("userid"));
				res.setUserno(rs.getInt("userno"));
				res.setUserpw(rs.getString("userpw"));
				res.setEmail(rs.getString("email"));
				res.setUsername(rs.getString("username"));
				res.setNick(rs.getString("nick"));
				res.setPhoneno(rs.getString("phoneno"));
				res.setGender(rs.getString("gender"));
				res.setGrade(rs.getString("grade"));
				res.setUserbirth(rs.getString("userbirth"));
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		
		return res;
	}


	@Override
	public int updateByNickEmail(Connection conn, Member member) {
		
		String sql = "";
		sql += "UPDATE user_table SET nick = ?,email = ?";
		sql += " WHERE userid = ?";
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getNick());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getUserid());
			
			res = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(ps);
			
			
		}
		
		
		
		
		
		return res;
	}


	@Override
	public int delete(Connection conn, Object userno) {
		
		String sql="";
		sql +="UPDATE user_table SET username=null, userid=null, userpw=null, nick=null, email=null";
		sql +=" WHERE userno = ?";
		int res = -1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1,(Integer)userno);
			
			res = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}


	@Override
	public Member selectByUserId(Connection conn, Member member) {
		String sql ="";
		sql += "SELECT * FROM user_table";
		sql += " WHERE username = ?";
		sql += " AND userpw = ?";
		sql += " AND nick = ?";
		
		Member res = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, member.getUsername());
			ps.setString(2, member.getUserpw());
			ps.setString(3, member.getNick());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				res = new Member();
				
				res.setUserid(rs.getString("userid"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return res;
	}


	@Override
	public Member selectByUserPw(Connection conn, Member member) {

		String sql ="";
		sql += "SELECT * FROM user_table";
		sql += " WHERE userid = ?";
		sql += " AND nick = ?";
		
		Member res = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, member.getUserid());
			ps.setString(2, member.getNick());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				res = new Member();
				
				res.setUserpw(rs.getString("userpw"));
				res.setEmail(rs.getString("email"));
				res.setUserid(rs.getString("userid"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return res;
	}


	@Override
	public int updatePW(Connection conn, Member member) {
		
		//SQL 구문
		String sql = "";
		sql += "UPDATE user_table SET userpw = ?";
		sql += " WHERE userid = ?";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserpw());
			ps.setString(2, member.getUserid());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	@Override
	public void insertPayment(Connection conn, Payment payment) {
		System.out.println(payment.toString());
		String sql = "";
		sql += "INSERT INTO payment";
		sql += " VALUES (?, ?, ?, ?)";
		
		int res = 0;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
//			ps.setString(1, board.getTitle());
//			ps.setString(2, board.getUserid());
//			ps.setString(3, board.getContent());
			ps.setString(1, payment.getPaymentUid());
			ps.setString(2, payment.getAmt());
			ps.setString(3, payment.getMerchant_uid());
			ps.setString(4, payment.getUserid());

			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			JDBCTemplate.commit(conn);
		}
		
	}


	@Override
	public void updateMember(Connection conn, Payment payment) {
		System.out.println(payment.toString());
		String sql = "";
		sql +="UPDATE user_table SET"; 
		sql +=" grade = '프리미엄' WHERE USERID = ?";
		
		int res = 0;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			//ps.setString(1, "1");
			ps.setString(1, payment.getUserid());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			JDBCTemplate.commit(conn);
		}
		
	}


	
}
