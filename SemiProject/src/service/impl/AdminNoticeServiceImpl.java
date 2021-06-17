package service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import common.Paging;
import dto.Notice;
import dto.NoticeFile;
import dao.face.NoticeDao;
import dao.impl.NoticeDaoImpl;
import service.face.AdminNoticeService;
import service.face.NoticeService;

public class AdminNoticeServiceImpl implements AdminNoticeService {

	private NoticeDao noticeDao = new NoticeDaoImpl();
	
	@Override
	public List<Notice> getList() {
		
		
		return noticeDao.selectAll(JDBCTemplate.getConnection());
	}
	
	

	@Override
	public Notice getPostno(HttpServletRequest req) {
		
		Notice postno = new Notice();
		
		String param = req.getParameter("postno");
		
		if( param != null && !"".equals(param)) {
			
			postno.setPostno( Integer.parseInt(param));
		} 
		
		return postno;
	}

	@Override
	public Notice view(int post) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//조회수 증가
		if( noticeDao.updateHit(conn, post) >= 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		
		
		return noticeDao.selectNoticeByPostno(conn, post);
	}

	
	
	
	
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//Notice 테이블의 총 게시글 수를 조회한다
		int totalCount = noticeDao.selectCntAll(JDBCTemplate.getConnection());
		
		Paging paging = new Paging(totalCount, curPage);
		
		System.out.println(totalCount);
		System.out.println(curPage);
		
