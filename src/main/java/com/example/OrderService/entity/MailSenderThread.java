package com.example.OrderService.entity;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class MailSenderThread  implements  Runnable{
    Order order;
    public MailSenderThread(Order order)
    {
        this.order=order;
    }
    public void run()
    {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("surtiyanibhavesh29@gmail.com", "bhavesh2998");
                }
            });
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress("surtiyanibhavesh29@gmail.com", false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(order.getUserId()));
            msg.setSubject("Unisole Order Placed");
            msg.setContent("Order SuccessFully placed With OrderId="+order.getOrderId()+" \r\n Thanks For Shopping", "text/html");
            msg.setSentDate(new Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("Order SuccessFully Placed AT Unisole", "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            MimeBodyPart attachPart = new MimeBodyPart();

//        attachPart.attachFile("/var/tmp/image19.png");
//        multipart.addBodyPart(attachPart);
//        msg.setContent(multipart);
            Transport.send(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
