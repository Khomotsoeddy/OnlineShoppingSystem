/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package za.ac.tut.business;

import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import za.ac.tut.entity.Order;

/**
 *
 * @author Asus
 */
@Stateless
public class OrderConfirmation implements OrderConfirmationLocal {

    @Override
    public void orderConfirm(String emailAddress,Order order) {
        final String fromEmail = "powerwm111@gmail.com";
        final String password = "Power@123";
        //String toEmail ;

        Properties ppt = new Properties();
        ppt.put("mail.smtp.host", "smtp.gmail.com");
        ppt.put("mail.smtp.port", 587);
        ppt.put("mail.smtp.auth", "true");
        ppt.put("mail.smtp.starttls.enable", "true");
        //ppt.put("mail.smtp.socketFactory.port", "587");
        //ppt.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(ppt, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));

            message.setSubject("Order Confirmation Email");

            message.setText("you have successfully ordered"+"\n Track your order using this order number " + order.getOrderNo());

            Transport.send(message);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
}
