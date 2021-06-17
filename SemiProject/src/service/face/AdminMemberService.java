package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Member;
import inquiry.util.Paging;

public interface AdminMemberService {
	
	/**
	 * 유저 내역 전체 조회하기(페이징 처리)
	 * 
	 * @return List<Member> - 조회된 유저 전체 리스트
	 */
	public List<Member> getMemList();

	
	/**
	 * 요청파라미터 가져오기
	 */
	public Member getUserno(HttpServletRequest req);

	
	/**
	 * 회원 정보 삭제하기
	 */
	public void deleteMem(Member member);

}
