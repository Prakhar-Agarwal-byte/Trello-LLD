package daos;

import models.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    UUID insertUser(User user);
    User getUser(UUID id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(UUID id);
}
