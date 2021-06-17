package dto;

import java.util.Date;

public class Recipe {

	private int postno;
	private Date create_date;
	private String title;
	private int userno;
	private String inq_content;
	private int views;
	
	
	@Override
	public String toString() {
		return "Recipe [postno=" + postno + ", create_date=" + create_date + ", title=" + title + ", userno=" + userno
				+ ", inq_content=" + inq_content + ", views=" + views + "]";
	}


	public int getPostno() {
		return postno;
	}


	public void setPostno(int postno) {
		this.postno = postno;
	}


	public Date getCreate_date() {
		return create_date;
	}


	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getUserno() {
		return userno;
	}


	public void setUserno(int userno) {
		this.userno = userno;
	}


	public String getInq_content() {
		return inq_content;
	}


	public void setInq_content(String inq_content) {
		this.inq_content = inq_content;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}
	
	
	
	
}

