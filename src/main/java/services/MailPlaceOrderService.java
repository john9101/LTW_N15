package services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

public class MailPlaceOrderService implements IMailServices{

    private String email;
    private String emailTo;

    private Timestamp dateOrder;

    public MailPlaceOrderService(String email, String emailTo, Timestamp dateOrder) {
        this.email = email;
        this.emailTo = emailTo;
        this.dateOrder = dateOrder;
    }

    @Override
    public void send() throws MessagingException {
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailProperties.getEmail(), MailProperties.getPassword());
            }
        };

        Session session = Session.getInstance(MailProperties.getProperties(), auth);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(MailProperties.getEmail()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
        String subjectMess = "ĐƠN HÀNG CỦA BẠN";
        message.setSubject(subjectMess);
        message.setReplyTo(null);

//        InputStream inputStream = MailProperties.class.getClassLoader().getResourceAsStream("templates/templateEmailVerify.html");
        String htmlContent = "hello";
        message.setContent(htmlContent, "text/html; charset = UTF-8");
        Transport.send(message);
    }

//    private String htmlTemplate(InputStream inputStream) {
//        String template = "";
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
//        String line;
//
//        while (true) {
//            try {
//                if ((line = reader.readLine()) == null) break;
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            template += line + "\n";
//        }
//        template = template.replace("%%EMAIL%%", emailFrom);
//        return template;
//    }
}
