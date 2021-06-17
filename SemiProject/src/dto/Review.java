package dto;

import java.util.Date;

public class Review {
private int reviewno;
private String upso_sno;
private Date create_date;    
private String title;
private int userno;         
private String inq_content;
private int star_score;
private String nick;
//
@Override
public String toString() {
	return "Review [reviewno=" + reviewno + ", upso_sno=" + upso_sno + ", create_date=" + create_date + ", title="
			+ title + ", userno=" + userno + ", inq_content=" + inq_content + ", star_score=" + star_score + ", nick="
			+ nick + "]";
}
public int getReviewno() {
	return reviewno;
}
public void setReviewno(int reviewno) {
	this.reviewno = reviewno;
}
public String getUpso_sno() {
	return upso_sno;
}
public void setUpso_sno(String upso_sno) {
	this.upso_sno = upso_sno;
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
public int getStar_score() {
	return star_score;
}
public void setStar_score(int star_score) {
	this.star_score = star_score;
}
public String getNick() {
	return nick;
}
public void setNick(String nick) {
	this.nick = nick;
}




}
