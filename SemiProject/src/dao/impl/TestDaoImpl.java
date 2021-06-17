package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.TestDao;
import dto.Seoul;
import common.JDBCTemplate;

public class TestDaoImpl implements TestDao{
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체

	@Override
	public List<Seoul> selectList(Connection conn) {
		//SQL 작성
		String sql = "SELECT * FROM seoul";
				
				List<Seoul> seoulList = new ArrayList<>();
				
				try {
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					while(rs.next()) {
						Seoul s = new Seoul();
						s.setUpso_sno(rs.getString("upso_sno"));
						//업소번호 배열객체 서울리스트에 추가
						seoulList.add(s);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				return seoulList;
			}
	

}
