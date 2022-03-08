import Subscriber.FirstSubscriber;
import Subscriber.SecondSubscriber;
import Subscriber.SocialNetworkChannel;
import Subscriber.ThirdSubscriber;

public class App {

    public static void main(String[] args) {

        SocialNetworkChannel channel = new SocialNetworkChannel();

        new FirstSubscriber(channel);
        new SecondSubscriber(channel);
        new ThirdSubscriber(channel);

        System.out.println("----------------------------------------");
        String text = "Сообщение №1";
        channel.setMessage(text);
        System.out.println("----------------------------------------");
        text = "Сообщение №2";
        channel.setMessage(text);
    }
}