package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;

public interface FileService {
	
//	/**
//	 * jsp로부터 받은 데이터로 파일업로드를 한다
//	 * 
//	 * @param req
//	 * @param resp
//	 * @param postno
//	 */
//	void fileupload(HttpServletRequest req, HttpServletResponse resp);

	/**
	 * 기준이 될 게시글 번호로 해당하는 첨부파일을 전부 가져온다
	 * 
	 * @param postno1 기준이 될 게시글 번호
	 * @return 게시글 번호에 해당하는 모든 첨부파일
	 */
	List<UploadFile> getFileData(int postno1);

	/**
	 * 해당 게시글의 첨부파일 storedName을 얻어온다
	 * 
	 * @param postno1
	 * @return 조회한 게시글의 첨부파일 storedName
	 */
	UploadFile getStoredName(int postno1);

	

}
