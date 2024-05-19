package daos;

import data.Db;
import exceptions.UserNotFoundException;
import models.User;
import models.User;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class UserDaoImpl implements UserDao {
    private final Db db = Db.getInstance();

    @Override
    public UUID insertUser(User user) {
        db.users.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public User getUser(UUID id) {
        User user = db.users.get(id);
        if (user == null) throw new UserNotFoundException();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) db.users.values();
    }

    @Override
    public void updateUser(User newUser) {
        User oldUser = db.users.get(newUser.getId());
        if (oldUser == null) throw new UserNotFoundException();
        db.users.put(newUser.getId(), newUser);
    }

    @Override
    public void deleteUser(UUID id) {
        User user = db.users.get(id);
        if (user == null) throw new UserNotFoundException();
        db.users.remove(id);
    }
}
