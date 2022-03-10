
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.Map;

public class UserIdentityMap {
    private final Logger LOGGER = Logger.getLogger(UserIdentityMap.class.getName());
    private Map<Long, User> userMap = new HashMap<>();

    // добавить пользователя в IdentityMap
    public void addUser(User user) {
        LOGGER.info("adding User info IdentityMap");
        userMap.put(user.getId(), user);
    }

    // получаем пользователя по ключу
    public User getUsers(Long id) {
        LOGGER.info("trying to find User in IdentityMap");
        return (User) userMap.get(id);
    }

    // удаляем пользователя из IdentityMap по ключу и вернуть удаленный объект
    public User deleteUser(Long idUser) {
        LOGGER.info("removing User from Identity Management");
        User user = userMap.get(idUser);
        userMap.remove(idUser);
        return user;
    }


}
