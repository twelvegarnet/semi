package dao.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.ParamData;
import dto.UploadFile;

public interface FileDao {

	/**
	 * 전달파라미터 데이터 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param paramData - 저장할 전달데이터 DTO 객체
	 * @return 삽입 수행 결과값
	 */
	public int insertParam(Connection conn, ParamData paramData, int postno);
	
	/**
	 * 파일 정보 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param uploadFile - 파일의 정보 DTO 객체
	 * @return 삽입 수행 결과값
	 */
	public int insertFile(Connection conn, UploadFile uploadFile, int postno);

	/**
	 * 해당 게시글의 모든 첨부파일을 불러온다
	 * 
	 * @param postno1 첨부파일을 불러올 게시글 번호
	 * @return 첨부파일 목록
	 */
	public List<UploadFile> getFilaData(Connection conn, int postno1);

	/**
	 * 수정된 게시글의 게시글번호, 제목, 본문을 첨부된 파일 테이블에 적용한다
	 * 
	 * @param conn
	 * @param req
	 */
	public int updateParamData(Connection conn, HttpServletRequest req);

	/**
	 * 삭제하려는 게시글의 첨부파일 paramdata를 지운다
	 * 
	 * @param conn
	 * @param req
	 * @return
	 */
	public int deleteParamdata(Connection conn, HttpServletRequest req);

	/**
	 * 삭제하려는 게시글의 첨부파일 uploadfile을 지운다
	 * 
	 * @param conn
	 * @param req
	 * @return
	 */
	public int deleteUploadfile(Connection conn, HttpServletRequest req);

	/**
	 * 상세보기한 게시글의 첨부파일을 얻어온다
	 * 
	 * @param conn
	 * @param postno1
	 * @return
	 */
	public UploadFile getStoredName(Connection conn, int postno1);



}
