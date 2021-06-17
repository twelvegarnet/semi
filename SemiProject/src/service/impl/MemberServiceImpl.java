
package service.impl;

import java.util.List;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.JDBCTemplate;
import dao.face.MemberDao;
import dao.impl.MemberDaoImpl;
import dto.Member;
import dto.Payment;
import service.face.MemberService;

public class MemberServiceImpl implements MemberService {

	MemberDao memberDao = new MemberDaoImpl();
	@Override
	public Member getLoginMember(HttpServletRequest req) {
		
		// 객체 생성
		Member member = new Member();
		
		// 객체에 로그인 정보 삽입
		member.setUserid(req.getParameter("userid"));
		member.setUserpw(req.getParameter("userpw"));
		member.setNick(req.getParameter("usernick"));

		return member;
	}
	@Override
	public boolean login(Member member) {
		
		int res = memberDao.selectCntMemberUseridUserpw(JDBCTemplate.getConnection(),member);
		
		if(res>0) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public Member info(Member member) {
		
		
		
		return memberDao.selectMemberByUserid(JDBCTemplate.getConnection(),member);
	}
	@Override
	public List<Member> getUserdata() {
		
		return memberDao.getAllUser(JDBCTemplate.getConnection());

	}
	
	
	@Override
	public Member getJoinMember(HttpServletRequest req) {
		
		
		Member member = new Member();
		System.out.println(req.getParameter("userid"));
		// 이메일
		String email = req.getParameter("email1") + "@" + req.getParameter("email2");
		// 생년월일
		String birth = req.getParameter("year")+"-"+req.getParameter("month")+"-"+req.getParameter("day");
		
		
		
		
		
		
		
		member.setUserid(req.getParameter("userid"));
		member.setUserpw(req.getParameter("userpw"));
		member.setEmail(email);
		member.setUsername(req.getParameter("username"));
		member.setNick(req.getParameter("nick"));
		member.setPhoneno(req.getParameter("phoneno"));
		member.setUserbirth(birth);
		member.setGender(req.getParameter("gender"));
		member.setGrade("일반회원");
		
		
		
		
		
		
		return member;
	}
	@Override
	public void join(Member member) {
		if(memberDao.insertByMemberInfo(JDBCTemplate.getConnection(), member)>0) {
			JDBCTemplate.commit(JDBCTemplate.getConnection());
		} else {
			JDBCTemplate.rollback(JDBCTemplate.getConnection());
		}
	}
	@Override
	public int idcheck(String userid) {
		return memberDao.selectById(JDBCTemplate.getConnection(),userid);
	}
	@Override
	public int nickcheck(String nick) {
		
		return memberDao.selectByNick(JDBCTemplate.getConnection(),nick);
	}
	@Override
	public Member saveLoinId(Object userid) {
		
		Member member = new Member();
		member.setUserid((String)userid);
		
		
		return member;
	}
	@Override
	public Member getuserInfo(Member member) {
		return memberDao.selectByUserInfo(JDBCTemplate.getConnection(), member);
	}
	@Override
	public Member getUpdateMember(HttpServletRequest req) {

		Member member = new Member();
		
		HttpSession session = req.getSession();
		
		member.setNick(req.getParameter("nick"));
		member.setEmail(req.getParameter("email"));
		member.setUserid( (String)req.getSession().getAttribute("userid"));
//		member.setGrade( (String)req.getSession().getAttribute("grade"));
		
		
		return member;
	}
	@Override
	public void updateMemberInfo(Member member) {
		if(memberDao.updateByNickEmail(JDBCTemplate.getConnection(), member) > 0) {
			JDBCTemplate.commit(JDBCTemplate.getConnection());
		} else {
			JDBCTemplate.rollback(JDBCTemplate.getConnection());
		}
	}
	@Override
	public void secession(Object userno) {
		if(memberDao.delete(JDBCTemplate.getConnection(), userno) > 0) {
			JDBCTemplate.commit(JDBCTemplate.getConnection());
		} else {
			JDBCTemplate.rollback(JDBCTemplate.getConnection());
		}
	}
	@Override
	public Member findId(HttpServletRequest req) {
		
		Member member = new Member();
		
		member.setUsername(req.getParameter("name"));
		member.setNick(req.getParameter("nick"));
		member.setUserpw(req.getParameter("pw"));
		
		
		return memberDao.selectByUserId(JDBCTemplate.getConnection(),member);
	}
	@Override
	public Member findPw(HttpServletRequest req) {
		
		Member member = new Member();
		
		member.setUserid(req.getParameter("id"));
		member.setNick(req.getParameter("nick"));
		
		System.out.println("findPw()"+member);
		
		
		return memberDao.selectByUserPw(JDBCTemplate.getConnection(),member);
	}
	@Override
	public Member saveEmail(HttpServletRequest req, String tempPW) {
		Member member = new Member();
		member.setUserid(req.getParameter("userid"));
		member.setEmail(req.getParameter("email"));
		member.setUserpw(tempPW);
		
		
		
		return member;
	}
	@Override
	public void chagePW(Member member) {
		
		int res = memberDao.updatePW(JDBCTemplate.getConnection(),member);
		
		if(res>0) {
			JDBCTemplate.commit(JDBCTemplate.getConnection());
		} else {
			JDBCTemplate.rollback(JDBCTemplate.getConnection());
		}
    
    
    
	}
	
	@Override
	public boolean UsernoChk(HttpServletRequest req) {

		//session으로부터 userno값을 받아온다
		Object userno1 = req.getSession().getAttribute("userno");
		System.out.println(userno1);
		
		//detail.jsp로부터 값을 받아온다
		int userno2 = Integer.parseInt(req.getParameter("userno"));
		System.out.println(userno2);
		
		if( userno1.equals(userno2) ) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public void insertPayment(Payment payment) {
		System.out.println(payment.toString());
		memberDao.insertPayment(JDBCTemplate.getConnection(),payment);
	}
	@Override
	public void updateMember(Payment payment) {
		System.out.println(payment.toString());
		memberDao.updateMember(JDBCTemplate.getConnection(),payment);
	}

  
  
}
