package service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import dto.Seoul;
import dto.SeoulGrade;
import common.JDBCTemplate;
import dao.face.DetailDao;
import dao.impl.DetailDaoImpl;
import service.face.DetailService;

public class DetailServiceImpl implements DetailService{
	DetailDao detailDao = new DetailDaoImpl();
	@Override
	public Seoul getupso_sno(HttpServletRequest req) {
		//upso_sno를 저장할 객체 생성
		Seoul upso_sno = new Seoul();
		//upso_sno 전달파라미터 검증 - null, ""
		String param = req.getParameter("upso_sno");
			if(param!=null && !"".equals(param)) {
					
				upso_sno.setUpso_sno(param);
			}
			return upso_sno;
		}

	@Override
	public Seoul view(Seoul upso_sno) {
		Connection conn = JDBCTemplate.getConnection();
		
		Seoul upso = detailDao.selectUpsoByUpso_sno(conn, upso_sno); 
		
		return upso;
	}

	@Override
	public Seoul writegetupso_sno(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SeoulGrade getGrade(Seoul upso_sno) {
		SeoulGrade grade = detailDao.selectGradeByUpso_sno(JDBCTemplate.getConnection(), upso_sno);
//		System.out.println("서비스 grade" + grade);
		return grade;
	}

}
