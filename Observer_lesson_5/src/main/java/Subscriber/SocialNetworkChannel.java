package Subscriber;

import java.util.ArrayList;
import java.util.List;

public class SocialNetworkChannel {

    private List<Subscriber> subscribers = new ArrayList<Subscriber>();
    private String message;

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        System.out.println("Новое сообщение: " + message);
        notifyAllSubscribers();
    }

    public void accede(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println("Подписан: " + subscriber.getClass().getSimpleName());
    }

    public void notifyAllSubscribers() {
        for (Subscriber subscriber : subscribers) {
            System.out.println("Сообщение отправлено: " + subscriber.getClass().getSimpleName());
            subscriber.update();
        }
    }
}
