package team.t.t.service;

import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.HtmlEmail;

public class MailCode implements Action {
	// https://hunit.tistory.com/306
	// https://t1st0ry.tistory.com/58
	// https://joont.tistory.com/52

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MailCode");
		request.setCharacterEncoding("utf-8");
		
        HttpSession session = request.getSession();
		// Mail Server 설정
	
        String hostSMTP = "smtp.naver.com";
		String hostSMTPid = "thsalstn0@naver.com";
		String hostSMTPpw = "alstn123";

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "thsalstn0@naver.com";
		String fromName = "운영자";
		String subject = "인증코드";

		// 받는 사람 E-Mail 주소
		String mail = request.getParameter("mail");
	
         AuthCode auth = new AuthCode();
         String str =auth.authCode();
         System.out.println("전체 인증코드 ="+str);
		 
        
		try {
			HtmlEmail email = new HtmlEmail();
		//email.setDebug(true);
			email.setCharset("utf-8");
			email.setHostName(hostSMTP);
			email.setSmtpPort(587);

			email.setAuthentication(hostSMTPid, hostSMTPpw);
			email.addTo(mail);
			email.setFrom(fromEmail, fromName);

			email.setSubject(subject);
			email.setHtmlMsg("<p>"+str+"<p>");
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
		session.setAttribute("str", str);
		
		return null;
	}

}
