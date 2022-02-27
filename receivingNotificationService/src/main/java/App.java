import factory.ReminderSender;
import repository.Sender;


public class App {
    public static void main(String[] args) {

        ReminderSender reminderSender = new ReminderSender();
        Sender sender;
        sender = reminderSender.createReminder("SMS");
        sender.sender();
        sender = reminderSender.createReminder("Email");
        sender.sender();
        sender = reminderSender.createReminder("Chat");
        sender.sender();
    }
}
