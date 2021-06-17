package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.face.DetailDao;
import dto.Seoul;
import dto.SeoulGrade;
import common.JDBCTemplate;

public class DetailDaoImpl implements DetailDao {
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	@Override
	public Seoul selectUpsoByUpso_sno(Connection conn, Seoul upso_sno) {
		String sql = "";
		sql += "SELECT * FROM seoul WHERE upso_sno = ?";//업소번호에 따른 업소 전체 정보 조회쿼리
		
		Seoul viewupso = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, upso_sno.getUpso_sno());
			rs = ps.executeQuery();
			while(rs.next()) {
				viewupso = new Seoul();
				viewupso.setCgg_code(rs.getString("cgg_code")); //지역구번호
				viewupso.setY_dents(rs.getString("y_dents")); //y좌표
//				viewupso.setCob_code_nm(rs.getString("cob_code_nm")); //일반음식점 쓸모없을듯
				viewupso.setX_cnts(rs.getString("x_cnts")); //좌표
				viewupso.setCgg_code_nm(rs.getString("cgg_code_nm")); //지역구이름
				viewupso.setTel_no(rs.getString("tel_no")); //전화번호
				viewupso.setBizcnd_code_nm(rs.getString("bizcnd_code_nm")); //업종
				viewupso.setUpso_sno(rs.getString("upso_sno")); //업소번호
				viewupso.setFood_menu(rs.getString("food_menu")); //음식메뉴
				viewupso.setUpso_nm(rs.getString("upso_nm")); //업소명
				viewupso.setRdn_code_nm(rs.getString("rdn_code_nm")); //한글 주소
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
//		System.out.println(viewupso); //viewupso 객체값 확인
		return viewupso;
	}
	@Override
	public SeoulGrade selectGradeByUpso_sno(Connection conn, Seoul upso_sno) {
		String sql="";

		sql+="select"; 
	    sql+=" S.*, ( SELECT avg(R.star_score) FROM review R where S.upso_sno = R.upso_sno ) avg";
	    sql+=" from seoul S";
	    sql+=" WHERE upso_sno = ?";
	    
	    SeoulGrade grade = new SeoulGrade();
	    
	    try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, upso_sno.getUpso_sno());
			rs = ps.executeQuery();
			
			while(rs.next()) {
			
			grade.setAvg(rs.getInt("avg"));
			}
			System.out.println("Dao grade" +grade);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return grade;
	}

}