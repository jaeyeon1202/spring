package com.care.root;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired JavaMailSender mailSander;
	
	public void send(String to, String subject, String body) {
		
		MimeMessage msg = mailSander.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mailSander.send(msg);
	}
	
	public void send2() {
		String to ="chlwodus1202@naver.com";
		String subject = "광고";
		
		//String body = "<h1>";
		//body += "sss</h1>";
		
		StringBuffer sb = new StringBuffer();
		sb.append("<h1>제품소개</h1>");
		sb.append("<b>아무냐옹푸바옹푸바옹</b>");
		
		sb.append("<a href='https://www.naver.com/'>네이버</a>");
		sb.append("<img src = 'data:image/jpeg;base64,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'>");
		String body = sb.toString();
		
		MimeMessage msg = mailSander.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mailSander.send(msg);
		
	}
	
	public void send3(String userId, HttpSession session, String email) {
		String userKey = rand();
		session.setAttribute(userId, userKey);
		String body = "<h2>인증 해주세요</h2>"
		+"<a href='http://localhost:8088/root/check?userId="+ userId + "&userKey="+userKey +"'>인증하기</a>";
		
		MimeMessage msg = mailSander.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			helper.setTo(email);
			helper.setSubject("인증해주세요");
			helper.setText(body, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mailSander.send(msg);
		
	}
	
	private String rand() {
		Random ran = new Random();
		String str = "";
		while(str.length()<=20) {
			int num = ran.nextInt(75)+48;
			if((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num<= 122)) {
				str += (char)num;
			}
		}
		return str;
	}
}
