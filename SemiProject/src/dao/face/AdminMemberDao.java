package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Member;
import inquiry.util.Paging;

public interface AdminMemberDao {

	/**
	 * Member 테이블 목록 전체 조회하기
	 * 
	 * @param connection - DB연결 객체
	 * @param paging - 페이징 객체
	 * @return List<Member> - Member 테이블 전체 리스트
	 */
	public List<Member> selectAllMemList(Connection conn);

	
	/**
	 * 회원 정보 삭제하기
	 * 	참조무결성으로 인해 DB처리는 UPDATE로 탈퇴회원이라고 표현함
	 * 
	 * @param connection - DB연결 객체
	 */
	public int deleteMem(Connection conn, Member member);

}
