package com.onetrillion.trip.service.mail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.onetrillion.trip.user.UserDTO;

public class MailUtil {
	
	public void sendMail(UserDTO dto) {
		
		String charSet = "UTF-8";
		String hostSMTP = "smtp.naver.com";
		String hostSMTPid = "dyong199311@naver.com";
		String hostSMTPpw = "tkdgus3745";
		
		String fromEmail  = "dyong199311@naver.com";
		String fromName = "OneTrillionManager";
		
		String subject = "";
		String msg ="";
		
		subject = "[OneTrillion] 임시 비밀번호 발급 안내";
		msg += "<div align='left'>";
		msg += "<h3>";
		msg += dto.getU_id() + "님의 임시 비밀번호입니다. <br> 비밀번호를 변경하여 사용해주세요.</h3>";
		msg += "<p>임시 비밀번호 : ";
		msg += dto.getU_pwd() + "</p></div>";
		
		
		try {
			// 이메일 전송부분
			String mailRecipient = dto.getU_email();
			HtmlEmail mail = new HtmlEmail();
			mail.setDebug(true);
			mail.setCharset(charSet);
			mail.setSSLOnConnect(true);
			mail.setHostName(hostSMTP);
			mail.setSmtpPort(587);
			mail.setAuthentication(hostSMTPid, hostSMTPpw);
			mail.setStartTLSEnabled(true);
			mail.addTo(mailRecipient, charSet);
			mail.setFrom(fromEmail, fromName, charSet);
			mail.setSubject(subject);
			mail.setHtmlMsg(msg);
			mail.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	
	}
}
