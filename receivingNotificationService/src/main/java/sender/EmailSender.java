package sender;

import entity.User;
import repository.Sender;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

public class EmailSender implements Sender {

    private User user;
    private Properties props;

    public EmailSender (User user) {
        this.user= user;

        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

    @Override
    public void sender() {
        Session session = Session.getDefaultInstance(props);

        try {
            // Создание объекта MimeMessage по умолчанию
            MimeMessage message = new MimeMessage(session);
            //от кого
            message.setFrom(new InternetAddress(user.getFirstName()));
            //кому
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
            //Заголовок письма
            message.setSubject("Это тема письма!");
            //Содержимое
            message.setText("Это актуальное сообщение");
            // Отправить сообщение
            Transport.send(message);
            System.out.println("Сообщение успешно отправлено....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
