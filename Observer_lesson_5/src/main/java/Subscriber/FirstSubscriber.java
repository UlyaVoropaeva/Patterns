package Subscriber;

public class FirstSubscriber extends Subscriber {

    SocialNetworkChannel channel;

    public FirstSubscriber(SocialNetworkChannel channel) {
       this.channel = channel;
        this.channel.accede(this);
    }

    @Override
    public void update() {
        System.out.println(this.getClass().getSimpleName() + " принял сообщение: " + channel.getMessage());
    }
}
