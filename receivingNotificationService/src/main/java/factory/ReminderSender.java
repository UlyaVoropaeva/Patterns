package factory;

import entity.User;
import inform.ChatSender;
import inform.EmailSender;
import inform.SmsSender;
import repository.Sender;

import java.util.Locale;

public class ReminderSender {

    public Sender createReminder(String type) {
        User user = new User();

        if (type == null || type.isEmpty()) return null; // вернуть null, если не указан тип

        type = type.toLowerCase(Locale.ROOT); // привести к нижнему регистру, чтобы не было "разночтений"

        // создать объект нужного типа или бросить исключение
        if ("sms".equals(type)) {
            return new SmsSender(user);
        } else if ("email".equals(type)) {
            return new EmailSender(user);
        } else if ("chat".equals(type)) {
            return new ChatSender(user);
        } else {
            throw new IllegalArgumentException(String.format("Unknown sender type %s", type));
        }

    }

}
