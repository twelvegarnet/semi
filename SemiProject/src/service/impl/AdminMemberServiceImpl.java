package service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.AdminMemberDao;
import dao.impl.AdminMemberDaoImpl;
import dto.Member;
import service.face.AdminMemberService;


public class AdminMemberServiceImpl implements AdminMemberService {
	
	private AdminMemberDao adminMemberDao = new AdminMemberDaoImpl();

	@Override
	public List<Member> getMemList() {
		return adminMemberDao.selectAllMemList(JDBCTemplate.getConnection());
	}


	@Override
	public Member getUserno(HttpServletRequest req) {
		
		Member userno = new Member();
		String param = req.getParameter("userno");
		
		if (param != null && !"".equals(param)) {
			userno.setUserno(Integer.parseInt(param));
		}
		return userno;
	}


	@Override
	public void deleteMem(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		
		if(adminMemberDao.deleteMem(conn, member) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

}
