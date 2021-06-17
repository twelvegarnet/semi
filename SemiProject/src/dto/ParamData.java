package dto;

public class ParamData {

	private int datano;
	private int postno;
	private String title;
	private String filecontent;
	
	
	@Override
	public String toString() {
		return "ParamData [datano=" + datano + ", postno=" + postno + ", title=" + title + ", content=" + filecontent + "]";
	}


	public int getDatano() {
		return datano;
	}


	public void setDatano(int datano) {
		this.datano = datano;
	}


	public int getPostno() {
		return postno;
	}


	public void setPostno(int postno) {
		this.postno = postno;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return filecontent;
	}


	public void setContent(String content) {
		this.filecontent = content;
	}
	
	
	
	
	

	
	
	
}
