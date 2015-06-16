package DomainLayer.ServiceLocator;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

	public class Missatgeria {
	public boolean enviaMissatge(String missatge,String email)
	{
	// Recipient's email ID needs to be mentioned.
	String to = email;
	
	// Sender's email ID needs to be mentioned
	String from = "JOC2048@gmail.com";
	
	// Assuming you are sending email from localhost
	String host = "localhost";
	
	// Get system properties
	Properties properties = System.getProperties();
	
	// Setup mail server
	properties.setProperty("mail.smtp.host", host);
	
	// Get the default Session object.
	Session session = Session.getDefaultInstance(properties);
	
	try{
	   // Create a default MimeMessage object.
	   MimeMessage message = new MimeMessage(session);
	
	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));
	
	   // Set To: header field of the header.
	   message.addRecipient(Message.RecipientType.TO,
	                            new InternetAddress(to));
	
	   // Set Subject: header field
	   message.setSubject("Puntuacio del joc 2048!");
	
	   // Now set the actual message
	   message.setText(missatge);
	
	   // Send message
	   Transport.send(message);
	   System.out.println("Sent message successfully....");
	}catch (MessagingException mex) {
	   mex.printStackTrace();
	}
	
	return true;
	}

}

