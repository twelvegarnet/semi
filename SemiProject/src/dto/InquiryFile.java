package dto;

public class InquiryFile {
	private int fileno;
	private int inquiryno;
	private String originName;
	private String storedName;
	private int filesize;
	
	
	@Override
	public String toString() {
		return "InquiryFile [fileno=" + fileno + ", inquiryno=" + inquiryno + ", originName=" + originName
				+ ", storedName=" + storedName + ", filesize=" + filesize + "]";
	}


	public int getFileno() {
		return fileno;
	}


	public void setFileno(int fileno) {
		this.fileno = fileno;
	}


	public int getInquiryno() {
		return inquiryno;
	}


	public void setInquiryno(int inquiryno) {
		this.inquiryno = inquiryno;
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
	
	
	

}
