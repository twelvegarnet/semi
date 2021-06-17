package dto;

import java.util.Date;

public class Inquiry {
	private int inquiryno;
	private String inqsort;
	private Date createDate;
	private String title;
	private int userno;
	private String inqcontent;
	
	private String nick;

	@Override
	public String toString() {
		return "Inquiry [inquiryno=" + inquiryno + ", inqsort=" + inqsort + ", createDate=" + createDate + ", title="
				+ title + ", userno=" + userno + ", inqcontent=" + inqcontent + ", nick=" + nick + "]";
	}

	public int getInquiryno() {
		return inquiryno;
	}

	public void setInquiryno(int inquiryno) {
		this.inquiryno = inquiryno;
	}

	public String getInqsort() {
		return inqsort;
	}

	public void setInqsort(String inqsort) {
		this.inqsort = inqsort;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public String getInqcontent() {
		return inqcontent;
	}

	public void setInqcontent(String inqcontent) {
		this.inqcontent = inqcontent;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	
}
