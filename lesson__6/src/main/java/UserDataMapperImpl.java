import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDataMapperImpl implements UserDataMapper {

    // имитация базы данных
    private List<User> users = new ArrayList<>();
    private UserIdentityMap userIdentityMap = new UserIdentityMap();

    public List<User> getUsers() {
        return this.users;
    }

    @Override
    public Optional<User> find(long userId) {
        User user = userIdentityMap.getUsers(userId);
        if (user == null) {

            for (final User usersFromDB : this.getUsers()) {
                if (usersFromDB.getId() == userId) {
                    userIdentityMap.addUser(user);
                    return Optional.of(user);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void insert(User userInsert) throws DataMapperException {

        User user = userIdentityMap.getUsers(userInsert.getId());
        if (user == null && !this.getUsers().contains(userInsert)) {
            this.getUsers().add(userInsert);
            userIdentityMap.addUser(userInsert);
        } else {
            throw new DataMapperException("User [" + userInsert.getEmail() + "] c");
        }
    }

    @Override
    public void update(User userUpdate) throws DataMapperException {

        User user = userIdentityMap.getUsers(userUpdate.getId());
        if (user != null) {
            userIdentityMap.deleteUser(userUpdate.getId());
        }
        if (this.getUsers().contains(userUpdate)) {
            final int index = this.getUsers().indexOf(userUpdate);
            this.getUsers().set(index, userUpdate);
            userIdentityMap.addUser(userUpdate);
        } else {
            throw new DataMapperException("User [" + userUpdate.getEmail() + "] is not found");
        }
    }

    @Override
    public void delete(User userDeleted) throws DataMapperException {

        User user = userIdentityMap.getUsers(userDeleted.getId());
        if (user != null) {
            userIdentityMap.deleteUser(userDeleted.getId());
        }

        if (this.getUsers().contains(userDeleted)) {
            this.getUsers().remove(userDeleted);
        } else {
            throw new DataMapperException("User [" + userDeleted.getEmail() + "] is not found");
        }
    }

}
