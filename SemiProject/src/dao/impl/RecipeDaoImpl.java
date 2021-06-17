package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.RecipeDao;
import dto.Member;
import dto.Recipe;

public class RecipeDaoImpl implements RecipeDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM recipe";
		
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
	public List<Recipe> selectAll(Connection conn, Paging paging) {
		
		//SQL 구문 생성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += "		SELECT * FROM recipe";
		sql += "			ORDER BY postno DESC";
		sql += "	) R	 ";
		sql += " ) RECIPE";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과값 담을 List객체 생성
		List<Recipe> list = new ArrayList<>();
		
		try {
			//DB 객체 생성
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			//SQL구문 수행
			rs = ps.executeQuery();
			
			//반복문으로 List에 DB데이터 담기
			while( rs.next() ) {
				
				//한 행의 데이터를 담을 객체 만들기
				Recipe r = new Recipe();
				
				r.setPostno( rs.getInt("postno") );
				r.setCreate_date( rs.getDate("create_date") );
				r.setTitle( rs.getString("title") );
				r.setUserno( rs.getInt("userno") );
				r.setInq_content( rs.getString("inq_content") );
				r.setViews( rs.getInt("views") );
				
				list.add(r);
				
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
	public Recipe selectByPostno(Connection conn, String postno) {
		
		//SQL구문 생성
		String sql = "";
		sql += "SELECT * FROM recipe";
		sql += "	WHERE postno = ?";
		
		//리턴값 객체 생성
		Recipe recipe = new Recipe();
		
		try {
			//DB객체 연결
			ps = conn.prepareStatement(sql);
			
			// postno 값 대입
			ps.setInt(1, Integer.parseInt(postno) );			
			
			//SQL쿼리 수행
			rs = ps.executeQuery();
			
			//결과값 대입
			while( rs.next() ) {
				
				recipe.setPostno( rs.getInt("postno") );
				recipe.setCreate_date( rs.getDate("create_date") );
				recipe.setTitle( rs.getString("title") );
				recipe.setUserno( rs.getInt("userno") );
				recipe.setInq_content( rs.getString("inq_content") );
				recipe.setViews( rs.getInt("views") );
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return recipe;
	}

	@Override
	public int updateViews(Connection conn, String postno) {

		String sql = "";
		sql += "UPDATE recipe";
		sql += "	SET views = views + 1";
		sql += "	WHERE postno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(postno) );
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int insert(Connection conn, Recipe recipe, Member member) {

		String sql = "";
		sql += "INSERT INTO recipe( postno, create_date, title, userno, inq_content, views )";
		sql += "	VALUES ( recipe_seq.nextval, sysdate, ?, ?, ?, 0 )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, recipe.getTitle());
			ps.setInt(2, member.getUserno());
			ps.setString(3,  recipe.getInq_content());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		
		return res;
	}

	@Override
	public Recipe getDataByUserno(Connection conn, String postno) {
		
		String sql = "";
		sql += "SELECT * FROM recipe";
		sql += "	WHERE postno = ?";
		
		//결과정보를 담을 recipe객체
		Recipe recipe = new Recipe();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(postno) );
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				recipe.setCreate_date( rs.getDate("create_date") );
				recipe.setInq_content( rs.getString("inq_content") );
				recipe.setPostno( rs.getInt("postno") );
				recipe.setTitle( rs.getString("title") );
				recipe.setUserno( rs.getInt("userno") );
				recipe.setViews( rs.getInt("views") );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return recipe;
	}
		
	public Recipe getRecipeByUserno(Connection conn, int userno) {
		
		String sql = "";
		sql += "SELECT * FROM recipe";
		sql += "	WHERE userno = ?";
		
		Recipe recipe = new Recipe();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				recipe.setPostno( rs.getInt("postno") );
				recipe.setCreate_date( rs.getDate("create_date") );
				recipe.setTitle( rs.getString("title") );
				recipe.setUserno( rs.getInt("userno") );
				recipe.setInq_content( rs.getString("inq_content") );
				recipe.setViews( rs.getInt("views") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return recipe;
	}

	@Override
	public int UpdateRecipe(Connection conn, HttpServletRequest req) {
		
		String sql = "";
		sql += "UPDATE recipe SET title = ?, inq_content = ?";
		sql += "	WHERE postno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, req.getParameter("title"));
			ps.setString(2, req.getParameter("content"));
			ps.setInt(3, Integer.parseInt(req.getParameter("postno")));
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public Recipe getRecipeDataFromReq(Connection conn, int postno) {
		
		String sql = "";
		sql += "SELECT * FROM recipe";
		sql += "	WHERE postno = ?";
		
		//반환 Recipe 객체 생성
		Recipe recipe = new Recipe();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, postno);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				recipe.setCreate_date( rs.getDate("create_date"));
				recipe.setInq_content( rs.getString("inq_content"));
				recipe.setPostno( rs.getInt("postno"));
				recipe.setTitle( rs.getString("title"));
				recipe.setUserno( rs.getInt("userno"));
				recipe.setViews( rs.getInt("views"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return recipe;
	}

	@Override
	public int deleteRecipe(Connection conn, HttpServletRequest req) {
		
		String sql = "";
		sql += "DELETE FROM recipe";
		sql += "	WHERE postno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(req.getParameter("postno")));
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int getCurPostno(Recipe recipe, Member member, Connection conn) {
		
		String sql = "";
		sql += "SELECT * FROM recipe";
		sql += "	WHERE title = ? AND inq_content = ? AND userno = ?";
		
		int postno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, recipe.getTitle());
			ps.setString(2, recipe.getInq_content());
			ps.setInt(1, member.getUserno());
			
			rs = ps.executeQuery();
			
			postno = rs.getInt("postno");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return postno;
	}

	@Override
	public int getPostno(Connection conn) {

		String sql ="";
		sql += "SELECT * FROM (";
		sql += "	SELECT ROWNUM rnum, R.* FROM (";
		sql += "		SELECT * FROM recipe";
		sql += "		ORDER BY postno DESC";
		sql += "	)R";
		sql += " ) Recipe ";
		sql += " WHERE rnum = 1 ";
		
		int postno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				postno = rs.getInt("postno");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		
		
		return postno;
	}

	@Override
	public List<Recipe> getRecipe(Connection conn, int userno) {

		String sql = "";
		sql += "SELECT * FROM recipe";
		sql += "	WHERE userno = ?";
		sql += "	ORDER BY postno DESC";
		
		List<Recipe> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				Recipe r = new Recipe();
				r.setPostno( rs.getInt("postno"));
				r.setCreate_date( rs.getDate("create_date"));
				r.setTitle( rs.getString("title"));
				r.setUserno( rs.getInt("userno"));
				r.setInq_content( rs.getString("inq_content"));
				r.setViews( rs.getInt("views"));
				
				list.add(r);
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
	public List<Recipe> getRecipe(Connection conn, Paging paging, int userno) {

		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += "		SELECT * FROM recipe";
		sql += "		WHERE userno = ?";
		sql += "		ORDER BY postno DESC";
		sql += "	) R";
		sql += " ) RECIPE";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Recipe> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Recipe r = new Recipe();
				
				r.setPostno( rs.getInt("postno") );
				r.setCreate_date( rs.getDate("create_date") );
				r.setTitle( rs.getString("title") );
				r.setUserno( rs.getInt("userno") );
				r.setInq_content( rs.getString("inq_content") );
				r.setViews( rs.getInt("views") );
				
				list.add(r);
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
	public int selectCntByUserno(Connection conn, int userno) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM recipe";
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
	public List<Recipe> getRecipe(Connection conn) {
		
		String sql = "";
		sql += "SELECT * FROM recipe";
		
		List<Recipe> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				Recipe recipe = new Recipe();
				
				recipe.setCreate_date( rs.getDate("create_date"));
				recipe.setInq_content( rs.getString("inq_content"));
				recipe.setPostno( rs.getInt("postno"));
				recipe.setTitle( rs.getString("title"));
				recipe.setUserno( rs.getInt("userno"));
				recipe.setViews( rs.getInt("views"));
				
				list.add(recipe);
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
	public List<Recipe> getRecipeList(Connection conn, HttpServletRequest req, Paging paging) {

		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, R.* FROM (";
		sql += "		SELECT * FROM recipe";
		sql += "		WHERE regexp_like(title, ?) OR regexp_like(inq_content, ?)";
		sql += "		ORDER BY postno DESC";
		sql += "	) R";
		sql += " ) RECIPE";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Recipe> list = new ArrayList<>();
		String search = req.getParameter("search");
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, search);
			ps.setString(2, search);
			ps.setInt(3, paging.getStartNo());
			ps.setInt(4, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Recipe r = new Recipe();
				
				r.setCreate_date( rs.getDate("create_date"));
				r.setInq_content( rs.getString("inq_content"));
				r.setPostno( rs.getInt("postno"));
				r.setTitle( rs.getString("title"));
				r.setUserno( rs.getInt("userno"));
				r.setViews( rs.getInt("views"));
				
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}

}













