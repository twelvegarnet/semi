
package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Member;
import dto.Payment;

public interface MemberDao {
	/**
	 * ID, PW 비교해서 디비에 저장되어있는지 없는지 판단
	 * @param connection
	 * @param member 
	 * @return - 정보가 있으면 TRUE, 없으면 FALSE
	 */
	int selectCntMemberUseridUserpw(Connection conn, Member member);

	Member selectMemberByUserid(Connection conn, Member member);

	int insertByMemberInfo(Connection conn, Member member);

	/**
	 * 모든 회원정보 조회
	 * 
	 * @param connection
	 * @return 회원 테이블 전체 데이터
	 */
	List<Member> getAllUser(Connection conn);

	Member getUserno(Connection conn, Member m);

	/**
	 * id로 id가 있는지 조회 있으면  중복
	 * @param connection
	 * @param userid
	 * @return
	 */
	int selectById(Connection conn, String userid);
	/**
	 * nick로 nick이 있는지 조회 있으면 중복
	 * @param connection
	 * @param nick
	 * @return
	 */
	int selectByNick(Connection conn, String nick);

	/**
	 * 유저정보 조회
	 * @param connection
	 * @param member
	 * @return
	 */
	Member selectByUserInfo(Connection connection, Member member);

	/**
	 * 유저정보 업데이트
	 * @param connection
	 * @param member
	 * @return
	 */
	int updateByNickEmail(Connection connection, Member member);

	int delete(Connection connection, Object userid);

	/**
	 * username, userPW를 활용하여 USERID조회
	 * @param connection
	 * @param member
	 * @return
	 */
	Member selectByUserId(Connection connection, Member member);

	/**
	 * userid, nick을 활용하여 pw조회
	 * @param connection
	 * @param member
	 * @return
	 */
	Member selectByUserPw(Connection connection, Member member);

	/**
	 * 업데이트 비밀번호
	 * @param connection
	 * @param member
	 * @return
	 */
	int updatePW(Connection conn, Member member);
	
	void insertPayment(Connection conn, Payment payment);

	void updateMember(Connection connection, Payment payment);


}
