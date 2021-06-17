package dto;

import java.util.Date;

public class InquiryAnswer {
	private int answerno;
	private String answercontent;
	private Date createDate;
	private int inquiryno;
	private int userno;
	
	@Override
	public String toString() {
		return "InquiryAnswer [answerno=" + answerno + ", answercontent=" + answercontent + ", createDate=" + createDate
				+ ", inquiryno=" + inquiryno + ", userno=" + userno + "]";
	}

	public int getAnswerno() {
		return answerno;
	}

	public void setAnswerno(int answerno) {
		this.answerno = answerno;
	}

	public String getAnswercontent() {
		return answercontent;
	}

	public void setAnswercontent(String answercontent) {
		this.answercontent = answercontent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getInquiryno() {
		return inquiryno;
	}

	public void setInquiryno(int inquiryno) {
		this.inquiryno = inquiryno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}
	
	
	
}
