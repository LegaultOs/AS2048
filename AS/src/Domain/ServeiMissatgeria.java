package Domain;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class ServeiMissatgeria {
	
	/*public static void main(String[] args) {
		System.out.println("va");
		enviarMissatge("Prueba");
		
		//main para pruebas
	}*/

	
	public static void enviarMissatge(String miss)//irá sin static , pero se queda así para pruebas
													//esto va, lo que pasa es que necesitamos un server de correo o buscar la manera de usar uno externo como el de gmail.
	{
		
		// Recipient's email ID needs to be mentioned.
	      String to = "oscaracso90@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "web@gmail.com";

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
	         message.setSubject("This is the Subject Line!");

	         // Now set the actual message
	         message.setText(miss);

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
		
	}
}
