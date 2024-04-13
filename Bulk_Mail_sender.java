package com.learncoding.Bulk_Email_Sender;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Bulk_Mail_sender {

	public static void main(String[] args) {
		final String username="tahanaushad57106@gmail.com";
		final String password="udzp iwxl pjvu yvtz";
		String host="smtp.gmail.com";
		int port=578;
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.connectiontimeout", "5000"); // 5 seconds
        properties.put("mail.smtp.timeout", "5000"); // 5 seconds
        properties.put("mail.smtp.ssl.trust", "*");
 
        Session session = Session.getInstance(properties, new Authenticator() {
        	protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
		});
        session.setDebug(true);
        try {
            // Create message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tahanaushad57106@gmail.com"));
            message.setSubject("Email API Testing");
            message.setContent("Your HTML Email Content", "text/html");


            // Add recipients
            String[] recipients = {"aatifkhan2105@gmail.com", "mdj2334@gmail.com"};
            for (String recipient : recipients) {
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                // Send message
                Transport.send(message);
            }

            System.out.println("Emails sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}