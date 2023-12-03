package services;

import javax.mail.MessagingException;

public interface IMailServices {
    void sendMail() throws MessagingException;
}
