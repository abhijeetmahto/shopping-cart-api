package org.jsp.api.Service;

import org.jsp.api.Dto.EmailConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class ShoppingCartMailService {
	@Autowired
	private JavaMailSender javaMailSender;
	public String sendMail(EmailConfiguration configuration) {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(configuration.getUser().get("email"));
			helper.setSubject(configuration.getSubject());
			helper.setText(configuration.getText());
			javaMailSender.send(message);			
			return "Mail Send Successfully";
		}catch(Exception e) {
			e.printStackTrace();
			return "Unable to send mail";
		}
	}
}
