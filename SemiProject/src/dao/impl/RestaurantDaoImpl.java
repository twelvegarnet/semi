package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.RestaurantDao;
import dto.SeoulGrade;
import review.dto.Seoul;

public class RestaurantDaoImpl implements RestaurantDao {
	PreparedStatement ps = null;
	ResultSet rs = null;
	

	@Override
	public List<Seoul> selectByTopRest(Connection conn) {

		String sql="";
		sql += "select * from seoul";
		sql += " WHERE upso_sno IN ('20040056307' , '19910084082' ,'20050086222','20020073071','19940114514')";
		List<Seoul> list = new ArrayList<Seoul>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Seoul rest = new Seoul();
				
				rest.setCgg_code(rs.getString("cgg_code"));
				rest.setY_dents(rs.getString("y_dents"));
				rest.setCob_code_nm(rs.getString("cob_code_nm"));
				rest.setX_cnts(rs.getString("x_cnts"));
				rest.setCgg_code_nm(rs.getString("cgg_code_nm"));
				rest.setTel_no(rs.getString("tel_no"));
				rest.setBizcnd_code_nm(rs.getString("bizcnd_code_nm"));
				rest.setUpso_sno(rs.getString("upso_sno"));
				rest.setFood_menu(rs.getString("food_menu"));
				rest.setUpso_nm(rs.getString("upso_nm"));
				rest.setRdn_code_nm(rs.getString("rdn_code_nm"));
				
				list.add(rest);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return list;
	}


	@Override
	public List<SeoulGrade> selectTopRestByTitle(Connection conn, HttpServletRequest req) {
		String sql="";

		sql+="select"; 
	    sql+=" S.*, ( SELECT avg(R.star_score) FROM review R where S.upso_sno = R.upso_sno ) avg";
	    sql+=" from seoul S";
	    sql+=" WHERE CGG_CODE_NM = ?";
	    
		List<SeoulGrade> list = new ArrayList<SeoulGrade>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, req.getParameter("title"));
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				SeoulGrade rest = new SeoulGrade();
				
				rest.setY_dents(rs.getString("y_dents"));
				rest.setCob_code_nm(rs.getString("cob_code_nm"));
				rest.setX_cnts(rs.getString("x_cnts"));
				rest.setCgg_code_nm(rs.getString("cgg_code_nm"));
				rest.setTel_no(rs.getString("tel_no"));
				rest.setBizcnd_code_nm(rs.getString("bizcnd_code_nm"));
				rest.setUpso_sno(rs.getString("upso_sno"));
				rest.setFood_menu(rs.getString("food_menu"));
				rest.setUpso_nm(rs.getString("upso_nm"));
				rest.setRdn_code_nm(rs.getString("rdn_code_nm"));
				rest.setAvg(rs.getInt("avg"));
				list.add(rest);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return list;
	}


	@Override
	public List<SeoulGrade> selectThemeByBiz(Connection conn, String theme) {
		
		String sql="";

		sql+="select"; 
	    sql+=" S.*, ( SELECT avg(R.star_score) FROM review R where S.upso_sno = R.upso_sno ) avg";
	    sql+=" from seoul S";
	    sql+=" WHERE bizcnd_code_nm = ?";
	    
		List<SeoulGrade> list = new ArrayList<SeoulGrade>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, theme);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				SeoulGrade rest = new SeoulGrade();
				
				rest.setY_dents(rs.getString("y_dents"));
				rest.setCob_code_nm(rs.getString("cob_code_nm"));
				rest.setX_cnts(rs.getString("x_cnts"));
				rest.setCgg_code_nm(rs.getString("cgg_code_nm"));
				rest.setTel_no(rs.getString("tel_no"));
				rest.setBizcnd_code_nm(rs.getString("bizcnd_code_nm"));
				rest.setUpso_sno(rs.getString("upso_sno"));
				rest.setFood_menu(rs.getString("food_menu"));
				rest.setUpso_nm(rs.getString("upso_nm"));
				rest.setRdn_code_nm(rs.getString("rdn_code_nm"));
				rest.setAvg(rs.getInt("avg"));
				list.add(rest);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return list;
	}


	@Override
	public List<SeoulGrade> selectByFoodMenu(Connection conn, SeoulGrade restaurant) {

		String sql="";

		sql+="select"; 
	    sql+=" S.*, ( SELECT avg(R.star_score) FROM review R where S.upso_sno = R.upso_sno ) avg";
	    sql+=" from seoul S";
	    sql+=" where s.food_menu LIKE ?";
	    
		List<SeoulGrade> list = new ArrayList<SeoulGrade>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, restaurant.getFood_menu());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				SeoulGrade rest = new SeoulGrade();
				
				rest.setY_dents(rs.getString("y_dents"));
				rest.setCob_code_nm(rs.getString("cob_code_nm"));
				rest.setX_cnts(rs.getString("x_cnts"));
				rest.setCgg_code_nm(rs.getString("cgg_code_nm"));
				rest.setTel_no(rs.getString("tel_no"));
				rest.setBizcnd_code_nm(rs.getString("bizcnd_code_nm"));
				rest.setUpso_sno(rs.getString("upso_sno"));
				rest.setFood_menu(rs.getString("food_menu"));
				rest.setUpso_nm(rs.getString("upso_nm"));
				rest.setRdn_code_nm(rs.getString("rdn_code_nm"));
				rest.setAvg(rs.getInt("avg"));
				list.add(rest);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return list;
	}


}
