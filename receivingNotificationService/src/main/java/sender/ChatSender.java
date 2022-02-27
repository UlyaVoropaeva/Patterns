package sender;

import entity.User;
import repository.Sender;

import java.util.Properties;

public class ChatSender implements Sender {

    private User user;
    private Properties props;

    public ChatSender (User user) {
        this.user = user;
    }

    @Override
    public void sender() {

            System.out.println("Send in chat");
    }
}
