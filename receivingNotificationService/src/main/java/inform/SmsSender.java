package inform;

import entity.User;
import repository.Sender;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SmsSender implements Sender {

    private User user;
    private Properties props;

    String smtphost = "MySMSHost.com";
    String from = "mySMSUsername@MySMSHost.com";
    Transport myTransport;

    public SmsSender (User user) {
        this.user= user;

        props = new Properties();
        myTransport = null;
    }

    @Override
    public void sender() {

        try {
            Session session = Session.getDefaultInstance(props);
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(user.getPhoneNumber())};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("My SMS Compression Information");
            msg.setText("Это актуальное сообщение");;
            msg.setSentDate(new Date());
            myTransport = session.getTransport("smtp");
            myTransport.connect(smtphost, user.getFirstName(), user.getPassword());
            msg.saveChanges();
            myTransport.sendMessage(msg, msg.getAllRecipients());
            myTransport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
