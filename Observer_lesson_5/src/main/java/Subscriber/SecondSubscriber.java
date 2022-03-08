package Subscriber;


public class SecondSubscriber extends Subscriber {

    SocialNetworkChannel channel;

    public SecondSubscriber(SocialNetworkChannel subject){
        this.channel = subject;
        this.channel.accede(this);
    }

    @Override
    public void update() {
        System.out.println(this.getClass().getSimpleName() + " принял сообщение: " + channel.getMessage());
    }

}
