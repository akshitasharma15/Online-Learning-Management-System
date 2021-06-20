package college_management;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class Email {
	public Email(String email, String name) {

		String username = "testhorizon6@gmail.com";
		String password = "Test@123";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("testhorizon6@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Confirmation mail for registeration on LMS");
			message.setText("Dear " + name + ",\n\n You have registered on Lms. You can login to your account now.");

			Transport.send(message);

			// System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public Email() {
		
	}

	public void quizEmail(String email, String name, String subject) {

		String username = "testhorizon6@gmail.com";
		String password = "Test@123";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("testhorizon6@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Quiz Response");
			message.setText(name + " has submitted a response for " + subject + " quiz");

			Transport.send(message);

			// System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
