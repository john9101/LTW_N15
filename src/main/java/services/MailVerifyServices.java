package services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class MailVerifyServices implements IMailServices {
    private String emailTo;
    private String username;
    private String tokenVerify;

    public MailVerifyServices(String emailTo, String username, String tokenVerify) {
        this.emailTo = emailTo;
        this.username = username;
        this.tokenVerify = tokenVerify;
    }

    @Override
    public void sendMail() throws MessagingException {
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailProperties.getEmail(), MailProperties.getPassword());
            }
        };

//        Create Session
        Session session = Session.getInstance(MailProperties.getProperties(), auth);
//        Create message
        Message message = new MimeMessage(session);
//        From
        message.setFrom(new InternetAddress(MailProperties.getEmail()));
//        To
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo, false));
//        Subject
        message.setSubject("Test");
//        Set no reply
        message.setReplyTo(null);
//        Content
        InputStream is = MailProperties.class.getClassLoader().getResourceAsStream("templateEmailVerify.html");
        String htmlTemplate = htmlTemplate(is);
        message.setContent(htmlTemplate, "text/html; charset = UTF-8");

//        Send mail
        Transport.send(message);
    }

    private  String htmlTemplate(InputStream is) {
        String template = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String line;

        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            template += line + "\n";
        }
        if (username != null) {
            template = template.replace("%%USERNAME%%", username);
        }
        template = template.replace("%%TOKENVERIFY%%", tokenVerify);
        return template;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTokenVerify() {
        return tokenVerify;
    }

    public void setTokenVerify(String tokenVerify) {
        this.tokenVerify = tokenVerify;
    }
}