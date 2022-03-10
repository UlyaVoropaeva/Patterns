import java.util.Optional;
import java.util.logging.Logger;

public class DemoApp {
    private final static Logger LOGGER = Logger.getLogger(DemoApp.class.getName());

    public static void main(final String... args) throws DataMapperException {

        final UserDataMapper mapper = new UserDataMapperImpl();
        User user1 = new User(1, "user1@test.ru", "12345", "UserTest_1", "Test_1");
        User user2 = new User(2, "user2@test.ru", "54321", "UserTest_2", "Test_2");
        User user3 = new User(3, "user3@test.ru", "12945", "UserTest_3", "Test_3");
        mapper.insert(user1);
        LOGGER.info("user1: " + user1 + ", is inserted");
        mapper.insert(user2);
        LOGGER.info("user2: " + user2 + ", is inserted");
        mapper.insert(user3);
        LOGGER.info("user3: " + user3 + ", is inserted");


        final Optional<User> userToBeFound = mapper.find(user1.getId());
        LOGGER.info("user1: " + user1 + ", is searched");

        user2 = new User(user2.getId(), "TEST_user2@test.ru", "123456789", "UserTest_2", "Test_2");

        mapper.update(user2);
        LOGGER.info("user2: " + user2 + ", is updated");

        LOGGER.info("user3: " + user3 + ", is going to be deleted");
        mapper.delete(user3);
    }
}
