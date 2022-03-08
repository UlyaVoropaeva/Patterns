package Subscriber;

public class ThirdSubscriber extends Subscriber {

    SocialNetworkChannel channel;

    public ThirdSubscriber(SocialNetworkChannel subject){
        this.channel = subject;
        this.channel.accede(this);
    }

    @Override
    public void update() {
        System.out.println(this.getClass().getSimpleName() + " принял сообщение: " + channel.getMessage());
    }

}
