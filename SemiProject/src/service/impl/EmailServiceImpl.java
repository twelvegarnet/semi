package service.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import common.JDBCTemplate;
import dao.face.EmailDao;
import dao.impl.EmailDaoImpl;
import dto.Member;
import service.face.EmailService;
import util.MailAuth;

public class EmailServiceImpl implements EmailService {

	EmailDao emailDao = new EmailDaoImpl();
	
	@Override
	public void send(Member member) {

		// FROM
				final String FROM = "imlim1440@gmail.com"; // <<------------------------------수정하세요
				final String FROMNAME = "맛객"; // <<------------------------------수정하세요

				// TO
				final String TO = member.getEmail(); // <<------------------------------수정하세요

				// 메일 제목
				final String SUBJECT = "[맛객] 임시 비밀번호입니다"; // <<------------------------------수정하세요

				// 메일 본문
				final String BODY = String.join(
						"<h1>구글 SMTP Email Test</h1>",
						"임시 비밀번호는 " + member.getUserpw() + " 입니다."
						+ "<p>마이페이지에서 비밀번호 재설정을 하여 새 비밀번호로 바꿔주세요!</p>"); // <<------------------------------수정하세요

				// 인증 객체
				Authenticator auth = new MailAuth("imlim1440@gmail.com", "imlim1995."); // <<------------------------------수정하세요
				
				
				// 연결 설정
				Properties props = System.getProperties();
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "587");
				
				// 메일 세션 객체 생성
				Session session = Session.getDefaultInstance(props, auth);

				// 메시지 생성
				MimeMessage msg = new MimeMessage(session);
				try {
					msg.setFrom(new InternetAddress(FROM, FROMNAME));
					msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
					msg.setSubject(SUBJECT);
					msg.setContent(BODY, "text/html;charset=utf-8");

					System.out.println("Sending...");

					//메시지 보내기
					Transport.send(msg);
					
					System.out.println("Email sent!");

				} catch (NoSuchProviderException e) {
					e.printStackTrace();
					
				} catch (MessagingException e) {
					e.printStackTrace();
					
					System.out.println("The email was not sent.");
					System.out.println("Error message: " + e.getMessage());
					
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
	}

}
