package dto;

import java.util.Date;

public class NoticeFile {

	private int fileno;
	private int postno;
	private String originName;
	private String storedName;
	private int filesize;
	private Date writeDate;
	
	@Override
	public String toString() {
		return "NoticeFile [fileno=" + fileno + ", postno=" + postno + ", originName=" + originName + ", storedName="
				+ storedName + ", filesize=" + filesize + ", writeDate=" + writeDate + "]";
	}
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public int getPostno() {
		return postno;
	}
	public void setPostno(int postno) {
		this.postno = postno;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getStoredName() {
		return storedName;
	}
	public void setStoredName(String storedName) {
		this.storedName = storedName;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
}