		return paging;
	}

	@Override
	public List<Notice> getList(Paging paging) {
		
		//게시글 전체조회 결과 처
		return noticeDao.selectAll(JDBCTemplate.getConnection(), paging);
	}






	@Override
	public NoticeFile viewFile(int post) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		
		return noticeDao.selectFileByPostno(conn, post);
	}



	@Override
	public void deleteNotice(HttpServletRequest req) {

		Connection conn = JDBCTemplate.getConnection();
				
		if( noticeDao.deleteNoticeFile(conn, req) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		if( noticeDao.deleteNotice(conn, req) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}

	
	
	@Override
	public void write(HttpServletRequest req) {
		
		//게시글 정보를 저장할 객
		Notice adminNotice = null;
		
		//첨부파일 정보를 저장할 객체
		NoticeFile noticeFile = null;
		
		//파일업로드 형태의 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		//multipart/form-data 인코딩으로 전송되지 않았을 경우
		if( !isMultipart ) {
			System.out.println("[ERROR] multipart/form-data 형식이 아님" );
			
			return;	//fileupload() 메소드 실행 중지
		}
		
		//게시글 정보 저장할 객체 생성
		adminNotice = new Notice();
		
		//디스트기반 아이템 팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//메모리 처리 사이즈 지정 
		factory.setSizeThreshold( 1 * 1024 * 1024 ); //1MB 
		
		
		//임시 저장소 설정
		File repository = new File(req.getServletContext().getRealPath("tmp"));
		repository.mkdir();
		
		factory.setRepository(repository);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//전달 데이터 파싱 
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} 
		
		
		//추출된 전달파라미터 처리 반복자
		Iterator<FileItem> iter = items.iterator();
		
		//모든 요청 정보 처리하기
		while( iter.hasNext() ) {
			FileItem item = iter.next();
			
			// 1) 빈 파일 처리
			if( item.getSize() <= 0 ) continue;
			
			// 2) 일반적인 요청 데이터 처리
			if( item.isFormField() ) {
				
				String key = item.getFieldName(); //키 추출
				if( "title".equals(key) ) { //전달파라미터 name이 "title"
					try {
						adminNotice.setTitle( item.getString("utf-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					} 
					System.out.println("adminnotice : " + adminNotice);
					
					
				} else if ( "content".equals(key) ) { //전달파라미터 name이 "content"
					try {
						adminNotice.setInq_content( item.getString("utf-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				} //key값 비교 if end
				
			} // if( item.isFormField() ) end - 폼필드 확
			
			
			// 3) 파일 처리
			if( !item.isFormField() ) {
				
				// --- UUID 생성 ---
				UUID uuid = UUID.randomUUID(); //랜덤 UID 생성
				String u = uuid.toString().split("-")[0]; //8자리 uid
				//-----------------
				
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				String rename = sdf.format(new Date());
				
				
				//확장자는 원본파일 확장자 얻어오기
				String origin = item.getName(); //원본파일 이름
				
				System.out.println( "origin 체크 : " + origin);
				
				int dotIdx = origin.lastIndexOf(".");//가장 마지막 "."의 인덱스
				
				//확장자
				String ext = origin.substring(dotIdx + 1);
				
				//서버에 저장될 파일의 이름
				String stored = rename + "." + ext;
				
				System.out.println("[TEST] 원본 파일명 : " + origin);
				System.out.println("[TEST] 저장될 파일명 : " + stored);
				
				noticeFile = new NoticeFile();
				
				//업로드된 파일의 정보를 DTO에 저장하기
				noticeFile.setOriginName(origin);
				noticeFile.setStoredName(stored);   
				
				//--로컬 저장소의 파일 객체 생성 ---
				File upFolder = new File(req.getServletContext().getRealPath("upload")); // 업로드될 폴더 경로  
				upFolder.mkdir();
				
				File up = new File(
						upFolder
						, item.getName() + "_" + u //원본파일명_uid
						);
				//---------------------------------
				
				// ---- 첨부파일 정보 객체 ----
				noticeFile = new NoticeFile(); //객체 생성
				noticeFile.setOriginName( item.getName()); //원본 파일명
				noticeFile.setStoredName( item.getName()+"_"+u); //저장파일명
				noticeFile.setFilesize((int)item.getSize());
				//------------------------
				
				try {
					item.write(up);   //실제 업로드
					item.delete(); //임시 파일 삭제  
				} catch (Exception e) {
					e.printStackTrace();
				}
				//------------------------
				
			} // 파일 처리 end
			
			
		} // while( iter.hasNext() ) end - FileItem 반복 처리
		
		
		//DB데이터 입력
		Connection conn = JDBCTemplate.getConnection();
		System.out.println("session : " + (int) req.getSession().getAttribute("userno"));
		//게시글 작성자 id입력
		adminNotice.setUserno( (int) req.getSession().getAttribute("userno"));
		
		int postno = noticeDao.selectPostno(conn);
		
		
		
		//게시글 정보가 있을 경우
		if(adminNotice != null ) {
			
			//게시글 번호 입력
			adminNotice.setPostno(postno);
			
			//게시글 제목이 작성되지 않으면 변경
			if(adminNotice.getTitle()==null || "".equals(adminNotice.getTitle())) {
				adminNotice.setTitle("(제목없음)");
			}
			
			//게시글 삽입
			if( noticeDao.insert(conn, adminNotice) > 0 ) {
				JDBCTemplate.commit(conn);
				System.out.println("커밋완");
			} else {
				JDBCTemplate.rollback(conn);
				System.out.println("커밋실패");
			}
		}
		
		//첨부파일 정보가 있을 경우
		if( noticeFile != null ) {
			//게시글 번호 입력
			noticeFile.setPostno(postno);
			
			//첨부파일 삽입
			if( noticeDao.insertFile(conn, noticeFile) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}
		
		
	}
	
	
	@Override
	public void update(HttpServletRequest req) {
		
		//게시글 정보를 저장할 객
		Notice adminNotice = null;
		
		//첨부파일 정보를 저장할 객체
		NoticeFile noticeFile = null;
		
		//파일업로드 형태의 데이터가 맞는지 검사
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		//multipart/form-data 인코딩으로 전송되지 않았을 경우
		if( !isMultipart ) {
			System.out.println("[ERROR] multipart/form-data 형식이 아님" );
			
			return;	//fileupload() 메소드 실행 중지
		}
		
		//게시글 정보 저장할 객체 생성
		adminNotice = new Notice();
		
		//디스트기반 아이템 팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//메모리 처리 사이즈 지정 
		factory.setSizeThreshold( 1 * 1024 * 1024 ); //1MB 
		
		
		//임시 저장소 설정
		File repository = new File(req.getServletContext().getRealPath("tmp"));
		repository.mkdir();
		
		factory.setRepository(repository);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//전달 데이터 파싱 
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} 
		
		int postno = 0 ;
		//추출된 전달파라미터 처리 반복자
		Iterator<FileItem> iter = items.iterator();
		
		//모든 요청 정보 처리하기
		while( iter.hasNext() ) {
			FileItem item = iter.next();
			
			// 1) 빈 파일 처리
			if( item.getSize() <= 0 ) continue;
			
			// 2) 일반적인 요청 데이터 처리
			if( item.isFormField() ) {
				
				String key = item.getFieldName(); //키 추출
				if( "title".equals(key) ) { //전달파라미터 name이 "title"
					try {
						adminNotice.setTitle( item.getString("utf-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					} 
					System.out.println("adminnotice : " + adminNotice);
					
					
				} else if ( "content".equals(key) ) { //전달파라미터 name이 "content"
					try {
						adminNotice.setInq_content( item.getString("utf-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				} else if ("postno".equals(key)) {
					try{
						postno = Integer.parseInt(item.getString("utf-8"));//key값 비교 if end
					}catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				}
				
			} // if( item.isFormField() ) end - 폼필드 확
			
			
			// 3) 파일 처리
			if( !item.isFormField() ) {
				
				// --- UUID 생성 ---
				UUID uuid = UUID.randomUUID(); //랜덤 UID 생성
				String u = uuid.toString().split("-")[0]; //8자리 uid
				//-----------------
				
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				String rename = sdf.format(new Date());
				
				
				//확장자는 원본파일 확장자 얻어오기
				String origin = item.getName(); //원본파일 이름
				
				System.out.println( "origin 체크 : " + origin);
				
				int dotIdx = origin.lastIndexOf(".");//가장 마지막 "."의 인덱스
				
				//확장자
				String ext = origin.substring(dotIdx + 1);
				
				//서버에 저장될 파일의 이름
				String stored = rename + "." + ext;
				
				System.out.println("[TEST] 원본 파일명 : " + origin);
				System.out.println("[TEST] 저장될 파일명 : " + stored);
				
				noticeFile = new NoticeFile();
				
				//업로드된 파일의 정보를 DTO에 저장하기
				noticeFile.setOriginName(origin);
				noticeFile.setStoredName(stored);   
				
				//--로컬 저장소의 파일 객체 생성 ---
				File upFolder = new File(req.getServletContext().getRealPath("upload")); // 업로드될 폴더 경로  
				upFolder.mkdir();
				
				File up = new File(
						upFolder
						, item.getName() + "_" + u //원본파일명_uid
						);
				//---------------------------------
				
				// ---- 첨부파일 정보 객체 ----
				noticeFile = new NoticeFile(); //객체 생성
				noticeFile.setOriginName( item.getName()); //원본 파일명
				noticeFile.setStoredName( item.getName()+"_"+u); //저장파일명
				noticeFile.setFilesize((int)item.getSize());
				//------------------------
				
				try {
					item.write(up);   //실제 업로드
					item.delete(); //임시 파일 삭제  
				} catch (Exception e) {
					e.printStackTrace();
				}
				//------------------------
				
			} // 파일 처리 end
			
			
		} // while( iter.hasNext() ) end - FileItem 반복 처리
		
		
		//DB데이터 입력
		Connection conn = JDBCTemplate.getConnection();
		//게시글 작성자 id입력
		adminNotice.setUserno( (int) req.getSession().getAttribute("userno"));
		
		
		
		
		//게시글 정보가 있을 경우
		if(adminNotice != null ) {
			
			//게시글 번호 입력
			adminNotice.setPostno(postno);
			
			//게시글 제목이 작성되지 않으면 변경
			if(adminNotice.getTitle()==null || "".equals(adminNotice.getTitle())) {
				adminNotice.setTitle("(제목없음)");
			}
			
			//게시글 삽입
			if( noticeDao.update(conn, adminNotice) > 0 ) {
				JDBCTemplate.commit(conn);
				System.out.println("커밋완");
			} else {
				JDBCTemplate.rollback(conn);
				System.out.println("커밋실패");
			}
		}
		
		//첨부파일 정보가 있을 경우
		if( noticeFile != null ) {
			//게시글 번호 입력
			noticeFile.setPostno(postno);
			
			//첨부파일 삽입
			if( noticeDao.updateFile(conn, noticeFile) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}
		
		
	}
	
	
	
	
	
	
	


}
