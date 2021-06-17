
package service.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import dao.face.FileDao;
import dao.impl.FileDaoImpl;
import dto.ParamData;
import dto.UploadFile;
import service.face.FileService;

public class FileServiceImpl implements FileService {

	//DAO 객체
	private FileDao fileDao = new FileDaoImpl();

	@Override
	public List<UploadFile> getFileData(int postno1) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		return fileDao.getFilaData(conn, postno1);
	}

	@Override
	public UploadFile getStoredName(int postno1) {

		Connection conn = JDBCTemplate.getConnection();
		
		return fileDao.getStoredName(conn, postno1);
	}


	
}
