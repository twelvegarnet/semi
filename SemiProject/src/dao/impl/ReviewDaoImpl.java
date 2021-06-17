package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.ReviewDao;
import dto.Review;
import dto.Seoul;
import common.JDBCTemplate;
import common.Paging;
import common.PagingReview;

public class ReviewDaoImpl implements ReviewDao {
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	@Override
	public int selectCntAll(Connection conn) {
	//System.out.println("selectCntAll() 호출");
	String sql = "SELECT count(*) cnt FROM review";
	
	//총 게시글 수
	int cnt = 0;
	
	try {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		//cnt 확인
//		System.out.println(cnt);
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rs);
		JDBCTemplate.close(ps);
	}
	
	return cnt;
}
	@Override
	public List<Review> selectList(Connection conn, PagingReview paging, Seoul upso_sno) {
		System.out.println("selectList - " + paging);
		System.out.println("selectList - " + upso_sno);
		
		String sql = "SELECT * FROM (";
		sql += " 	SELECT rownum rnum, R.* FROM (";
		sql += " 		SELECT";
		sql += " A.reviewno, A.upso_sno, A.title, A.userno, B.nick, A.inq_content, A.create_date, A.star_score";
		sql += " 		FROM review A FULL OUTER JOIN user_table B ON A.userno = B.userno WHERE upso_sno = ?";
		sql += " 		ORDER BY reviewno DESC";
		sql += "	) R";
		sql += " ) REVIEW";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Review> reviewList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, upso_sno.getUpso_sno());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			//조회 결과 처리
			while(rs.next()) {
			Review r = new Review(); //결과값 저장 객체
			r.setReviewno(rs.getInt("reviewno"));
			r.setUpso_sno(rs.getString("upso_sno"));
			r.setTitle(rs.getString("title"));
			r.setUserno(rs.getInt("userno"));
			r.setNick(rs.getString("nick"));
			r.setInq_content(rs.getString("inq_content"));
			r.setCreate_date(rs.getDate("create_date"));
			r.setStar_score(rs.getInt("star_score"));
			//배열객체 reviewList에 담기
			reviewList.add(r);
			
			}
//			System.out.println(reviewList); //reviewList 값 확인
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		//DB객체 닫기
		JDBCTemplate.close(rs);
		JDBCTemplate.close(ps);
		}
		return reviewList;
	}
	@Override
	public int insert(Connection conn, Review review) {
		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO review(reviewno, upso_sno, userno, title, create_date, inq_content, star_score)";
		sql += " VALUES (review_seq.nextval, ?, ?, ?, sysdate, ?, ?)";
				
				int res = 0;
				
				try {
					//DB작업
					ps = conn.prepareStatement(sql);
					ps.setString(1, review.getUpso_sno());
					ps.setInt(2, review.getUserno());
					ps.setString(3, review.getTitle());
					ps.setString(4, review.getInq_content());
					ps.setInt(5, review.getStar_score());

					res = ps.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(ps);
				}
				
				return res;
			}
	@Override
	public int update(Connection conn, Review review) {
		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "UPDATE review";
		sql += " SET title = ?,";
		sql += " 	inq_content = ?,";
		sql += " 	star_score = ?";
		sql += " WHERE reviewno = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		int res = -1;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, review.getTitle());
			ps.setString(2, review.getInq_content());
			ps.setInt(3, review.getStar_score());
			ps.setInt(4, review.getReviewno());

			res = ps.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	@Override
	public int delete(Connection conn, Review review) {
		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "DELETE review WHERE reviewno = ?";
				
		//DB 객체
		PreparedStatement ps = null; 
			int res = -1;
				try {
					ps = conn.prepareStatement(sql);
					ps.setInt(1, review.getReviewno());
					
					res = ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						//DB객체 닫기
						if(ps!=null)	ps.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
				}
				return res;
			}
	@Override
	public int getReviewCnt(Connection conn, Seoul upso_sno) {
		String sql = "SELECT count(*) cnt FROM review WHERE upso_sno = ?";
		//총 게시글 수
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, upso_sno.getUpso_sno());
			rs = ps.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
			//cnt 확인
//			System.out.println(cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return cnt;
	}
	@Override
	public int selectCntByUserno(Connection conn, int userno) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM review";
		sql += "	WHERE userno = ?";
		
		//총 게시글 수
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			
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
	public List<Review> getReview(Connection conn, Paging paging, int userno) {
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += "		SELECT * FROM review";
		sql += "		WHERE userno = ?";
		sql += "		ORDER BY reviewno DESC";
		sql += "	) R";
		sql += " ) REVIEW";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Review> rvList = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Review r = new Review();
				
				r.setReviewno( rs.getInt("reviewno") );
				r.setUpso_sno(rs.getString("upso_sno"));
				r.setCreate_date(rs.getDate("create_date"));
				r.setTitle(rs.getString("title"));
				r.setInq_content(rs.getString("inq_content"));
				r.setStar_score(rs.getInt("star_score"));
				
				rvList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return rvList;
	}
}
