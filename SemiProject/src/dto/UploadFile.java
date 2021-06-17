package dto;

public class UploadFile {

	private int fileno;
	private int postno;
	private String originName;
	private String storedName;
	
	
	@Override
	public String toString() {
		return "UploadFile [fileno=" + fileno + ", postno=" + postno + ", originName=" + originName + ", storedName="
				+ storedName + "]";
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
	
	
	
}
