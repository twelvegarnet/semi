package dto;

import java.util.Date;

public class Notice {

	private int postno;
	private Date create_date;
	private String title;
	private String inq_content;
	private int userno;
	private int hit;

	@Override
	public String toString() {
		return "Notice [postno=" + postno + ", create_date=" + create_date + ", title=" + title + ", inq_content="
				+ inq_content + ", userno=" + userno + ", hit=" + hit + "]";
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
	public String getInq_content() {
		return inq_content;
	}
	public void setInq_content(String inq_content) {
		this.inq_content = inq_content;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	
	
}
